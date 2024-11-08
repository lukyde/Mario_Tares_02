package dam.pmdm.tarea2RMLP;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * La clase Preference proporciona métodos para guardar y recuperar preferencias
 * relacionadas con el nombre de usuario y la clave (contraseña) de la aplicación
 * utilizando SharedPreferences.
*/

public class Preference {

    private static final String PREFS_NAME = "app_prefs";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_KEY = "password";

    /**
     * Obtiene el nombre de usuario almacenado en SharedPreferences.
     *
     * @param context Contexto necesario para acceder a SharedPreferences.
     * @return El nombre de usuario almacenado, o null si no se ha guardado.
     */

    public static String getKeyUsername(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(
                PREFS_NAME,
                Context.MODE_PRIVATE
        );




        return prefs.getString(KEY_USERNAME,null);
    }

    /**
     * Guarda el nombre de usuario en SharedPreferences.
     *
     * @param context Contexto necesario para acceder a SharedPreferences.
     * @param username El nombre de usuario a guardar.
     */

     public static void saveUserName(Context context, String username){
        SharedPreferences prefs = context.getSharedPreferences(
                PREFS_NAME,
                context.MODE_PRIVATE
        );
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(KEY_USERNAME,username);
        editor.apply();

     }

    /**
     * Obtiene la contraseña almacenada en SharedPreferences.
     *
     * @param context Contexto necesario para acceder a SharedPreferences.
     * @return La contraseña almacenada, o null si no se ha guardado.
     */

    public static String getKeyKey(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(
                PREFS_NAME,
                Context.MODE_PRIVATE
        );
        return prefs.getString(KEY_KEY, null);
    }


    /**
     * Guarda la contraseña en SharedPreferences.
     *
     * @param context Contexto necesario para acceder a SharedPreferences.
     * @param password La contraseña a guardar.
     */

    public static void saveKey(Context context, String  password){
        SharedPreferences prefs = context.getSharedPreferences(
                PREFS_NAME,
                context.MODE_PRIVATE
        );
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(KEY_KEY, password);
        editor.apply();


    }
}
