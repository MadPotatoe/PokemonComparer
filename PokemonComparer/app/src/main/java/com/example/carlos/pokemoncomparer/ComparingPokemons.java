package com.example.carlos.pokemoncomparer;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by alu53789415m on 16/02/17.
 */

public class ComparingPokemons extends AppCompatActivity {

    ImageView v1_2;
    ImageView v2_2;
   // DBManager dbManager;
    Pokemon p1;
    Pokemon p2;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comparing_layout);

        v1_2 = (ImageView)findViewById(R.id.v1_2);
        v2_2 = (ImageView)findViewById(R.id.v2_2);
      //  dbManager = new DBManager(this);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        p1 = DBManager.getInstance(this).getApokemon(bundle.getString("P1"));
        p2 = DBManager.getInstance(this).getApokemon(bundle.getString("P2"));

        v1_2.setImageResource(p1.getImage());
        v2_2.setImageResource(p2.getImage());

        switch (p1.getType1().getName()){
            case "Grass": v1_2.setBackgroundResource(R.drawable.bg_green);
                break;
            case "Fire":v1_2.setBackgroundResource(R.drawable.bg_red);
                break;
            case "Normal":v1_2.setBackgroundResource(R.drawable.bg_normal);
                break;
            case "Water":v1_2.setBackgroundResource(R.drawable.bg_water);
                break;
            case "Fight":v1_2.setBackgroundResource(R.drawable.bg_fight);
                break;
            case "Flying":v1_2.setBackgroundResource(R.drawable.bg_flying);
                break;
            case "Poison":v1_2.setBackgroundResource(R.drawable.bg_poison);
                break;
            case "Ground":v1_2.setBackgroundResource(R.drawable.bg_ground);
                break;
            case "Rock":v1_2.setBackgroundResource(R.drawable.bg_rock);
                break;
            case "Bug":v1_2.setBackgroundResource(R.drawable.bg_bug);
                break;
            case "Ghost":v1_2.setBackgroundResource(R.drawable.bg_ghost);
                break;
            case "Electric":v1_2.setBackgroundResource(R.drawable.bg_electric);
                break;
            case "Psychic":v1_2.setBackgroundResource(R.drawable.bg_psychic);
                break;
            case "Ice":v1_2.setBackgroundResource(R.drawable.bg_ice);
                break;
            case "Dragon":v1_2.setBackgroundResource(R.drawable.bg_dragon);
                break;
            case "Dark":v1_2.setBackgroundResource(R.drawable.bg_dark);
                break;
            case "Steel":v1_2.setBackgroundResource(R.drawable.bg_steel);
                break;
            case "Fairy":v1_2.setBackgroundResource(R.drawable.bg_fairy);
        }

        switch (p2.getType1().getName()){
            case "Grass": v2_2.setBackgroundResource(R.drawable.bg_green);
                break;
            case "Fire":v2_2.setBackgroundResource(R.drawable.bg_red);
                break;
            case "Normal":v2_2.setBackgroundResource(R.drawable.bg_normal);
                break;
            case "Water":v2_2.setBackgroundResource(R.drawable.bg_water);
                break;
            case "Fight":v2_2.setBackgroundResource(R.drawable.bg_fight);
                break;
            case "Flying":v2_2.setBackgroundResource(R.drawable.bg_flying);
                break;
            case "Poison":v2_2.setBackgroundResource(R.drawable.bg_poison);
                break;
            case "Ground":v2_2.setBackgroundResource(R.drawable.bg_ground);
                break;
            case "Rock":v2_2.setBackgroundResource(R.drawable.bg_rock);
                break;
            case "Bug":v2_2.setBackgroundResource(R.drawable.bg_bug);
                break;
            case "Ghost":v2_2.setBackgroundResource(R.drawable.bg_ghost);
                break;
            case "Electric":v2_2.setBackgroundResource(R.drawable.bg_electric);
                break;
            case "Psychic":v2_2.setBackgroundResource(R.drawable.bg_psychic);
                break;
            case "Ice":v2_2.setBackgroundResource(R.drawable.bg_ice);
                break;
            case "Dragon":v2_2.setBackgroundResource(R.drawable.bg_dragon);
                break;
            case "Dark":v2_2.setBackgroundResource(R.drawable.bg_dark);
                break;
            case "Steel":v2_2.setBackgroundResource(R.drawable.bg_steel);
                break;
            case "Fairy":v2_2.setBackgroundResource(R.drawable.bg_fairy);
        }
        //hp
        TextView p1hp = (TextView)findViewById(R.id.p1hp);
        p1hp.setText(p1.getHp()+"");

        TextView p2hp = (TextView)findViewById(R.id.p2hp);
        p2hp.setText(p2.getHp()+"");

        if(p1.getHp()>p2.getHp()){
            p1hp.setTextColor(getResources().getColor(R.color.colorMore));
            p2hp.setTextColor(getResources().getColor(R.color.colorLess));
        }else{
            if(p1.getHp()== p2.getHp()){
                p2hp.setTextColor(getResources().getColor(R.color.colorMore));
                p1hp.setTextColor(getResources().getColor(R.color.colorMore));
            }else {
                p2hp.setTextColor(getResources().getColor(R.color.colorMore));
                p1hp.setTextColor(getResources().getColor(R.color.colorLess));
            }
        }

        //attack
        TextView p1att = (TextView)findViewById(R.id.p1att);
        p1att.setText(p1.getAttack()+"");

        TextView p2att = (TextView)findViewById(R.id.p2att);
        p2att.setText(p2.getAttack()+"");

        if(p1.getAttack()>p2.getAttack()){
            p1att.setTextColor(getResources().getColor(R.color.colorMore));
            p2att.setTextColor(getResources().getColor(R.color.colorLess));
        }else{
            if(p1.getAttack()== p2.getAttack()){
                p2att.setTextColor(getResources().getColor(R.color.colorMore));
                p1att.setTextColor(getResources().getColor(R.color.colorMore));
            }else {
                p2att.setTextColor(getResources().getColor(R.color.colorMore));
                p1att.setTextColor(getResources().getColor(R.color.colorLess));
            }
        }

        //defense
        TextView p1def = (TextView)findViewById(R.id.p1def);
        p1def.setText(p1.getDefense()+"");

        TextView p2def = (TextView)findViewById(R.id.p2def);
        p2def.setText(p2.getDefense()+"");

        if(p1.getDefense()>p2.getDefense()){
            p1def.setTextColor(getResources().getColor(R.color.colorMore));
            p2def.setTextColor(getResources().getColor(R.color.colorLess));
        }else{
            if(p1.getDefense()== p2.getDefense()){
                p2def.setTextColor(getResources().getColor(R.color.colorMore));
                p1def.setTextColor(getResources().getColor(R.color.colorMore));
            }else {
                p2def.setTextColor(getResources().getColor(R.color.colorMore));
                p1def.setTextColor(getResources().getColor(R.color.colorLess));
            }
        }

        //Sp.Attack
        TextView p1spA = (TextView)findViewById(R.id.p1spA);
        p1spA.setText(p1.getSp_Attack()+"");

        TextView p2spA = (TextView)findViewById(R.id.p2spA);
        p2spA.setText(p2.getSp_Attack()+"");

        if(p1.getSp_Attack()>p2.getSp_Attack()){
            p1spA.setTextColor(getResources().getColor(R.color.colorMore));
            p2spA.setTextColor(getResources().getColor(R.color.colorLess));
        }else{
            if(p1.getSp_Attack()== p2.getSp_Attack()){
                p2spA.setTextColor(getResources().getColor(R.color.colorMore));
                p1spA.setTextColor(getResources().getColor(R.color.colorMore));
            }else {
                p2spA.setTextColor(getResources().getColor(R.color.colorMore));
                p1spA.setTextColor(getResources().getColor(R.color.colorLess));
            }
        }

        //Sp.Defense
        TextView p1spD = (TextView)findViewById(R.id.p1spD);
        p1spD.setText(p1.getSp_Defense()+"");

        TextView p2spD = (TextView)findViewById(R.id.p2spD);
        p2spD.setText(p2.getSp_Defense()+"");

        if(p1.getSp_Defense()>p2.getSp_Defense()){
            p1spD.setTextColor(getResources().getColor(R.color.colorMore));
            p2spD.setTextColor(getResources().getColor(R.color.colorLess));
        }else{
            if(p1.getSp_Defense()== p2.getSp_Defense()){
                p2spD.setTextColor(getResources().getColor(R.color.colorMore));
                p1spD.setTextColor(getResources().getColor(R.color.colorMore));
            }else {
                p2spD.setTextColor(getResources().getColor(R.color.colorMore));
                p1spD.setTextColor(getResources().getColor(R.color.colorLess));
            }
        }



        //Speed
        TextView p1speed = (TextView)findViewById(R.id.p1speed);
        p1speed.setText(p1.getSpeed()+"");

        TextView p2speed = (TextView)findViewById(R.id.p2speed);
        p2speed.setText(p2.getSpeed()+"");

        if(p1.getSpeed()>p2.getSpeed()){
            p1speed.setTextColor(getResources().getColor(R.color.colorMore));
            p2speed.setTextColor(getResources().getColor(R.color.colorLess));
        }else{
            if(p1.getSpeed()== p2.getSpeed()){
                p2speed.setTextColor(getResources().getColor(R.color.colorMore));
                p1speed.setTextColor(getResources().getColor(R.color.colorMore));
            }else {
                p2speed.setTextColor(getResources().getColor(R.color.colorMore));
                p1speed.setTextColor(getResources().getColor(R.color.colorLess));
            }
        }



    }



}
