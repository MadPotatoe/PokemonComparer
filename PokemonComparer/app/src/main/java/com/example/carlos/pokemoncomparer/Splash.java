package com.example.carlos.pokemoncomparer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread t = new Thread() {
            public void run() {
                try {
                    Thread.sleep(5000);
                    Intent intent = new Intent(Splash.this, MainActivity.class);
                    startActivity(intent);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        };
        t.start();
    }

    @Override
    protected void onStop(){
        super.onStop();
        finish();
    }
}
