package com.example.demowebserver;

import java.io.Serializable;

public class SinhVien implements Serializable {
    private int id;
    private String diachi, hoten;
    private int namsinh;

    public SinhVien(int id, String hoten, int namsinh, String diachi) {
        this.id = id;
        this.diachi = diachi;
        this.hoten = hoten;
        this.namsinh = namsinh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(int namsinh) {
        this.namsinh = namsinh;
    }
}
