package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView_title;
    Button button_change;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView_title = findViewById(R.id.textView_title);
        button_change = findViewById(R.id.button_change);
        button_change.setOnClickListener(view -> {
            /*Fragment_A fragment_a = (Fragment_A) getFragmentManager().findFragmentById(R.id.fragment_a);
            fragment_a.textView.setText("es");*/
        });



    }


    /*public void addFragment(View view) {
        Fragment fragment = null;
        switch (view.getId()) {
            case R.id.button_A:
                fragment = new Fragment_A();
                break;
            case R.id.button_B:
                fragment = new Fragment_B();
                break;
        }
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }*/

}