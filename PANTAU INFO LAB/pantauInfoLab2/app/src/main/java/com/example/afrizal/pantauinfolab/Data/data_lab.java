package com.example.afrizal.pantauinfolab.Data;

/**
 * Created by AFRIZAL on 12/1/2016.
 */

public class data_lab {

    private String id_client, jam, tanggal,hari,nama_lab,penanggung_jawab,status;

    public data_lab() {
    }

    public data_lab(String id_client,String hari, String jam, String tanggal,String status,String nama_lab,String penanggung_jawab) {
        this.id_client  = id_client;
        this.jam = jam;
        this.tanggal = tanggal;

        this.status=status;
        this.nama_lab=nama_lab;
        this.hari=hari;
        this.penanggung_jawab=penanggung_jawab;
    }

    public String getId() {
        return id_client;
    }

    public void setId(String id_client) {
        this.id_client = id_client;
    }

    public String getjam() {
        return jam;
    }


    public void setjam(String jam) {
        this.jam = jam;
    }

    public String gettanggal() {
        return tanggal;
    }

    public void settanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }


    public String getNamaLab() {
        return nama_lab;
    }


    public void setNama_lab(String nama_lab) {
        this.nama_lab = nama_lab;}

    public String getPenanggung_jawab() {
        return penanggung_jawab;
    }
    public void setPenanggung_jawab(String penanggung_jawab) {
        this.penanggung_jawab = penanggung_jawab;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {


        if(status.equals("0")) {

            status="Kosong";


        }
        else{

            status="Dipakai";

        }
        this.status = status;

    }







}
