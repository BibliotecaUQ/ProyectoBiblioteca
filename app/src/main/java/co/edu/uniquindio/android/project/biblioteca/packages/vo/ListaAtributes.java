package co.edu.uniquindio.android.project.biblioteca.packages.vo;


/**
 * clase Lista de atributos contenidos en el JSon, en esta clase se tienen los atributos que deben tener los eventos como nombre,
 * desripcion , y  una imagen.
 * contiene metodos de estos atributos getters y setters
 *
 * @author jhoan sebastian gomez medina
 * @author john sebastian agudelo ospina
 */

public class ListaAtributes {
    /**
     * Constructor de contacto que inicializa los dos primeros atributos
     */
   // private String Nombre;
    private String Descripcion;
    private int imagen;

    /**
     * Constructor de noticias que inicializa los dos primeros atributos
     *
     * @param nombre      de la noticia
     * @param descripcion detalle de la noticia
     * @param imagen      imagen de la noticia
     */
    public ListaAtributes(String nombre, String descripcion, int imagen) {
        //this.Nombre = nombre;
        this.Descripcion = descripcion;
        this.imagen = imagen;
    }

    /**
     * Metodo para obtener el nombre
     *
     * @return imagen dela noticia
     */
   // public void setNombre(String nombre) {
   //     Nombre = nombre;
   // }

    /**
     * Metodo para obtener la imagen
     *
     * @return
     */
    public int getImagen() {
        return imagen;
    }

    /**
     * Metodo para poner la imagen
     *
     * @param imagen
     */
    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    /**
     * Metodo para obtener la descripcion
     *
     * @return
     */
    public String getDescripcion() {
        return Descripcion;
    }

    /**
     * Metodo para obtener la descripcion
     *
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }
}
