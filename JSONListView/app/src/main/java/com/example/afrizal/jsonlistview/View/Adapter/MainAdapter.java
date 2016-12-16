package com.example.afrizal.jsonlistview.View.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.afrizal.jsonlistview.Model.ModelPhoto;
import com.example.afrizal.jsonlistview.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by AFRIZAL on 12/15/2016.
 */
public class MainAdapter extends BaseAdapter {

    List<ModelPhoto>photos;
    Context context;
    LayoutInflater inflater;


    public MainAdapter(Context context, List<ModelPhoto> photos) {
        this.photos = photos;
        this.context = context;
        this.inflater = LayoutInflater.from(context);


    }

    @Override
    public int getCount() {

       return photos.size();
    }

    @Override
    public Object getItem(int i) {
        return photos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(inflater==null){
            inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if(view==null){
            view = inflater.inflate(R.layout.item_listview,null);

        }

        ImageView foto =(ImageView)view.findViewById(R.id.list_photo);
        TextView nama=(TextView)view.findViewById(R.id.item_nama);
        Picasso.with(context).load(photos.get(i).foto).into(foto);
        nama.setText(photos.get(i).nama);
        final String stringNama=photos.get(i).nama;

        view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                Toast.makeText(context,"NAMA \n"+stringNama,Toast.LENGTH_SHORT).show();

            }

        }
        );


        return view;
    }


}
