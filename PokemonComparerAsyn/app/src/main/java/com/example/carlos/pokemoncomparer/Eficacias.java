package com.example.carlos.pokemoncomparer;

/**
 * Created by alu53789415m on 02/02/17.
 */

public class Eficacias {

    private Type typeF;
    private Type[] typesD;

    public Eficacias(Type typeF, Type[] typesD){
        this.typeF = typeF;
        this.typesD = typesD;
    }

    public Type getTypeF() {
        return typeF;
    }

    public void setTypeF(Type typeF) {
        this.typeF = typeF;
    }

    public Type[] getTypesD() {
        return typesD;
    }

    public void setTypesD(Type[] typesD) {
        this.typesD = typesD;
    }
}
