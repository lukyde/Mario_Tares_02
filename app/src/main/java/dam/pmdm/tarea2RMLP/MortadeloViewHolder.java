package dam.pmdm.tarea2RMLP;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import dam.pmdm.tarea2RMLP.databinding.FragmentListBinding;
import dam.pmdm.tarea2RMLP.databinding.MortadeloCardBinding;
/**
 *ViewHolder para el adaptador de RecyclerView que representa un elemento de la lista de Mortadelo.
 */

public class MortadeloViewHolder extends RecyclerView.ViewHolder {

    private final MortadeloCardBinding binding;
    /**
     *Constructor que inicializa el ViewHolder para un elemento de la lista
     * @param binding se le pasa el bindeo del XMl para gestionarlo luego en el RecyclerView
     */
    public MortadeloViewHolder(MortadeloCardBinding binding) {
        super(binding.getRoot());
        this.binding= binding;
    }
    /**
     *Método que introduce los datos del objeto mortadelo en las vistas de la tarjeta.
     *
     * @param mortadelo objeto del tipo mortadelo donde se encuentran los datos de las tarjetas; el nombre y la imagen.
     */

    public void bind (Mortadelo mortadelo){

        binding.texto.setText(mortadelo.getNombre());
        Picasso.get().load(mortadelo.getImagen()).into(binding.imagen);


        binding.executePendingBindings();
    }

}
