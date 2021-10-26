package com.example.fragmentxuligiaodien;

public class SinhVien {
    private int namsinh;
    private String diachi,hoten;

    public SinhVien(int namsinh, String diachi, String hoten) {
        this.namsinh = namsinh;
        this.diachi = diachi;
        this.hoten = hoten;
    }

    public int getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(int namsinh) {
        this.namsinh = namsinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }
}
