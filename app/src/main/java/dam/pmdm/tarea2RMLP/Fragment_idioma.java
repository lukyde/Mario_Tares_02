package dam.pmdm.tarea2RMLP;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/**
 * Fragment_idioma es una clase que representa un fragmento para seleccionar el idioma
 * de la aplicación. Permite al usuario alternar entre ingles y español.
 */

public class Fragment_idioma extends Fragment {


    private Switch switchIdioma;






    public Fragment_idioma() {

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
     * Inicializa el fragmento y sus configuraciones iniciales al crearse.
     *
     * @param savedInstanceState Contiene el estado previamente guardado del fragmento.
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    /**
     * Crea y devuelve la vista  asociada con este fragmento.
     * Configura el Switch de idioma, establece el idioma actual y gestiona el cambio de idioma.
     *
     * @param inflater           Inflater para inflar la vista del fragmento.
     * @param container          Contenedor que contiene la vista principal del fragmento.
     * @param savedInstanceState Estado previamente guardado del fragmento.
     * @return La vista creada para este fragmento.
     */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view =inflater.inflate(R.layout.fragment_idioma, container, false);

        switchIdioma = view.findViewById(R.id.switch_idioma);

        SharedPreferences preferences = getActivity().getSharedPreferences("prefs", Context.MODE_PRIVATE);
        boolean isSpanish = preferences.getBoolean("isSpanish", false);
        switchIdioma.setChecked(isSpanish);
        setLocale(isSpanish ? "es" : "en");


        switchIdioma.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Cambiar idioma y guardar preferencia
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("isSpanish", isChecked);
            editor.apply();

            // Cambiar el idioma
            setLocale(isChecked ? "es" : "en");

            actualizar();
        });

        return view;
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

    /**
     *
     * Establece el título de la barra de acción en "Lista".
     */
    @Override
    public void onStart(){
        super.onStart();
        if (getActivity() != null){

            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.idioma);

        }

    }
}