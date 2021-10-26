package com.example.fragmentxuligiaodien;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class FragmentStudent extends ListFragment {

    List<SinhVien> list;
    SinhVienAdapter sinhVienAdapter;
    TruyenDuLieu truyenDuLieu;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        truyenDuLieu = (TruyenDuLieu) getActivity();
        list = new ArrayList<>();
        khoiTaoDS();
        sinhVienAdapter = new SinhVienAdapter(list, R.layout.sinhvien, getActivity());
        setListAdapter(sinhVienAdapter);

        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        truyenDuLieu.dataSinhVien(list.get(position));
        super.onListItemClick(l, v, position, id);

    }

    private void khoiTaoDS() {
        list.add(new SinhVien(2001, "Ha Noi", "Nguyen Van A"));
        list.add(new SinhVien(2002, "Ha Ninh", "Nguyen Van B"));
        list.add(new SinhVien(2003, "Ha Tay", "Nguyen Van C"));
        list.add(new SinhVien(2004, "Ho Chi Minh", "Nguyen Van D"));
        list.add(new SinhVien(2005, "Hai Phong", "Nguyen Van E"));
        list.add(new SinhVien(2006, "Hai Duong", "Nguyen Van F"));

    }

}
