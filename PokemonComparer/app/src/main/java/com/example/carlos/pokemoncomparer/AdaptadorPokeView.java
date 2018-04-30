package com.example.carlos.pokemoncomparer;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import static android.support.v7.widget.AppCompatDrawableManager.get;

/**
 * Created by alu53789415m on 26/01/17.
 */

public class AdaptadorPokeView extends RecyclerView.Adapter<AdaptadorPokeView.CardViewHolder> implements View.OnClickListener{
    private static ArrayList<Pokemon> fotos;
    private View.OnClickListener listener;

    Drawable drawable1;
    Drawable drawableFire;
    Drawable normal;
    Drawable water;
    Drawable fight;
    Drawable flying;
    Drawable poison;
    Drawable ground;
    Drawable rock;
    Drawable bug;
    Drawable ghost;
    Drawable electric;
    Drawable psychic;
    Drawable ice;
    Drawable dragon;
    Drawable dark;
    Drawable steel;
    Drawable fairy;
    private ImageView txtImagen;

    public AdaptadorPokeView(ArrayList<Pokemon> fotos){
        this.fotos = new ArrayList<Pokemon>();

        for(Pokemon c : fotos){
            this.fotos.add(c);

        }
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if(listener != null)
            listener.onClick(v);
    }


    public class CardViewHolder extends RecyclerView.ViewHolder{

        public CardViewHolder(View itemView){
            super(itemView);
            txtImagen = (ImageView)itemView.findViewById(R.id.imagen);
        }
        public void bindCard(final Pokemon card){
            txtImagen.setImageResource(card.getImage());

        }
    }



    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listitem, viewGroup, false);
        CardViewHolder tvh = new CardViewHolder(itemView);
        itemView.setOnClickListener(this);
        drawable1 = viewGroup.getResources().getDrawable(R.drawable.bg_green);
        drawableFire = viewGroup.getResources().getDrawable(R.drawable.bg_red);
        normal = viewGroup.getResources().getDrawable(R.drawable.bg_normal);
        water= viewGroup.getResources().getDrawable(R.drawable.bg_water);
        fight = viewGroup.getResources().getDrawable(R.drawable.bg_fight);
        flying = viewGroup.getResources().getDrawable(R.drawable.bg_flying);
        poison = viewGroup.getResources().getDrawable(R.drawable.bg_poison);
        ground = viewGroup.getResources().getDrawable(R.drawable.bg_ground);
        rock = viewGroup.getResources().getDrawable(R.drawable.bg_rock);
        bug = viewGroup.getResources().getDrawable(R.drawable.bg_bug);
        ghost = viewGroup.getResources().getDrawable(R.drawable.bg_ghost);
        electric = viewGroup.getResources().getDrawable(R.drawable.bg_electric);
        psychic = viewGroup.getResources().getDrawable(R.drawable.bg_psychic);
        ice = viewGroup.getResources().getDrawable(R.drawable.bg_ice);
        dragon = viewGroup.getResources().getDrawable(R.drawable.bg_dragon);
        dark = viewGroup.getResources().getDrawable(R.drawable.bg_dark);
        steel = viewGroup.getResources().getDrawable(R.drawable.bg_steel);
        fairy = viewGroup.getResources().getDrawable(R.drawable.bg_fairy);

        return tvh;

    }

    @Override
    public void onBindViewHolder(CardViewHolder viewHolder, int pos) {
        Pokemon item = fotos.get(pos);
        viewHolder.bindCard(item);
        switch (fotos.get(pos).getType1().getName()){
            case "Grass":txtImagen.setBackground(drawable1);
                break;
            case "Fire":txtImagen.setBackground(drawableFire);
                break;
            case "Normal":txtImagen.setBackground(normal);
                break;
            case "Water":txtImagen.setBackground(water);
                break;
            case "Fight":txtImagen.setBackground(fight);
                break;
            case "Flying":txtImagen.setBackground(flying);
                break;
            case "Poison":txtImagen.setBackground(poison);
                break;
            case "Ground":txtImagen.setBackground(ground);
                break;
            case "Rock":txtImagen.setBackground(rock);
                break;
            case "Bug":txtImagen.setBackground(bug);
                break;
            case "Ghost":txtImagen.setBackground(ghost);
                break;
            case "Electric":txtImagen.setBackground(electric);
                break;
            case "Psychic":txtImagen.setBackground(psychic);
                break;
            case "Ice":txtImagen.setBackground(ice);
                break;
            case "Dragon":txtImagen.setBackground(dragon);
                break;
            case "Dark":txtImagen.setBackground(dark);
                break;
            case "Steel":txtImagen.setBackground(steel);
                break;
            case "Fairy":txtImagen.setBackground(fairy);
        }
    }

    @Override
    public int getItemCount() {
        return fotos.size();
    }


}
