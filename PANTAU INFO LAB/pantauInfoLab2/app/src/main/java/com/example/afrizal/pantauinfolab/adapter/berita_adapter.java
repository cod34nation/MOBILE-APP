package com.example.afrizal.pantauinfolab.adapter;

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
import com.example.afrizal.pantauinfolab.Data.data_berita;

import java.util.List;

/**
 * Created by Kuncoro on 26/03/2016.
 */
public class berita_adapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<data_berita> items;

    public berita_adapter(Activity activity, List<data_berita> items) {
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
            convertView = inflater.inflate(R.layout.list_row_berita, null);

        TextView id_berita = (TextView) convertView.findViewById(R.id.id_berita);
        TextView judul = (TextView) convertView.findViewById(R.id.judul);
        TextView tanggal_post = (TextView) convertView.findViewById(R.id.tanggal_post);
        TextView isi_berita=(TextView)convertView.findViewById(R.id.isi);

        data_berita data = items.get(position);

        id_berita.setText(data.getId());
        judul.setText(data.getJudul());
        tanggal_post.setText(data.getTanggalPost());
        isi_berita.setText(data.getIsi_berita());


        return convertView;
    }

}