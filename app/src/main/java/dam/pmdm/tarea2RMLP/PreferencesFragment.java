package dam.pmdm.tarea2RMLP;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.preference.EditTextPreference;
import androidx.preference.PreferenceFragmentCompat;

/**
 * PreferencesFragment es un fragmento que proporciona la interfaz de configuración
 * de preferencias de la aplicación. Permite al usuario establecer su nombre de usuario
 * y contraseña a través de campos de texto.
 */

public class PreferencesFragment  extends PreferenceFragmentCompat {

    EditTextPreference userNamePreference;
    EditTextPreference contrasenaPreference;

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
    }


}
