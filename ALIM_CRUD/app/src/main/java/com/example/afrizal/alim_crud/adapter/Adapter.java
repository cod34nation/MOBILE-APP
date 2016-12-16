package com.example.afrizal.alim_crud.adapter;

/**
 * Created by AFRIZAL on 12/14/2016.
 */
import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.afrizal.alim_crud.R;
import com.example.afrizal.alim_crud.app.controller;
import com.example.afrizal.alim_crud.setter_getter.data_biodata;

import java.util.List;

/**
 * Created by Kuncoro on 26/03/2016.
 */
public class Adapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<data_biodata> items;

    TextView id,nama,alamat;


    public Adapter(Activity activity, List<data_biodata> items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int location) {
        return items.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_row, null);

      id = (TextView) convertView.findViewById(R.id.id);
        nama = (TextView) convertView.findViewById(R.id.nama);
         alamat = (TextView) convertView.findViewById(R.id.alamat);

        data_biodata data = items.get(position);

        id.setText(data.getId());
        nama.setText(data.getNama());
        alamat.setText(data.getAlamat());

        return convertView;
    }

}