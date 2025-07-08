package com.example.androidfragmentsapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CityDetailFragment extends Fragment {

    public CityDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_city_detail, container, false);
    }

    public void setCityData(String city){
        TextView textViewCityDetail = getView().findViewById(R.id.textViewCityDetail);
        textViewCityDetail.setText(city);
    }
}