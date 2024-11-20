package dam.pmdm.tarea2RMLP;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Switch;

import androidx.annotation.Nullable;
import androidx.preference.EditTextPreference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SwitchPreferenceCompat;

import java.util.Locale;

/**
 * PreferencesFragment es un fragmento que proporciona la interfaz de configuración
 * de preferencias de la aplicación. Permite al usuario establecer su nombre de usuario
 * y contraseña a través de campos de texto.
 */

public class PreferencesFragment  extends PreferenceFragmentCompat {

    EditTextPreference userNamePreference;
    EditTextPreference contrasenaPreference;
    private Switch switchIdioma;

    /**
     * Inicializa las preferencias del fragmento desde el archivo XML especificado
     * y enlaza las preferencias de nombre de usuario y contraseña.
     *
     * @param savedInstanceState Estado previamente guardado del fragmento.
     * @param rootKey Clave raíz opcional para cargar un conjunto específico de preferencias.
     */
    @Override
    public void onCreatePreferences(@Nullable Bundle savedInstanceState, @Nullable String rootKey) {

        setPreferencesFromResource(R.xml.preference, rootKey);

       userNamePreference = findPreference("username");
       contrasenaPreference = findPreference("password");

        SwitchPreferenceCompat switchIdioma = findPreference("language_switch");

        SharedPreferences preferences = getActivity().getSharedPreferences("prefs", Context.MODE_PRIVATE);
        boolean isSpanish = preferences.getBoolean("isSpanish", false);
        switchIdioma.setChecked(isSpanish);
        setLocale(isSpanish ? "es" : "en");


        switchIdioma.setOnPreferenceChangeListener((preference, newValue) -> {
            boolean isChecked = (boolean) newValue;

            // Guardar el estado en SharedPreferences
            preferences.edit().putBoolean("isSpanish", isChecked).apply();

            // Cambiar el idioma
            setLocale(isChecked ? "es" : "en");

            // Reiniciar actividad
            actualizar();

            return true;
        });
    }

                /**
                 * Cambia la configuración de localización de la aplicación al idioma especificado.
                 *
                 * @param lang Código del idioma, por ejemplo, "es" para español o "en" para inglés.
                 */
        private void setLocale(String lang) {
            Locale locale = new Locale(lang);
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            getActivity().getResources().updateConfiguration(config, getActivity().getResources().getDisplayMetrics());




        }

    /**
     * Reinicia la actividad actual para aplicar el cambio de idioma.
     * Se usa al cambiar el idioma para recargar la interfaz en el nuevo idioma seleccionado.
     */

    void actualizar(){

        // Reiniciar la actividad actual para aplicar el cambio de idioma
        if (getActivity() != null) {
            Intent intent = getActivity().getIntent();
            getActivity().finish();
            startActivity(intent);
        }



    }


}
