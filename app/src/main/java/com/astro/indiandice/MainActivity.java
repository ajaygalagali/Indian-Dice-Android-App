package com.astro.indiandice;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

import static android.graphics.Color.BLUE;
import static android.graphics.Color.RED;
import static android.graphics.Color.YELLOW;

public class MainActivity extends AppCompatActivity {


    TextView textViewNum;

    Random random;
    int num;
    boolean flag;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewNum = findViewById(R.id.textViewNum);

        random = new Random();
        flag=false;

    }

    public void rollClick(View view){


        if(flag){
            textViewNum.animate().rotation(0);

            flag = false;
        }else{
            flag = true;
            textViewNum.animate().rotation(360);
        }


        num = random.nextInt(6-1)+1;
        if(num == 5){
            num = 8;
            textViewNum.setBackgroundColor(Color.rgb(211,41,37));
        }else if(num == 4){
            textViewNum.setBackgroundColor(Color.rgb(211,41,37));
        }else {
            textViewNum.setBackgroundColor(Color.rgb(63,81,181));
        }

        textViewNum.setText(Integer.toString(num));
        mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.rollmusic);
        mediaPlayer.start();





    }
}
