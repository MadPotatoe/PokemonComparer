package com.example.carlos.pokemoncomparer;

import android.content.ContentValues;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import static android.R.attr.id;
import static android.R.attr.phoneNumber;
import static android.R.attr.type;

/**
 * Created by Carlos on 12/01/2017.
 */

public class Pokemon {

    private int image;
    private String name;
    Type type1;
    Type type2;
    private int hp;
    private int attack;
    private int defense;
    private int sp_Attack;
    private int sp_Defense;
    private int speed;


    public Pokemon(String name, int image, Type type1, Type type2, int hp, int attack,int defense,int sp_Attack,int sp_Defense,int speed){
        this.name = name;
        this.image = image;
        this.type1 = type1;
        this.type2 = type2;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.sp_Attack = sp_Attack;
        this.sp_Defense = sp_Defense;
        this.speed = speed;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(DBContract.PokemonEntry.NAME, name);
        values.put(DBContract.PokemonEntry.IMAGE, image);
        values.put(DBContract.PokemonEntry.TYPE1, type1.toString());
        values.put(DBContract.PokemonEntry.TYPE2, type2==null?"":type2.toString());
        values.put(DBContract.PokemonEntry.HP, hp);
        values.put(DBContract.PokemonEntry.ATTACK, attack);
        values.put(DBContract.PokemonEntry.DEFENSE, defense);
        values.put(DBContract.PokemonEntry.SP_ATTACK, sp_Attack);
        values.put(DBContract.PokemonEntry.SP_DEFENSE, sp_Defense);
        values.put(DBContract.PokemonEntry.SPEED, speed);
        return values;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Type getType1() {
        return type1;
    }

    public void setType1(Type type) {
        this.type1 = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType2() {
        return type2;
    }

    public void setType2(Type type2) {
        this.type2 = type2;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSp_Attack() {
        return sp_Attack;
    }

    public void setSp_Attack(int sp_Attack) {
        this.sp_Attack = sp_Attack;
    }

    public int getSp_Defense() {
        return sp_Defense;
    }

    public void setSp_Defense(int sp_Defense) {
        this.sp_Defense = sp_Defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }



}
