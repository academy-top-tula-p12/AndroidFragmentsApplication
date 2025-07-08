package com.example.androidfragmentsapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HelloFragment extends Fragment {

    public HelloFragment(){
        super(R.layout.fragment_layout);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Lifecycle ", "onCreate");
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button buttonHello = view.findViewById(R.id.buttonHello);
        EditText editTextHello = view.findViewById(R.id.editTextHello);
        TextView textViewHello = view.findViewById(R.id.textViewHello);

        buttonHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewHello.setText("Hello " + editTextHello.getText());
                editTextHello.setText("");
            }
        });
    }
}
