package com.example.ehamelo.smartimmobilier;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ehamelo.smartimmobilier.entite.Son;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Main extends Activity implements View.OnClickListener {

    /*map controller */
    MapManager mapController;
    Button ajoutFiche;
    Button upload;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ajoutFiche=(Button)findViewById(R.id.ajoutFiche);


        ajoutFiche.setOnClickListener(this);

        Toast.makeText(this,"", Toast.LENGTH_LONG).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.ajoutFiche){
            Intent i = new Intent(getApplicationContext(), FormActivity.class);
            startActivity(i);
        }

    }



    /*
    * if(v.getId()==R.id.rec){
            try {
                descVocale.recordSon();
                Toast.makeText(this,"start", Toast.LENGTH_LONG).show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(v.getId()==R.id.play){

                //descVocale.play();
                Intent i = new Intent(getApplicationContext(), FormActivity.class);
                startActivity(i);
        }

        else{
            descVocale.stop();
            Toast.makeText(this,"stop", Toast.LENGTH_LONG).show();
        }
        this.getDir("son",0);
        Context context =this.getApplicationContext();
        descVocale=new Son(context,"mic1",this.getDir("son",0).toString()+"/son1.3gp");

    * */
}
