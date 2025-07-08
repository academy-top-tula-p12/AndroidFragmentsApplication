package com.example.androidfragmentsapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CityListFragment extends Fragment {

    interface OnFragmentSendData{
        void onSendData(String data);
    }
    OnFragmentSendData onFragmentSendData;
    String[] cities = { "Moscow", "St Petersburg", "Novosibirsk" };

    public CityListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try{
            onFragmentSendData = (OnFragmentSendData) context;
        }
        catch(Exception ex){
            try {
                throw new Exception("Type context not OnFragmentSendData");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_city_list, container, false);

        ListView listViewCityList = view.findViewById(R.id.listViewCityList);
        ArrayAdapter<String> adapterCityList
                = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, cities);
        listViewCityList.setAdapter(adapterCityList);
        listViewCityList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String selectedItem = (String)adapterView.getItemAtPosition(position);
                onFragmentSendData.onSendData(selectedItem);
            }
        });

        return view;
    }
}