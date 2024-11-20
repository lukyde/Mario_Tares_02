package dam.pmdm.tarea2RMLP;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import dam.pmdm.tarea2RMLP.databinding.MarioCardBinding;
/**
 *ViewHolder para el adaptador de RecyclerView que representa un elemento de la lista de Mortadelo.
 */

public class MarioViewHolder extends RecyclerView.ViewHolder {

    private final MarioCardBinding binding;
    /**
     *Constructor que inicializa el ViewHolder para un elemento de la lista
     * @param binding se le pasa el bindeo del XMl para gestionarlo luego en el RecyclerView
     */
    public MarioViewHolder(MarioCardBinding binding) {
        super(binding.getRoot());
        this.binding= binding;
    }
    /**
     *Método que introduce los datos del objeto mortadelo en las vistas de la tarjeta.
     *
     * @param mario objeto del tipo mortadelo donde se encuentran los datos de las tarjetas; el nombre y la imagen.
     */

    public void bind (Mario mario){

        binding.texto.setText(mario.getNombre());
        Picasso.get().load(mario.getImagen()).into(binding.imagen);


        binding.executePendingBindings();
    }

}
