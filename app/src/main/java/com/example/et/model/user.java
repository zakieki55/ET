package com.example.et.model;

public class user {
    private String id, namaBarang, ukuran, tawaran, status;

    public user(){

    }
    public  user(String namaBarang, String ukuran, String tawaran, String status){
        this.namaBarang = namaBarang;
        this.ukuran = ukuran;
        this.tawaran = tawaran;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getUkuran() {
        return ukuran;
    }

    public void setUkuran(String ukuran) {
        this.ukuran = ukuran;
    }

    public String getTawaran() {
        return tawaran;
    }

    public void setTawaran(String tawaran) {
        this.tawaran = tawaran;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
