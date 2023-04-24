package es.ieslavereda.myapplicationpreference;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import androidx.annotation.Nullable;
import androidx.preference.ListPreference;
import androidx.preference.PreferenceFragmentCompat;

public class PreferenciasFragment extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(@Nullable Bundle savedInstanceState, @Nullable String rootKey) {
        setPreferencesFromResource(R.xml.preferencias,rootKey);

        ListPreference themePreference = getPreferenceManager().findPreference("theme_preference");
        themePreference.setOnPreferenceChangeListener((p,v)->{
            ThemeSetup.applyTheme(ThemeSetup.Mode.valueOf((String)v));

            return true;
        });
    }
}
