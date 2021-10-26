package com.example.mediaappmusic;

public class Song {
    private String tenBaiHat;
    private int file;

    public Song(String tenBaiHat, int file) {
        this.tenBaiHat = tenBaiHat;
        this.file = file;
    }

    public String getTenBaiHat() {
        return tenBaiHat;
    }

    public void setTenBaiHat(String tenBaiHat) {
        this.tenBaiHat = tenBaiHat;
    }

    public int getFile() {
        return file;
    }

    public void setFile(int file) {
        this.file = file;
    }
}
