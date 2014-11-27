package com.example.ehamelo.smartimmobilier.entite;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.widget.Toast;

import java.io.IOException;

/**ss
 * Created by ehamelo on 24/11/2014.
 */
public class Son extends Description {
    MediaRecorder res;
    Context context;

    public Son(Context context,String titre,String url){
        this.titre=titre;
        this.url=url;
        this.context=context;


    }

    public void recordSon() throws IOException {
        res=new MediaRecorder();
        res.setAudioSource(MediaRecorder.AudioSource.MIC);
        res.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        res.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        res.setOutputFile(url);
        res.prepare();
        res.start();
    }

    public void stop(){
        if (res != null){
            res.stop();
            res.release();
            res = null;
        }
    }

    public void play() throws IOException {
        MediaPlayer m = new MediaPlayer();
        m.setDataSource(url);
        m.prepare();
        m.start();
        Toast.makeText(context.getApplicationContext(), "Playing audio", Toast.LENGTH_LONG).show();
    }
}
