package com.example.sqliteluuhinhanh;

public class DoVat {
    private String name, mota;
    private int id;
    private byte[] hinh;

    public DoVat(String name, String mota, int id, byte[] hinh) {
        this.name = name;
        this.mota = mota;
        this.id = id;
        this.hinh = hinh;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHinh(byte[] hinh) {
        this.hinh = hinh;
    }

    public String getName() {
        return name;
    }


    public String getMota() {
        return mota;
    }


    public byte[] getHinh() {
        return hinh;
    }

}
