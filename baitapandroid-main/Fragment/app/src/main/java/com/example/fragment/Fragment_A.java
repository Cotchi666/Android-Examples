package com.example.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Fragment_A extends Fragment {
    TextView textView;
    EditText editText;
    Button button;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        textView = view.findViewById(R.id.textview_A);
        editText = view.findViewById(R.id.edit_A);
        button = view.findViewById(R.id.button_A);
        
        button.setOnClickListener(view1 -> {
            TextView textView_Main = getActivity().findViewById(R.id.textView_title);
            textView_Main.setText(editText.getText().toString().trim());
        });

        return view;
    }
}

