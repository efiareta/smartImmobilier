package com.example.ehamelo.smartimmobilier;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ehamelo.smartimmobilier.entite.Son;

import java.io.IOException;

/**
 * Created by ehamelo on 28/11/2014.
 */
public class FormActivity extends Activity implements View.OnClickListener {
    Son descVocale;

    /*composants graphiques*/

    Button play;
    Button upload_btn;
    TextView url;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulaire);

        play=(Button)findViewById(R.id.rec);
        upload_btn=(Button)findViewById(R.id.upload);
        url=(TextView)findViewById(R.id.urlImage);

        play.setOnClickListener(this);
        upload_btn.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.rec && ((Button) v).getText().toString().equals("rec")) {
            this.getDir("son", 0);
            Context context = this.getApplicationContext();
            descVocale = new Son(context, "mic1", this.getDir("son", 0).toString() + "/son1.3gp");
            ((Button) v).setText("stop");
            try {
                descVocale.recordSon();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (v.getId() == R.id.rec && ((Button) v).getText().toString().equals("stop")) {
            descVocale.stop();
            ((Button) v).setText("rec");
            try {
                descVocale.play();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (v.getId() == R.id.upload) {

            Toast.makeText(this, "pick", Toast.LENGTH_LONG).show();
            this.pickImage();


        }
    }

    public void pickImage(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "choisissez une image"),1);
    }

    /* To handle when an image is selected from the browser */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == 1) {

                String tmp= data.getData().getPath();
                Toast.makeText(this,tmp, Toast.LENGTH_LONG).show();
                url.setText(tmp);

            }
        }
    }
}
