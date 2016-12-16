package com.example.afrizal.jsonlistview.View.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.afrizal.jsonlistview.BaseAPI;
import com.example.afrizal.jsonlistview.Model.ModelPhoto;
import com.example.afrizal.jsonlistview.R;
import com.example.afrizal.jsonlistview.View.Adapter.MainAdapter;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    BaseAPI baseAPI;
    ListView listView;
    ProgressBar progressBar;

    RealmConfiguration realmConfiguration;
    Realm realm;
    TextView not_found;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        baseAPI = BaseAPI.Factory.create();
        assignUIElements();
        loadPhoto();
        Realm.init(this);

        realmConfiguration = new RealmConfiguration.Builder(this).build();
        realm = Realm.getInstance(realmConfiguration);

        //CEK DATA LOKAL

        RealmResults<ModelPhoto> photos = realm.where(ModelPhoto.class).findAll();

        if(photos.size()<=0){
            loadPhoto();
        }
        else{
            MainAdapter adapter= new MainAdapter(MainActivity.this,photos);
            listView.setAdapter(adapter);
            listView.setVisibility(View.VISIBLE);
            not_found.setVisibility(View.GONE);

        }

    }
    private void assignUIElements(){
        listView =(ListView)findViewById(R.id.listview);
        progressBar= (ProgressBar)findViewById(R.id.id_progressBar);
        progressBar.setVisibility(View.GONE);

        not_found = (TextView)findViewById(R.id.not_found);
    }
        private void loadPhoto(){
            showProgress();
            Call<List<ModelPhoto>> photoList=baseAPI.GetPhotoList();
           photoList.enqueue(new Callback<List<ModelPhoto>>() {
               @Override
               public void onResponse(Call<List<ModelPhoto>> call, Response<List<ModelPhoto>> response) {
                   MainAdapter adapter=new MainAdapter(MainActivity.this,response.body());
                   listView.setAdapter(adapter);

                   // Menyimpan di Lokal

                   for (int i =0; i<=response.body().size();i++){
                       realm.beginTransaction();

                        ModelPhoto modelPhoto= realm.createObject(ModelPhoto.class);
                        modelPhoto.nama = response.body().get(i).nama;
                        modelPhoto.foto = response.body().get(i).foto;
                       realm.commitTransaction();
                   }

                listView.setVisibility(View.VISIBLE);
               }

               @Override
               public void onFailure(Call<List<ModelPhoto>> call, Throwable t) {

                   System.out.println(">>Gagal Load Photo");
                   System.out.println(">> "+t.getMessage());

                   closeProgress();

                   not_found.setVisibility(View.VISIBLE);

               }
           });

        }
    private void showProgress(){
        progressBar.setVisibility(View.VISIBLE);
    }
    private  void closeProgress(){
        progressBar.setVisibility(View.GONE);
    }


}
