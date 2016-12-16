package com.example.afrizal.jsonlistview.Model;

/**
 * Created by AFRIZAL on 12/15/2016.
 */
import com.google.gson.annotations.SerializedName;

import io.realm.Realm;
import io.realm.RealmObject;

public class ModelPhoto extends RealmObject {

    @SerializedName("nama")public String nama;
    @SerializedName("foto")public String foto;
}
