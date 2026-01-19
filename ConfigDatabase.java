package com.seunome.gamebooster;

import android.content.Context;
import android.content.SharedPreferences;

public class ConfigDatabase {
    private static final String PREFS_NAME = "LokiPrefs";

    public static void salvarPreset(Context ctx, String nome, float res, boolean travado) {
        SharedPreferences prefs = ctx.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        prefs.edit().putFloat(nome + "_res", res).putBoolean(nome + "_lock", travado).apply();
    }

    public static float lerRes(Context ctx, String nome) {
        return ctx.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).getFloat(nome + "_res", 1.0f);
    }
}
