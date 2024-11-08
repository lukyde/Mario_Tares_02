package dam.pmdm.tarea2RMLP;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.snackbar.Snackbar;
import dam.pmdm.tarea2RMLP.databinding.FragmentListBinding;
import java.util.ArrayList;
/**
 * Fragmento que muestra una lista de personajes de Mortadelo y Filemón en un RecyclerView.
 *
 */

public class list_Fragment extends Fragment {

    private ArrayList<Mortadelo> mortadelos;
    private MortadeloRecyclerViewAdapter adapter;
    private FragmentListBinding binding;

    /**
     * Crea y devuelve la vista del fragmento inflando su diseño XML.
     *

     */
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }
    /**
     * Inicializa el adaptador del RecyclerView y carga la lista de personajes Mortadelo.
     * Muestra un mensaje usando un Snackbar.
     *
     * @param view La vista creada.
     * @param savedInstanceState el guardado anterior
     */


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        loadMortadelo();
        Snackbar.make(view, getString(R.string.snackbar), Snackbar.LENGTH_SHORT) .show();
        adapter = new MortadeloRecyclerViewAdapter(mortadelos, getActivity());
        binding.mortdeloRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.mortdeloRecyclerView.setAdapter(adapter);

    }





    /**
     * Carga la lista de personajes de Mortadelo y Filemón en el ArrayList `mortadelos`.
     * Cada personaje incluye una imagen, un nombre, una descripción y habilidades.
     */


    private void loadMortadelo(){
            mortadelos = new ArrayList<>();

        mortadelos.add(new Mortadelo ( R.drawable.bacterio,
                getString(R.string.bacterio_Text),
                getString(R.string.descripcion_bacterio),
                getString(R.string.habilidades_bacterio)
        ));

        mortadelos.add(new Mortadelo(R.drawable.mortadelo,
                getString(R.string.mortadelo_nombre),
                getString(R.string.mortadelo_descripcion),
                getString(R.string.mortadelo_habilidades)
        ));
        mortadelos.add(new Mortadelo(R.drawable.filemon,
                getString(R.string.filemon_nombre),
                getString(R.string.filemon_descripcion),
                getString(R.string.filemon_habilidades)
        ));
        mortadelos.add(new Mortadelo(R.drawable.superintendente,
                getString(R.string.super_nombre),
                getString(R.string.super_descripcion),
                getString(R.string.super_habilidades)
        ));
        mortadelos.add(new Mortadelo(R.drawable.ofelia,
                getString(R.string.ofelia_nombre),
                getString(R.string.ofelia_descripcion),
                getString(R.string.ofelia_habilidades)
        ));
        mortadelos.add(new Mortadelo(R.drawable.superlopez,
                getString(R.string.superlopez_nombre),
                getString(R.string.superlopez_descripcion),
                getString(R.string.superlopez_habilidades)
        ));
        mortadelos.add(new Mortadelo(R.drawable.anacleto,
                getString(R.string.anacleto_Text),
                getString(R.string.descripcion_anacleto),
                getString(R.string.habilidades_anacleto)
        ));



    }

    /**
     *
     * Establece el título de la barra de acción en "Lista".
     */
    @Override
    public void onStart(){
        super.onStart();
        if (getActivity() != null){

            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.lista);
        }

    }

}