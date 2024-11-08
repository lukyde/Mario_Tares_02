package dam.pmdm.tarea2RMLP;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import dam.pmdm.tarea2RMLP.databinding.FragmentPersonajesBinding;

/**
 *Clase del tipo Fragment que se usa para gestionar la vista en detalles de los personajes.
 */

public class PersonajesFragment extends Fragment {

    private FragmentPersonajesBinding binding;
    private String nombre;


    /**
     *Método que infla la vista
     *
     * @param inflater objeto que gestiona el xml del fragment.
     * @param container  contenedor de la vista principal donde se introducira el fragment
     * @param savedInstanceState objeto que gestiona el estado anterior del fragmento.
     */

    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable  ViewGroup container,
                             @Nullable  Bundle savedInstanceState) {
      binding = FragmentPersonajesBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    /**
     * Se llama inmediatamente después de que onCreateView finaliza y se usa para inicializar componentes de la vista o configurar la interfaz con datos.
     *Configura los datos de los personajes que apareceran en el fragmento de detalle de cada personaje como es la imagen, el nombre, descripción y habilidades.
     * @param view la vista que devuelve el oncreate
     * @param savedInstanceState objeto que gestiona el estado anterior del fragmento.
     */


    @Override
    public void onViewCreated(@Nullable View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null){
            int imagen = getArguments().getInt("imagen");
             nombre = getArguments().getString("nombre");
            String descripcion = getArguments().getString("descripcion");
            String habilidades = getArguments().getString("habilidades");

            binding.texto.setText(nombre);
            binding.habilidades.setText(habilidades);
            binding.descripcion.setText(descripcion);
            Picasso.get().load(imagen).into(binding.imagen);
        }
    }
    @Override
    /**
     *
     * Establece el título de la barra de acción en este caso el personaje elegido.
     */
    public void onStart(){
        super.onStart();
        if (getActivity() != null){

            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(nombre);
        }

    }

}