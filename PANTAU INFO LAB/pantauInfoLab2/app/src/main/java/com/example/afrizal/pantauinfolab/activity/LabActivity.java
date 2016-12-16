package com.example.afrizal.pantauinfolab.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.example.afrizal.pantauinfolab.R.id.*;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.afrizal.pantauinfolab.Data.data_lab;
import com.example.afrizal.pantauinfolab.MainActivity;
import com.example.afrizal.pantauinfolab.R;

import com.example.afrizal.pantauinfolab.adapter.lab_adapter;
import com.example.afrizal.pantauinfolab.app.AppConfig;
import com.example.afrizal.pantauinfolab.app.AppController;
import com.example.afrizal.pantauinfolab.helper.SQLiteHandler;
import com.example.afrizal.pantauinfolab.helper.SessionManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Timer;

/**
 * Created by AFRIZAL on 12/2/2016.
 */
public class LabActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    FloatingActionButton fab;
    ListView list;
    SwipeRefreshLayout swipe;
    List<data_lab> itemList = new ArrayList<data_lab>();
    lab_adapter adapter;
    int success;
    AlertDialog.Builder dialog;
    LayoutInflater inflater;
    View dialogView;





    String ID_lab, nama_lab, Tanggal_pinjam,status,nama_penanggug_jawab,id_client,hari,jam_total,jam,menit;

    private static final String TAG = LabActivity.class.getSimpleName();
    private SQLiteHandler db;
    private SessionManager session;


    private static String url_select = AppConfig.URL + "tampil_lab.php";
    private static String url_pinjam = AppConfig.URL + "pinjam_lab.php";


    public static final String TAG_ID_LAB= "id_lab";
    public static final String TAG_NAMA_LAB = "nama_lab";
    public static final String TAG_PENANGGUNG= "penanggung_jawab";
    public static final String TAG_STATUS = "status";

    public static final String TAG_ID_CLIENT= "id_client";
    public static final String TAG_JAM = "jam_pemakaian";
    public static final String TAG_TANGGAL_PINJAM= "Tanggal_pinjam";
    public static final String TAG_HARI = "hari";



    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";

    String tag_json_obj = "json_obj_req";
    EditText txt_id_client;
    TextView id_nama_lab,tanggal_pinjamLab,jam_pinjam,id_Lab,txt_jam;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lab_layout);


        // menghubungkan variablel pada layout dan pada java
        fab = (FloatingActionButton) findViewById(R.id.fab_add);
        swipe = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        list = (ListView) findViewById(R.id.list);







        // untuk mengisi data dari JSON ke dalam adapter
        adapter = new lab_adapter(LabActivity.this, itemList);
        list.setAdapter(adapter);
        // SqLite database handler
        db = new SQLiteHandler(getApplicationContext());

        // session manager
        session = new SessionManager(getApplicationContext());




        // Fetching user details from sqlite
        HashMap<String, String> user = db.getUserDetails();

       // final String name = user.get("name");

        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itemposition = position;
                String value = itemList.get(position).getNamaLab();
                String tanggal=tanggal();
                String jam_pinjam =jam();
                String id_lab=itemList.get(position).getId();
                String status=itemList.get(position).getStatus();
                String ID="";


                Toast.makeText(getApplicationContext(),"Position : "+position+" Value: "+value, Toast.LENGTH_SHORT).show();
                DialogForm(value,ID,id_lab, tanggal, jam_pinjam,status,"BOKING");
            }
        });

        // menamilkan widget refresh
        swipe.setOnRefreshListener(this);

        swipe.post(new Runnable() {
                       @Override
                       public void run() {
                           swipe.setRefreshing(true);
                           itemList.clear();
                           adapter.notifyDataSetChanged();
                           callVolley();
                       }
                   }
        );

        // fungsi floating action button memanggil form biodata
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogForm("","","", "", "","", "SIMPAN");
            }
        });


    }




    //tanggal
    private String tanggal(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        return dateFormat.format(date);
    }
    private String jam(){
        String nol_jam = "", nol_menit = "",nol_detik = "";

        java.util.Date dateTime = new java.util.Date();
        int nilai_jam = dateTime.getHours();
        int nilai_menit = dateTime.getMinutes();
        int nilai_detik = dateTime.getSeconds();

        if(nilai_jam <= 9) nol_jam= "0";
        if(nilai_menit <= 9) nol_menit= "0";
        if(nilai_detik <= 9) nol_detik= "0";


        jam = nol_jam + Integer.toString(nilai_jam);
        menit = nol_menit + Integer.toString(nilai_menit);

        jam_total=jam+":"+menit;

        return jam_total;

    }
    // untuk menampilkan dialog from biodata
    private void DialogForm(String nama_lab,String idx, String id_lab, String tanggal_pinjamX, String jamX,String status,String Button) {
        dialog = new AlertDialog.Builder(LabActivity.this);
        inflater = getLayoutInflater();
        dialogView = inflater.inflate(R.layout.form_pinjam, null);
        dialog.setView(dialogView);
        dialog.setCancelable(true);
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setTitle("Form Peminjaman");



        txt_id_client =(EditText)dialogView.findViewById(R.id.ID);
        txt_id_client.setText(idx);



        id_Lab=(TextView)dialogView.findViewById(R.id.id_Lab);
        id_Lab.setText(id_lab);

        id_nama_lab= (TextView)dialogView.findViewById(R.id.id_nama_lab);
        id_nama_lab.setText(nama_lab);



        tanggal_pinjamLab=(TextView)dialogView.findViewById(R.id.txt_tanggal);
        tanggal_pinjamLab.setText(tanggal_pinjamX);

        jam_pinjam=(TextView)dialogView.findViewById(R.id.txt_jam);
        jam_pinjam.setText(jamX);


        dialog.setPositiveButton(Button, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                ID_lab = id_Lab.getText().toString();

                id_client      = txt_id_client.getText().toString();

                jam = jam_pinjam.getText().toString();
                Tanggal_pinjam=tanggal_pinjamLab.getText().toString();

                simpan_update();
                dialog.dismiss();
            }
        });


        dialog.setNegativeButton("BATAL", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();

            }
        });

        dialog.show();
    };





        // fungsi untuk menyimpan atau update
        private void simpan_update() {

            String url= url_pinjam;



            StringRequest strReq = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {

                @Override
                public void onResponse(String response) {
                    Log.d(TAG, "Response: " + response.toString());

                    try {
                        JSONObject jObj = new JSONObject(response);
                        success = jObj.getInt(TAG_SUCCESS);

                        // Cek error node pada json
                        if (success == 1) {
                            Log.d("Add/update", jObj.toString());

                            callVolley();

                            Toast.makeText(LabActivity.this, jObj.getString(TAG_MESSAGE), Toast.LENGTH_LONG).show();
                            adapter.notifyDataSetChanged();

                        } else {
                            Toast.makeText(LabActivity.this, jObj.getString(TAG_MESSAGE), Toast.LENGTH_LONG).show();
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
                    Toast.makeText(LabActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
                }
            }) {

                @Override
                protected Map<String, String> getParams() {
                    // Posting parameters ke post url
                    Map<String, String> params = new HashMap<String, String>();
                    // jika id kosong maka simpan, jika id ada nilainya maka update

                        params.put("id_lab",ID_lab);
                        params.put("id_client",id_client);
                    params.put("Tanggal_pinjam",Tanggal_pinjam);
                    params.put("jam_pemakaian",jam_total);


                    return params;
                }

            };

            AppController.getInstance().addToRequestQueue(strReq, tag_json_obj);
        }






    @Override
    public void onRefresh() {
        itemList.clear();
        adapter.notifyDataSetChanged();
        callVolley();
    }




    // untuk menampilkan semua data pada listview
    private void callVolley() {
        itemList.clear();
        adapter.notifyDataSetChanged();
        swipe.setRefreshing(true);

        // membuat request JSON
        JsonArrayRequest jArr = new JsonArrayRequest(url_select, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.d(TAG, response.toString());

                // Parsing json
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject obj = response.getJSONObject(i);

                        data_lab item = new data_lab();

                        item.setId(obj.getString(TAG_ID_LAB));
                        item.setNama_lab(obj.getString(TAG_NAMA_LAB));
                        item.setStatus(obj.getString(TAG_STATUS));
                        item.setPenanggung_jawab(obj.getString(TAG_PENANGGUNG));

                        // menambah item ke array
                        itemList.add(item);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                // notifikasi adanya perubahan data pada adapter
                adapter.notifyDataSetChanged();

                swipe.setRefreshing(false);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                swipe.setRefreshing(false);
            }
        });

        // menambah request ke request queue
        AppController.getInstance().addToRequestQueue(jArr);
    }


}
