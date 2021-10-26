package com.example.demowebserver;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SinhVienAdapter extends BaseAdapter {
    private MainActivity context;
    private List<SinhVien> list;
    private int layout;
    private int id;


    public SinhVienAdapter(MainActivity context, List<SinhVien> list, int layout) {
        this.context = context;
        this.list = list;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder {
        TextView textView_ten, textView_ns, textView_diachi;
        ImageView imageView_xoa, imageView_sua;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        SinhVien sinhVien = list.get(i);
        if (view == null) {
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(layout, null);

            viewHolder.textView_ten = view.findViewById(R.id.textView_ten);
            viewHolder.textView_ns = view.findViewById(R.id.textView_ns);
            viewHolder.textView_diachi = view.findViewById(R.id.textView_diachi);
            viewHolder.imageView_xoa = view.findViewById(R.id.imageView_xoa);
            viewHolder.imageView_sua = view.findViewById(R.id.imageView_sua);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.textView_ten.setText("Ho ten: " + sinhVien.getHoten());
        viewHolder.textView_ns.setText("Nam sinh: " + sinhVien.getNamsinh());
        viewHolder.textView_diachi.setText("Dia chi: " + sinhVien.getDiachi());

        id = sinhVien.getId();

        viewHolder.imageView_sua.setOnClickListener(view1 -> {

            Intent intent = new Intent(context, UpdateActivity.class);
            intent.putExtra("dataSV", sinhVien);
            context.startActivity(intent);
        });
        viewHolder.imageView_xoa.setOnClickListener(view1 -> {
            dialogSinhVien();
        });
        return view;
    }

    private void dialogSinhVien() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("Ban chac chan muon xoa?");
        builder.setNegativeButton("Khong", (dialogInterface, i) -> {

        });
        builder.setPositiveButton("co", (dialogInterface, i) -> {
            context.removeSinhVien("http://tpqseven.atwebpages.com/remove.php",id);

        });
        builder.show();

    }


}
