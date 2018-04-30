package com.example.carlos.pokemoncomparer;

/**
 * Created by alu53789415m on 02/02/17.
 */

public class Type  {

    String name;

    public Type(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        if(name == null){
            return "";
        }
        return name;
    }
}
