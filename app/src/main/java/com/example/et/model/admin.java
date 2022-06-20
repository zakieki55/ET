package com.example.et.model;

public class admin {
    private String id, namaBarang, ukuran, setHarga;

    public admin(){

    }
    public  admin(String namaBarang, String ukuran, String setHarga){
        this.namaBarang = namaBarang;
        this.ukuran = ukuran;
        this.setHarga = setHarga;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getNamaBarang(){
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

    public String getSetHarga() {
        return setHarga;
    }

    public void setSetHarga(String setHarga) {
        this.setHarga = setHarga;
    }
}
