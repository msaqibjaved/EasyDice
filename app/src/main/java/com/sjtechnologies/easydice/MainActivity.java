package com.sjtechnologies.easydice;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private Button btnRoll;
    private ImageView dice1, dice2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnRoll = findViewById(R.id.btnRolltheDice);
        dice1 = findViewById(R.id.imageDice1);
        dice2 = findViewById(R.id.imageDice2);
        initListeners();
    }

    private void initListeners() {
        final int[] diceImages = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6};
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.dice_sound);


        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random randomObject = new Random();
                int myRandomNumber = randomObject.nextInt(6);
                dice1.setImageResource(diceImages[myRandomNumber]);
                myRandomNumber = randomObject.nextInt(6);
                dice2.setImageResource(diceImages[myRandomNumber]);
                mediaPlayer.start();

                YoYo.with(Techniques.Shake)
                        .duration(400)
                        .repeat(0)
                        .playOn(dice1);
                YoYo.with(Techniques.Shake)
                        .duration(400)
                        .repeat(0)
                        .playOn(dice2);


            }
        });

    }
}
