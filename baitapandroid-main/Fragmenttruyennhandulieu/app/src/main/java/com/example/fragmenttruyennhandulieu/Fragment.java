package com.example.fragmenttruyennhandulieu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Fragment extends android.app.Fragment {
    TextView textView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, container, false);
        textView = view.findViewById(R.id.textView_ten);
        Bundle bundle = getArguments();
        textView.setText(bundle.getString("dulieu").trim());

        return view;

    }
}
