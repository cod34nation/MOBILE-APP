package com.example.afrizal.pantauinfolab.activity;

import android.app.Dialog;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.afrizal.pantauinfolab.Data.data_kios;
import com.example.afrizal.pantauinfolab.adapter.kios_adapter;

import com.example.afrizal.pantauinfolab.R;
import com.example.afrizal.pantauinfolab.app.AppConfig;
import com.example.afrizal.pantauinfolab.app.AppController;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class map extends ActionBarActivity implements SwipeRefreshLayout.OnRefreshListener {
    private GoogleMap googleMap;
    private ArrayList<LatLng>listLatLng;
    private RelativeLayout rlMapLayout;
    HashMap<Marker,data_kios> hashMapMarker = new HashMap<Marker,data_kios>();
    List<data_kios> itemList = new ArrayList<data_kios>();
    kios_adapter adapter;
    SwipeRefreshLayout swipe;
    private static final String TAG = map.class.getSimpleName();
    private static String url_select = AppConfig.URL + "cread_kios.php";



    public static final String TAG_ID_KIOS= "id_kios";
    public static final String TAG_NAMA_KIOS = "nama_kios";
    public static final String TAG_LAT= "lt";
    public static final String TAG_LG = "lg";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        rlMapLayout=(RelativeLayout) findViewById(R.id.rlMapLayout);

        setUpMapIfNeeded();
       ;
        setData();

    }



    /**
     * @author Hasmukh Bhadani
     * Set googleMap if require
     */
    private void setUpMapIfNeeded()
    {
        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getBaseContext());

        // Google Play Services are not available
        if(status!=ConnectionResult.SUCCESS)
        {
            int requestCode = 10;
            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(status, this, requestCode);
            dialog.show();

        }
        else
        {
            if (googleMap == null)
            {
                googleMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
                if (googleMap != null)
                {
                    googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                    // googleMap.setMyLocationEnabled(true);
                    googleMap.getUiSettings().setMyLocationButtonEnabled(true);
                    googleMap.getUiSettings().setZoomControlsEnabled(true);
                }
            }
        }
    }
    private void setData()
    {
        ArrayList<data_kios> arrayList=new ArrayList<data_kios>();
        data_kios bean=new data_kios();
        bean.setnama_lokasi("Ahmedabad");
        bean.setpop_up("Hello,Ahmedabad");
        bean.setLatitude("-7.953125");
        bean.setLongitude("112.616783");
        arrayList.add(bean);

        data_kios bean1=new data_kios();
        bean1.setnama_lokasi("Surat");
        bean1.setpop_up("Hello,Surat");
        bean1.setLatitude("-7.963693");
        bean1.setLongitude("112.602684");
        arrayList.add(bean1);

        data_kios bean2=new data_kios();
        bean2.setnama_lokasi("Vadodara");
        bean2.setpop_up("Hello,Vadodara");
        bean2.setLatitude("-7.943596");
        bean2.setLongitude("112.608063");
        arrayList.add(bean2);

        data_kios bean3=new data_kios();
        bean2.setnama_lokasi("Galaxy Solusindo");
        bean2.setpop_up("Hello,Vadodara");
        bean2.setLatitude("-7.964125");
        bean2.setLongitude("112.633888");
        arrayList.add(bean2);

        data_kios bean4=new data_kios();
        bean2.setnama_lokasi("Kios Maju Jaya");
        bean2.setpop_up("Hello,Vadodara");
        bean2.setLatitude("-7.947885");
        bean2.setLongitude("112.575722");
        arrayList.add(bean2);

        LoadingGoogleMap(arrayList);
    }

    /**
     * @author Hasmukh Bhadani
     * Loading Data to the GoogleMap
     */
    // -------------------------Google Map
    void LoadingGoogleMap(ArrayList<data_kios> arrayList)
    {
        if (googleMap != null)
        {
            googleMap.clear();
            googleMap.getUiSettings().setMyLocationButtonEnabled(true);
            // googleMap.setMyLocationEnabled(true);
            googleMap.getUiSettings().setZoomControlsEnabled(true);

            if(arrayList.size()>0)
            {
                try
                {
                    listLatLng=new ArrayList<LatLng>();
                    for (int i = 0; i < arrayList.size(); i++)
                    {
                        data_kios bean=arrayList.get(i);
                        if(bean.getLatitude().length()>0 && bean.getLongitude().length()>0)
                        {
                            double lat=Double.parseDouble(bean.getLatitude());
                            double lon=Double.parseDouble(bean.getLongitude());
                          //  Toast.makeText(getApplicationContext(),"Rp "+lat,Toast.LENGTH_LONG).show();

                            Marker marker = googleMap.addMarker(new MarkerOptions()
                                    .position(new LatLng(lat,lon))
                                    .title(bean.getnama_lokasi())
                                    .snippet(bean.getpop_up())
                                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                            //Add Marker to Hashmap
                            hashMapMarker.put(marker,bean);

                            //Set Zoom Level of Map pin
                            LatLng object=new LatLng(lat, lon);
                            listLatLng.add(object);
                        }
                    }
                    SetZoomlevel(listLatLng);
                }
                catch (NumberFormatException e)
                {
                    e.printStackTrace();
                }

                googleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {

                    @Override
                    public void onInfoWindowClick(Marker position)
                    {
                        data_kios bean=hashMapMarker.get(position);
                        Toast.makeText(getApplicationContext(), bean.getpop_up(),Toast.LENGTH_SHORT).show();

                    }
                });
            }
        }

        else
        {
            Toast.makeText(getApplicationContext(),"Sorry! unable to create maps", Toast.LENGTH_SHORT).show();
        }
    }
    /**
     * @author Hasmukh Bhadani
     * Set Zoom level all pin withing screen on GoogleMap
     */
    public void  SetZoomlevel(ArrayList<LatLng> listLatLng)
    {
        if (listLatLng != null && listLatLng.size() == 1)
        {
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(listLatLng.get(0), 10));
        }
        else if (listLatLng != null && listLatLng.size() > 1)
        {
            final LatLngBounds.Builder builder = LatLngBounds.builder();
            for (int i = 0; i < listLatLng.size(); i++)
            {
                builder.include(listLatLng.get(i));
            }

            final ViewTreeObserver treeObserver = rlMapLayout.getViewTreeObserver();
            treeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
            {
                @SuppressWarnings("deprecation")
                @Override
                public void onGlobalLayout()
                {
                    if(googleMap != null){
                        googleMap.moveCamera(CameraUpdateFactory.newLatLngBounds(builder.build(), findViewById(R.id.map)
                                .getWidth(), findViewById(R.id.map).getHeight(), 80));
                        rlMapLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    }
                }
            });

        }
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

                        data_kios item = new data_kios();

                        item.setnama_lokasi(obj.getString(TAG_NAMA_KIOS));
                        item.setLatitude(obj.getString(TAG_LAT));
                        item.setLongitude(obj.getString(TAG_LG));


                        // menambah item ke array
                        itemList.add(item);
                      //  LoadingGoogleMap(itemList);

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