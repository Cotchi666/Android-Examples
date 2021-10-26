package com.example.fragmentxuligiaodien;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Fragment_StudentInfo extends Fragment {
    TextView textView_ten, textView_ns, textView_dc;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.thong_tin_sv, container, false);
        textView_ten = view.findViewById(R.id.textView_name);
        textView_ns = view.findViewById(R.id.textView_ns);
        textView_dc = view.findViewById(R.id.textView_dc);
        return view;
    }

    public void setDaTa(SinhVien sinhVien) {
        textView_ten.setText(sinhVien.getHoten());
        textView_ns.setText(sinhVien.getNamsinh() + "");
        textView_dc.setText(sinhVien.getDiachi());
    }
}
