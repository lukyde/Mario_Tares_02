package dam.pmdm.tarea2RMLP;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import dam.pmdm.tarea2RMLP.databinding.FragmentListBinding;
import dam.pmdm.tarea2RMLP.databinding.MortadeloCardBinding;

/**
 *Clase que crea el adaptador que comunica el recycler con el ViewHolder.
 */

public class MortadeloRecyclerViewAdapter extends RecyclerView.Adapter<MortadeloViewHolder> {

    private final ArrayList<Mortadelo> mortadelo;
    private final   Context context;

    /**
     * Constructor que inicializa el adaptador con la lista de personajes y el contexto.
     * @param mortadelo Lista de objetos Mortadelo que serán mostrados en el RecyclerView.
     * @param context El contexto de la actividad donde se mostrará el RecyclerView.
     */
    public MortadeloRecyclerViewAdapter(ArrayList<Mortadelo> mortadelo,Context context){
        this.mortadelo= mortadelo;
        this.context= context;


    }

    /**
     *Método para crear la vista del ViewHolder
     * @return
     */
    @NonNull
    @Override
    public MortadeloViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        MortadeloCardBinding binding =MortadeloCardBinding.inflate(
                LayoutInflater.from(parent.getContext()),parent, false);;


        return new MortadeloViewHolder(binding);
    }

    /**
     * Enlaza los datos de un objeto Mortadelo con el ViewHolder.
     * También configura el click listener para manejar eventos de click en el item.
     *
     * @param holder El ViewHolder que contiene la vista del elemento.
     * @param position La posición del elemento en la lista de mortadelos.
     */

    @Override
    public void onBindViewHolder(@NonNull MortadeloViewHolder holder, int position) {


        Mortadelo currentMortadelo = this.mortadelo.get(position);
        holder.bind(currentMortadelo);

        holder.itemView.setOnClickListener(view -> itemClicked(currentMortadelo, view));

    }
    /**
     *Método para obtener la cantidad de holder que hay.
     * @return devuelve un entero con la cantidad de mortadelos.
     */

    @Override
    public int getItemCount() {
        return mortadelo.size();
    }


    /**
     * Método que se ejecuta cuando se hace click en un elemento.
     *
     * @param currentMortadelo El objeto Mortadelo que ha sido clicado.
     * @param view La vista donde se ha realizado el clic.
     */
    public void itemClicked(Mortadelo currentMortadelo, View view){

        ((MainActivity) context).mortadeloClicked(currentMortadelo, view);
    }
}
