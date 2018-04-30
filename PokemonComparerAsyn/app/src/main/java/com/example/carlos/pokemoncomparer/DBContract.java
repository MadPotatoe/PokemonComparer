package com.example.carlos.pokemoncomparer;

import android.provider.BaseColumns;

/**
 * Created by alu53789415m on 02/02/17.
 */

public final class DBContract {
    private DBContract() {}

    /* Inner class that defines the table contents */
    public static class PokemonEntry implements BaseColumns {
        public static final String TABLE_NAME = "Pokemon";
        public static final String NAME = "Name";
        public static final String IMAGE = "Image";
        public static final String TYPE1 = "Type1";
        public static final String TYPE2 = "Type2";
        public static final String HP = "HP";
        public static final String ATTACK = "Attack";
        public static final String DEFENSE = "Defense";
        public static final String SP_ATTACK = "SpAttack";
        public static final String SP_DEFENSE = "SpDefense";
        public static final String SPEED = "Speed";
    }

    public static class TypeEntry implements BaseColumns{
        public static final String TABLE_NAME ="Type";
        public static final String NAME = "TypeName";
        public static final String EF = "Eficacia";
    }

    public static class EfEntry implements BaseColumns{
        public static final String TABLE_NAME = "Eficacias";
        public static final String TIP_F = "TIP_F";
        public static final String TIP_D = "TIP_D";
    }
}
