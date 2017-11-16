package com.example.timz.belajarlist;

/**
 * Created by Timz on 11/1/2017.
 */

public class Makanan {
    private int imageId;
    private String nama;
    private double harga;

    public Makanan(int imageId, String nama, double harga) {
        this.imageId = imageId;
        this.nama = nama;
        this.harga = harga;
    }

    public int getImageId() {
        return imageId;
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }
}
