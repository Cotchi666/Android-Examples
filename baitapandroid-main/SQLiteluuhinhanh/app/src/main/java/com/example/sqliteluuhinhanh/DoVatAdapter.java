package com.example.sqliteluuhinhanh;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DoVatAdapter extends BaseAdapter {
    private List<DoVat> list;
    private Context context;
    private int latout;

    public DoVatAdapter(List<DoVat> list, Context context, int latout) {
        this.list = list;
        this.context = context;
        this.latout = latout;
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
        ImageView imageView_ha;
        TextView textView_tendv, textView_mota;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(latout, null);

            viewHolder.imageView_ha = view.findViewById(R.id.imageView_ha);
            viewHolder.textView_tendv = view.findViewById(R.id.textView_tendv);
            viewHolder.textView_mota = view.findViewById(R.id.textView_mota);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        DoVat doVat = list.get(i);
        viewHolder.textView_tendv.setText(doVat.getName());
        viewHolder.textView_mota.setText(doVat.getMota());
        viewHolder.imageView_ha.setImageBitmap(chyenByteSangBitMap(doVat.getHinh()));
        return view;
    }

    //chuyen byte ---> bitmap
    private Bitmap chyenByteSangBitMap(byte[] bytes) {
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);

    }
}
