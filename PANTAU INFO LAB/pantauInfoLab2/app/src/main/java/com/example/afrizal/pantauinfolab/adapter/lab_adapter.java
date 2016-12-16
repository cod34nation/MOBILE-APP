package com.example.afrizal.pantauinfolab.adapter;

/**
 * Created by AFRIZAL on 12/4/2016.
 */

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.afrizal.pantauinfolab.Data.data_lab;
import com.example.afrizal.pantauinfolab.R;

import java.util.List;


/**
 * Created by AFRIZAL on 12/4/2016.
 */
import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.afrizal.pantauinfolab.R;
import com.example.afrizal.pantauinfolab.app.AppController;
import com.example.afrizal.pantauinfolab.Data.data_lab;

import java.util.List;

/**
 * Created by Kuncoro on 26/03/2016.
 */
public class lab_adapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<data_lab> items;

    public lab_adapter(Activity activity, List<data_lab> items) {
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
            convertView = inflater.inflate(R.layout.list_row_lab, null);

        TextView id_lab = (TextView) convertView.findViewById(R.id.id_lab);
        TextView nama_lab = (TextView) convertView.findViewById(R.id.nama_lab);
        TextView status = (TextView) convertView.findViewById(R.id.status);
        TextView penanggung_jawab=(TextView) convertView.findViewById(R.id.penanggung_jawab);


        data_lab data = items.get(position);

        id_lab.setText(data.getId());
        nama_lab.setText(data.getNamaLab());
        status.setText(data.getStatus());
        penanggung_jawab.setText(data.getPenanggung_jawab());


        return convertView;
    }

}