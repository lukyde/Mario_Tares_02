package dam.pmdm.tarea2RMLP;

/**
 *Clase que crea objetos de tipo mario, que son los personajes que apareceran en la app
 *
 */

public class Mario {

    private int imagen;
    private String nombre;
    private String descripcion;
    private String habilidades;

   public Mario(int imagen, String nombre, String descripcion, String habilidades){
      this.nombre = nombre;
      this.imagen = imagen;
      this.descripcion= descripcion;
      this.habilidades = habilidades;
   }
    /**
     *Método para obtener la imagen del personaje.
     * @return devuelve un entero que gestiona la posición de la imagen en el drawable.
     */
    public int getImagen() {
        return imagen;
    }
    /**
     *Método para obtener el nombre del personaje.
     * @return devuelve un String con el nombre.
     */


    public String getNombre() {
        return nombre;
    }
    /**
     *Método para obtener la descripción del personaje.
     * @return devuelve un String con la descripción.
     */

    public String getDescripcion() {
        return descripcion;
    }

    /**
     *Método para obtener las habilidades del personaje.
     * @return devuelve un String con las habilidades.
     */

    public String getHabilidades() {
        return habilidades;
    }
}
