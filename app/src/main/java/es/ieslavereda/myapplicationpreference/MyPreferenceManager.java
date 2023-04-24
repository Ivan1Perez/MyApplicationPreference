package es.ieslavereda.myapplicationpreference;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.preference.PreferenceManager;

public class MyPreferenceManager {

    private static MyPreferenceManager instance;
    private SharedPreferences preferences;

    private MyPreferenceManager(){

    }

    public static MyPreferenceManager getInstance(Context context){
        if(instance==null)
            instance = new MyPreferenceManager();

        instance.inicializa(context);
        return instance;
    }

    private void inicializa(Context context){
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public String getEditText(){
        return preferences.getString("edit_text_preferenceKey", "Default value");
    }

    public boolean getCheckbox(){
        return preferences.getBoolean("check_box_preference_1", false);
    }

    public boolean getSwitchPreference(){
        return preferences.getBoolean("switch_preference_key", false);
    }

}
