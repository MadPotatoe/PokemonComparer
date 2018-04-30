package com.example.carlos.pokemoncomparer;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;

/**
 * Created by alu53789415m on 02/02/17.
 */

public class DBManager extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "poke.db";
    private static DBManager sInstance;

    public DBManager(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {


        db.execSQL("CREATE TABLE IF NOT EXISTS " + DBContract.PokemonEntry.TABLE_NAME + " ("
                + DBContract.PokemonEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + DBContract.PokemonEntry.NAME + " TEXT NOT NULL,"
                + DBContract.PokemonEntry.IMAGE + " BLOB NOT NULL,"
                + DBContract.PokemonEntry.TYPE1 + " TEXT NOT NULL,"
                + DBContract.PokemonEntry.TYPE2 + " TEXT,"
                + DBContract.PokemonEntry.HP + " INTEGER NOT NULL,"
                + DBContract.PokemonEntry.ATTACK + " INTEGER NOT NULL,"
                + DBContract.PokemonEntry.DEFENSE + " INTEGER NOT NULL,"
                + DBContract.PokemonEntry.SP_ATTACK + " INTEGER NOT NULL,"
                + DBContract.PokemonEntry.SP_DEFENSE + " INTEGER NOT NULL,"
                + DBContract.PokemonEntry.SPEED + " INTEGER NOT NULL)");

        db.execSQL("CREATE TABLE IF NOT EXISTS " + DBContract.TypeEntry.TABLE_NAME + " ("
                + DBContract.TypeEntry.NAME + " TEXT NOT NULL PRIMARY KEY,"
                + DBContract.TypeEntry.EF + " TEXT)");

        db.execSQL("CREATE TABLE IF NOT EXISTS " + DBContract.EfEntry.TABLE_NAME + " ("
                + DBContract.EfEntry.TIP_F + " TEXT NOT NULL PRIMARY KEY,"
                + DBContract.EfEntry.TIP_D + " TEXT,"
                + "FOREIGN KEY("+ DBContract.EfEntry.TIP_F+") REFERENCES "+ DBContract.TypeEntry.TABLE_NAME+"("+ DBContract.TypeEntry.NAME+"))");


        mockData(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long savePokemon(Pokemon pokemon) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        return sqLiteDatabase.insert(DBContract.PokemonEntry.TABLE_NAME,null,pokemon.toContentValues());
    }

    public long mockPokemon(SQLiteDatabase db, Pokemon pokemon) {
        return db.insert(DBContract.PokemonEntry.TABLE_NAME, null, pokemon.toContentValues());
    }

    private void mockData(SQLiteDatabase sqLiteDatabase) {
        mockPokemon(sqLiteDatabase, new Pokemon("Rowlet",R.drawable.rowlet,new Type("Grass"),new Type("Flying"),175,117,117,112,112,103));
        mockPokemon(sqLiteDatabase, new Pokemon("Dartrix",R.drawable.dartrix,new Type("Grass"),new Type("Flying"),185,139,139,134,134,114));
        mockPokemon(sqLiteDatabase, new Pokemon("Decidueye",R.drawable.decidueye,new Type("Grass"),new Type("Ghost"),185,174,139,167,167,134));
        mockPokemon(sqLiteDatabase, new Pokemon("Litten",R.drawable.litten,new Type("Fire"),null,152,128,101,123,101,134));
        mockPokemon(sqLiteDatabase, new Pokemon("Torracat",R.drawable.torracat,new Type("Fire"),null,172,150,112,145,112,156));
        mockPokemon(sqLiteDatabase, new Pokemon("Incineroar",R.drawable.incineroar,new Type("Fire"),new Type("Dark"),202,183,156,145,156,123));
        mockPokemon(sqLiteDatabase, new Pokemon("Popplio",R.drawable.popplio,new Type("Water"),null,157,116,116,129,118,101));
        mockPokemon(sqLiteDatabase, new Pokemon("Brionne",R.drawable.brionne,new Type("Water"),null,167,133,133,157,146,112));
        mockPokemon(sqLiteDatabase, new Pokemon("Primarina",R.drawable.primarina,new Type("Water"),new Type("Fairy"),187,138,138,195,184,123));
        mockPokemon(sqLiteDatabase, new Pokemon("Pikipek",R.drawable.pokipek,new Type("Normal"),new Type("Flying"),142,139,90,90,90,128));
        mockPokemon(sqLiteDatabase, new Pokemon("Trumbeak",R.drawable.trumbeak,new Type("Normal"),new Type("Flying"),162,150,112,101,112,139));
        mockPokemon(sqLiteDatabase, new Pokemon("Toucannon",R.drawable.toucannon,new Type("Normal"),new Type("Flying"),187,189,139,139,139,123));
        mockPokemon(sqLiteDatabase, new Pokemon("Yungoos",R.drawable.yungoos,new Type("Normal"),null,155,134,90,90,90,106));
        mockPokemon(sqLiteDatabase, new Pokemon("Gumshoos",R.drawable.gumshoos,new Type("Normal"),null,195,178,123,117,123,106));
        mockPokemon(sqLiteDatabase, new Pokemon("Grubbin",R.drawable.grubbin,new Type("Bug"),null,154,125,106,117,106,107));
        mockPokemon(sqLiteDatabase, new Pokemon("Charjabug",R.drawable.charjabug,new Type("Bug"),new Type("Electric"),164,147,161,117,139,96));
        mockPokemon(sqLiteDatabase, new Pokemon("Vikavolt",R.drawable.vikavolt,new Type("Bug"),new Type("Electric"),184,134,156,216,139,104));
        mockPokemon(sqLiteDatabase, new Pokemon("Crabrawler",R.drawable.crabrawler,new Type("Fight"),null,154,147,119,103,108,126));
        mockPokemon(sqLiteDatabase, new Pokemon("Crabominable",R.drawable.crabominable,new Type("Fight"),new Type("Ice"),204,202,141,125,130,104));
       // mockPokemon(sqLiteDatabase, new Pokemon("Oricorio",R.drawable.oricorio,new Type("Electric"),new Type("Flying"),182,134,134,165,134,159));
       // mockPokemon(sqLiteDatabase, new Pokemon("Cutiefly",R.drawable.cutiefly,new Type("Bug"),new Type("Fairy"),147,106,101,117,101,149));

    }

    public ArrayList<Pokemon> getPokemons(){
        SQLiteDatabase db = getReadableDatabase();
        String query = "select * from " + DBContract.PokemonEntry.TABLE_NAME;
        Cursor c = db.rawQuery(query, null);
        ArrayList<Pokemon> pokemons = new ArrayList<>();

        while (c.moveToNext()) {
            String nombre = c.getString(c.getColumnIndex(DBContract.PokemonEntry.NAME));
            int imagen = c.getInt(c.getColumnIndex(DBContract.PokemonEntry.IMAGE));
            Type type1 = new Type(c.getString(c.getColumnIndex(DBContract.PokemonEntry.TYPE1)));
            Type type2 = new Type(c.getString(c.getColumnIndex(DBContract.PokemonEntry.TYPE2)));
            int hp = c.getInt(c.getColumnIndex(DBContract.PokemonEntry.HP));
            int attack = c.getInt(c.getColumnIndex(DBContract.PokemonEntry.ATTACK));
            int defense = c.getInt(c.getColumnIndex(DBContract.PokemonEntry.DEFENSE));
            int sp_at = c.getInt(c.getColumnIndex(DBContract.PokemonEntry.SP_ATTACK));
            int sp_def = c.getInt(c.getColumnIndex(DBContract.PokemonEntry.SP_DEFENSE));
            int speed = c.getInt(c.getColumnIndex(DBContract.PokemonEntry.SPEED));
            pokemons.add(new Pokemon(nombre, imagen,type1,type2,hp,attack,defense,sp_at,sp_def,speed));
        }

        return pokemons;
    }

    public Pokemon getApokemon(String id){
        SQLiteDatabase db = getReadableDatabase();
        String query = "select * from " + DBContract.PokemonEntry.TABLE_NAME+" where NAME="+"'"+id+"'";
        Cursor c = db.rawQuery(query, null);
        c.moveToNext();
        String nombre = c.getString(c.getColumnIndex(DBContract.PokemonEntry.NAME));
        int imagen = c.getInt(c.getColumnIndex(DBContract.PokemonEntry.IMAGE));
        Type type1 = new Type(c.getString(c.getColumnIndex(DBContract.PokemonEntry.TYPE1)));
        Type type2 = new Type(c.getString(c.getColumnIndex(DBContract.PokemonEntry.TYPE2)));
        int hp = c.getInt(c.getColumnIndex(DBContract.PokemonEntry.HP));
        int attack = c.getInt(c.getColumnIndex(DBContract.PokemonEntry.ATTACK));
        int defense = c.getInt(c.getColumnIndex(DBContract.PokemonEntry.DEFENSE));
        int sp_at = c.getInt(c.getColumnIndex(DBContract.PokemonEntry.SP_ATTACK));
        int sp_def = c.getInt(c.getColumnIndex(DBContract.PokemonEntry.SP_DEFENSE));
        int speed = c.getInt(c.getColumnIndex(DBContract.PokemonEntry.SPEED));
        Pokemon myPokemon = new Pokemon(nombre, imagen,type1,type2,hp,attack,defense,sp_at,sp_def,speed);

        return myPokemon;
    }
    public static synchronized DBManager getInstance(Context context) {

        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = new DBManager(context.getApplicationContext());
        }
        return sInstance;
    }

    /**
     * Constructor should be private to prevent direct instantiation.
     * make call to static method "getInstance()" instead.
     */
}
