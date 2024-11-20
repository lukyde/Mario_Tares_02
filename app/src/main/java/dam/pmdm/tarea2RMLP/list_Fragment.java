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

    private ArrayList<Mario> marios;
    private MarioRecyclerViewAdapter adapter;
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

        loadMario();
        Snackbar.make(view, getString(R.string.snackbar), Snackbar.LENGTH_SHORT) .show();
        adapter = new MarioRecyclerViewAdapter(marios, getActivity());
        binding.mortdeloRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.mortdeloRecyclerView.setAdapter(adapter);

    }





    /**
     * Carga la lista de personajes de Mortadelo y Filemón en el ArrayList `mortadelos`.
     * Cada personaje incluye una imagen, un nombre, una descripción y habilidades.
     */


    private void loadMario(){
            marios = new ArrayList<>();

        marios.add(new Mario( R.drawable.mario,
                getString(R.string.mario_nombre),
                getString(R.string.mario_descripcion),
                getString(R.string.mario_habilidades)
        ));

        marios.add(new Mario(R.drawable.luigi,
                getString(R.string.luigi_nombre),
                getString(R.string.luigi_descripcion),
                getString(R.string.luigi_habilidades)
        ));
        marios.add(new Mario(R.drawable.peach,
                getString(R.string.peach_nombre),
                getString(R.string.peach_descripcion),
                getString(R.string.peach_habilidades)
        ));
        marios.add(new Mario(R.drawable.bowser,
                getString(R.string.bowser_nombre),
                getString(R.string.bowser_descripcion),
                getString(R.string.bowser_habilidades)
        ));
        marios.add(new Mario(R.drawable.toad,
                getString(R.string.toad_nombre),
                getString(R.string.toad_descripcion),
                getString(R.string.toad_habilidades)
        ));
        marios.add(new Mario(R.drawable.yoshi,
                getString(R.string.yoshi_nombre),
                getString(R.string.yoshi_descripcion),
                getString(R.string.yoshi_habilidades)
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