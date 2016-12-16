package com.example.afrizal.pantauinfolab;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by AFRIZAL on 12/11/2016.
 */
public class main extends Activity {

    @Override
    protected void onCreate(Bundle SavedInstanceState){
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.list);
        String[] buah = new String[]{"Apel","Nangka","Belimbing","Jambu","Pisang","Jeruk","Mangga","Duren"};
        final ListView simplelist = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapterbuah = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,buah);

        simplelist.setAdapter(adapterbuah);
        simplelist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itemposition = position;
                String value = (String) simplelist.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(),"Position : "+position+" Value: "+value, Toast.LENGTH_SHORT).show();
            }
        });

    }





}
