package com.example.afrizal.pantauinfolab.adapter;

/**
 * Created by AFRIZAL on 12/8/2016.
 */
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.afrizal.pantauinfolab.Data.data_kios;
import com.example.afrizal.pantauinfolab.R;

import java.util.List;


public class kios_adapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<data_kios> items;

    public kios_adapter(Activity activity, List<data_kios> items) {
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







        return convertView;
    }

}
