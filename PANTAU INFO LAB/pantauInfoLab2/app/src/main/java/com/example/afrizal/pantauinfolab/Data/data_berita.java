package com.example.afrizal.pantauinfolab.Data;

/**
 * Created by AFRIZAL on 12/4/2016.
 */
public class data_berita {
    private String id_info,judul,tanggal_post,isi_berita;

    public data_berita() {
    }

    public data_berita(String id_info,String judul,String tanggal_post,String isi_berita) {
        this.id_info=id_info;
        this.judul=judul;
        this.tanggal_post=tanggal_post;
        this.isi_berita=isi_berita;
    }

    public String getId() {
        return id_info;
    }

    public void setId(String id_info) {
        this.id_info=id_info;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getIsi_berita() {
        return isi_berita;
    }

    public void setIsi_berita(String isi_berita) {
        this.isi_berita = isi_berita;
    }

    public  String getTanggalPost(){
        return tanggal_post;
    }

    public  void setTanggal_post(String tanggal_post){
        this.tanggal_post=tanggal_post;
    }



}