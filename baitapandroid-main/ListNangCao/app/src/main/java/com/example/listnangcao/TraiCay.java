package com.example.listnangcao;

public class TraiCay {
    private String name, mota;
    private int hinhanh;

    public TraiCay(String name, String mota, int hinhanh) {
        this.name = name;
        this.mota = mota;
        this.hinhanh = hinhanh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public int getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(int hinhanh) {
        this.hinhanh = hinhanh;
    }
}
