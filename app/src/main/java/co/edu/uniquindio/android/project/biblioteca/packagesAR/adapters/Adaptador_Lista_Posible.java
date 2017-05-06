package co.edu.uniquindio.android.project.biblioteca.packagesAR.adapters;



import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import co.edu.uniquindio.android.project.biblioteca.packagesAR.R;
import co.edu.uniquindio.android.project.biblioteca.packagesAR.vo.Lista_atributes;

/**
 *Clase en la cual se llama el layout de detalle de lista y sse infla para ser mostrad con la informacion que llegue,
 * ya que se pone la imagen y la informacion correspondiente n cada caso segun el contexto
 * como atributos tiene un arreglo de personajes y el contexto de la actividad.
 */
public class Adaptador_Lista_Posible extends ArrayAdapter {

    private Lista_atributes[] lista;
    Activity context;
    /**
     *  Metodo constructor de la clase
     *   @param  context
     */
    public Adaptador_Lista_Posible(Activity context, Lista_atributes[] listaP){
        super(context, R.layout.adapter_posible_list,listaP);
        this.lista =listaP;
        this.context=context;

    }

    /**
     *  Metodo que retorna las vistas, este metodo es el encargado de
     *  inflar el layout y posterior a eso mostrar en la interfaz del usuario
     *  los datos de los contactos almacenados en el arraylist
     *
     *
     *   @return vista
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View vista = inflater.inflate(R.layout.adapter_posible_list,null);

        TextView List_text= (TextView) vista.findViewById(R.id.textView_Descripcion);
        List_text.setText(lista[position].getNombre());
        TextView Descripcion= (TextView) vista.findViewById(R.id.textView_Descripcion);
        Descripcion.setText(lista[position].getDescripcion());
        ImageView imagen = (ImageView) vista.findViewById(R.id.imageView);
        imagen.setImageResource(lista[position].getImagen());


        return vista;
    }

}
