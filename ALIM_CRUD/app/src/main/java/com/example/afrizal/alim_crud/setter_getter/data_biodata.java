package com.example.afrizal.alim_crud.setter_getter;

/**
 * Created by AFRIZAL on 12/14/2016.
 */
public class data_biodata {
    private String id, nama, alamat;

    public data_biodata() {
    }

    public data_biodata(String id, String nama, String alamat) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}