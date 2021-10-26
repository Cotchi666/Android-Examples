package com.example.fragmentxuligiaodien;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements TruyenDuLieu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void dataSinhVien(SinhVien sinhVien) {
        Fragment_StudentInfo fragmentManager = (Fragment_StudentInfo) getFragmentManager().findFragmentById(R.id.frament_info);
        fragmentManager.setDaTa(sinhVien);


    }

}