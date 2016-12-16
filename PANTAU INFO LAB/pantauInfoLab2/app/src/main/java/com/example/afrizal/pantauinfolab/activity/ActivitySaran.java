package com.example.afrizal.pantauinfolab.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.Request.Method;


import com.example.afrizal.pantauinfolab.R;
import com.example.afrizal.pantauinfolab.app.AppConfig;
import com.example.afrizal.pantauinfolab.app.AppController;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by AFRIZAL on 12/12/2016.
 */

public class ActivitySaran extends Activity {
    private static final String TAG = ActivitySaran.class.getSimpleName();
    private static final String URL_KIRIM= AppConfig.URL+"saran.php";
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";

    public static final String TAG_ID_CLIENT= "id_client";
    public static final String TAG_JUDUL = "judul";
    public static final String TAG_ISI = "isi";
    public static final String TAG_TANGGAL_POST= "tanggal_post";
    private ProgressDialog pDialog;

    String tag_json_obj = "json_obj_req";
    EditText txt_id_client,txt_judul,txt_isi;
    TextView  txt_tanggal ;
    Button btnSaran;

    FloatingActionButton fab;
    ListView list;
    SwipeRefreshLayout swipe;
    int success;
    String isi, judul,Tanggal_post,id_client;



    @Override
    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saran);
        fab = (FloatingActionButton) findViewById(R.id.fab_add);
        swipe = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        btnSaran=(Button)findViewById(R.id.btn_kirim);
        txt_id_client = (EditText)findViewById(R.id.id_client);
        txt_judul=(EditText)findViewById(R.id.id_judul);
        txt_isi=(EditText)findViewById(R.id.id_isi);
        txt_tanggal=(TextView)findViewById(R.id.id_tanggal_post);
        txt_tanggal.setText(tanggal());

        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);






        btnSaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String ID_CLIENT=txt_id_client.getText().toString().trim();
                String JUDUL=txt_judul.getText().toString().trim();
                String ISI=txt_isi.getText().toString().trim();
                String TANGGAL_POST=txt_tanggal.getText().toString().trim();

                if(!ID_CLIENT.isEmpty()&&!JUDUL.isEmpty()&&!ISI.isEmpty()){
                    kirim(ID_CLIENT,JUDUL,ISI,TANGGAL_POST);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Tidak boleh ada fieldyang kosong",Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    private String tanggal(){
        DateFormat tgl = new SimpleDateFormat("yyyy/MM/dd");
        Date date=new Date();
        return tgl.format(date);


    }

    private void kirim(final String ID_CLIENT, final String JUDUL,final String ISI, final String TANGGAL_POST){

        String url= URL_KIRIM;
        StringRequest strReq = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Response: " + response.toString());
                String tag_string_req = "req_register";



                try {
                    JSONObject jObj = new JSONObject(response);
                    success = jObj.getInt(TAG_SUCCESS);

                    // Cek error node pada json
                    if (success == 1) {
                        Log.d("Add/update", jObj.toString());


                        Toast.makeText(ActivitySaran.this, jObj.getString(TAG_MESSAGE), Toast.LENGTH_LONG).show();


                    } else {
                        Toast.makeText(ActivitySaran.this, jObj.getString(TAG_MESSAGE), Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    // JSON error
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Error: " + error.getMessage());
                Toast.makeText(ActivitySaran.this, error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting parameters ke post url
                Map<String, String> params = new HashMap<String, String>();

                params.put("id_client",ID_CLIENT);
                params.put("judul",JUDUL);
                params.put("isi",ISI);
                params.put("tanggal_post",TANGGAL_POST);
                return params;
            }

        };

        AppController.getInstance().addToRequestQueue(strReq, tag_json_obj);
    }
    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }
    }



