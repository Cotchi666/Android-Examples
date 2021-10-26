package com.example.fragmenttruyennhandulieu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView_title;
    Button button_add, button_remove;
    FragmentManager fragmentManager = getFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView_title = findViewById(R.id.textview_title);
        button_add = findViewById(R.id.button_chuyen);
        button_remove = findViewById(R.id.button_xoa);




        button_add.setOnClickListener(view -> {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    Fragment fragment = new Fragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("dulieu", "Huong dep trai");
                    fragment.setArguments(bundle);
                    fragmentTransaction.add(R.id.linerLayout, fragment, "alo");
                    fragmentTransaction.commit();
                }
        );

        button_remove.setOnClickListener(view -> {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Fragment fragment = (Fragment) getFragmentManager().findFragmentByTag("alo");
            fragmentTransaction.remove(fragment);
            fragmentTransaction.commit();
        });
    }
}