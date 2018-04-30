package com.example.carlos.pokemoncomparer;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.BoolRes;
import android.support.annotation.RequiresApi;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import static com.example.carlos.pokemoncomparer.R.id.recyclerView;

public class MainActivity extends AppCompatActivity {



    Boolean isV1Empty = true;
    RecyclerView recyclerView;
    AdaptadorPokeView adaptador;
    ImageView v1;
    ImageView v2;
    ArrayList<Pokemon> cards;

    DBManager dbManager;
    Button compare;
    String p1;
    String p2;
    Drawable d1;
    Drawable d2;
    Boolean comparar = false;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        v1 = (ImageView)findViewById(R.id.v1);
        v2 = (ImageView)findViewById(R.id.v2);
        dbManager = new DBManager(this);
        compare = (Button)findViewById(R.id.compare);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        //cards = dbManager.getPokemons();


        v1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v1.getResources() != null){
                    v1.setImageResource(R.drawable.empty);
                    isV1Empty = true;
                }
            }
        });

        v2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v2.getResources() != null){
                    v2.setImageResource(R.drawable.empty);
                }
            }
        });

        compare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(comparar) {
                    Intent intent = new Intent(getApplicationContext(), ComparingPokemons.class);
                    intent.putExtra("P1", p1);
                    intent.putExtra("P2", p2);
                    startActivity(intent);
                }
            }
        });

        recyclerView.setAdapter(adaptador);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(item.getItemId()) {
            case R.id.action_settings:
                return true;
            //...
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDestroy (){
        dbManager.close();
    }

    public void asignPOkemon(ArrayList<Pokemon> allPokemons){
        cards = allPokemons;
        adaptador = new AdaptadorPokeView(cards);
        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView imageView = (ImageView)v.findViewById(R.id.imagen);
                if(isV1Empty) {
                    v1.setImageResource(cards.get(recyclerView.getChildPosition(v)).getImage());
                    isV1Empty = false;
                    v1.setBackground(imageView.getBackground());
                    p1 = cards.get(recyclerView.getChildPosition(v)).getName();
                    d1 = imageView.getBackground();
                }else{
                    v2.setImageResource(cards.get(recyclerView.getChildPosition(v)).getImage());
                    v2.setBackground(imageView.getBackground());
                    p2 = cards.get(recyclerView.getChildPosition(v)).getName();
                    d2 = imageView.getBackground();
                    comparar = true;
                }
            }
        });
    }

}



