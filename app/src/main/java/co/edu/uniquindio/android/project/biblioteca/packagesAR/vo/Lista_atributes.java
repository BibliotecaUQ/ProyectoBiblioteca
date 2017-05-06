package co.edu.uniquindio.android.project.biblioteca.packagesAR.vo;


/**
 * clase personajes , en esta clase se tienen los atributos que deben tener los personajes como nombre, desripcion , y una imagne.
 * contiene metodos de estos atributos getters y setters
 * @author jhoan sebastian gomez medina
 * @author john sebastian agudelo ospina
 */

public class Lista_atributes {
    /**
     * Constructor de contacto que inicializa los dos primeros atributos
     */
    private String Nombre;
    private String Descripcion;
    private int imagen;

    /**
     * Constructor de noticias que inicializa los dos primeros atributos
     * @param   nombre de la noticia
     * @param descripcion detalle de la noticia
     *@param imagen imagen de la noticia
     */
    public Lista_atributes(String nombre, String descripcion, int imagen) {
        this.Nombre = nombre;
        this.Descripcion = descripcion;
        this.imagen=imagen;
    }


    /**
     *  Metodo para obtener el nombre del personaje
     * @return nombre del personaje
     */
    public String getNombre() {
        return Nombre;
    }
    /**
     * Metodo para dar nombre al personaje
     * @return imagen dela noticia
     */
    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    /**
     *  Metodo para obtener la imagen del personaje
     * @return
     */
    public int getImagen() {
        return imagen;
    }

    /**
     *  Metodo para poner la imagen del personaje
     * @param imagen del personaje mostrado
     */
    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    /**
     *  Metodo para obtener la descripcion del personaje
     *
     * @return
     */
    public String getDescripcion() {
        return Descripcion;
    }

    /**
     *  Metodo para obtener la descripcion del personaje
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }
}
