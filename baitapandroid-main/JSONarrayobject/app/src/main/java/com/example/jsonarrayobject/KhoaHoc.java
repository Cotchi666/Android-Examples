package com.example.jsonarrayobject;

import android.graphics.Bitmap;

public class KhoaHoc {
    private String khoahoc, hocphi;
    private Bitmap bitmap;

    public String getKhoahoc() {
        return khoahoc;
    }


    public String getHocphi() {
        return hocphi;
    }


    public Bitmap getBitmap() {
        return bitmap;
    }


    public KhoaHoc(String khoahoc, String hocphi, Bitmap bitmap) {
        this.khoahoc = khoahoc;
        this.hocphi = hocphi;
        this.bitmap = bitmap;
    }
}
