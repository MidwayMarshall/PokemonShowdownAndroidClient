package com.pokemonshowdown.data;

import android.content.Context;
import android.util.Log;

import com.pokemonshowdown.app.R;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by thain on 7/28/14.
 */
public class Pokedex {
    private final static String DexTAG = "POKEDEX_TAG";
    private HashMap<String, String> mPokedexEntries;

    private static Pokedex sPokedex;
    private Context mAppContext;

    private Pokedex(Context appContext) {
        mAppContext = appContext;
        mPokedexEntries = readFile(appContext);
    }

    public static Pokedex get(Context c) {
        if (sPokedex == null) {
            sPokedex = new Pokedex(c.getApplicationContext());
        }
        return sPokedex;
    }

    public HashMap<String, String> getPokedexEntries() {
        return mPokedexEntries;
    }

    public String getPokemon(String name) {
        return mPokedexEntries.get(name);
    }

    private HashMap<String, String> readFile(Context appContext) {
        HashMap<String, String> pokedexEntries = new HashMap<String, String>();
        String jsonString;
        try {
            InputStream inputStream = appContext.getResources().openRawResource(R.raw.pokedex);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append("\n");
            }
            jsonString = stringBuilder.toString();
            inputStream.close();
            Log.d(DexTAG, jsonString);

            JSONObject jsonObject = new JSONObject(jsonString);

            Iterator<String> keys = jsonObject.keys();

            while (keys.hasNext()) {
                String key = keys.next();
                Object value = jsonObject.get(key);
                if (jsonObject.get(key) instanceof JSONObject) {
                    JSONObject entry = (JSONObject) value;
                    pokedexEntries.put(key, entry.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pokedexEntries;
    }
}
