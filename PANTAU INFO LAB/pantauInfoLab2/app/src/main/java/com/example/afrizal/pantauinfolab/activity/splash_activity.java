package com.example.afrizal.pantauinfolab.activity;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;

import  com.example.afrizal.pantauinfolab.R;
import  com.example.afrizal.pantauinfolab.MainActivity;

public class splash_activity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread thread= new Thread(){

            public void run(){
                try{
                    sleep(4000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally {

                    startActivity(new Intent(splash_activity.this,MainActivity.class));


                }
            }
        };

        thread.start();

    }
}
