package dam.pmdm.tarea2RMLP;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

import dam.pmdm.tarea2RMLP.databinding.MarioCardBinding;

/**
 *Clase que crea el adaptador que comunica el recycler con el ViewHolder.
 */

public class MarioRecyclerViewAdapter extends RecyclerView.Adapter<MarioViewHolder> {

    private final ArrayList<Mario> mario;
    private final   Context context;

    /**
     * Constructor que inicializa el adaptador con la lista de personajes y el contexto.
     * @param mario Lista de objetos Mario que serán mostrados en el RecyclerView.
     * @param context El contexto de la actividad donde se mostrará el RecyclerView.
     */
    public MarioRecyclerViewAdapter(ArrayList<Mario> mario, Context context){
        this.mario = mario;
        this.context= context;


    }

    /**
     *Método para crear la vista del ViewHolder
     * @return
     */
    @NonNull
    @Override
    public MarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        MarioCardBinding binding =MarioCardBinding.inflate(
                LayoutInflater.from(parent.getContext()),parent, false);;


        return new MarioViewHolder(binding);
    }

    /**
     * Enlaza los datos de un objeto Mortadelo con el ViewHolder.
     * También configura el click listener para manejar eventos de click en el item.
     *
     * @param holder El ViewHolder que contiene la vista del elemento.
     * @param position La posición del elemento en la lista de mortadelos.
     */

    @Override
    public void onBindViewHolder(@NonNull MarioViewHolder holder, int position) {


        Mario currentMario = this.mario.get(position);
        holder.bind(currentMario);

        holder.itemView.setOnClickListener(view -> itemClicked(currentMario, view));

    }
    /**
     *Método para obtener la cantidad de holder que hay.
     * @return devuelve un entero con la cantidad de mortadelos.
     */

    @Override
    public int getItemCount() {
        return mario.size();
    }


    /**
     * Método que se ejecuta cuando se hace click en un elemento.
     *
     * @param currentMario El objeto Mortadelo que ha sido clicado.
     * @param view La vista donde se ha realizado el clic.
     */
    public void itemClicked(Mario currentMario, View view){

        ((MainActivity) context).marioClicked(currentMario, view);
    }
}
