package co.edu.uniquindio.android.project.biblioteca.packages.actividades;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import java.util.ArrayList;
import co.edu.uniquindio.android.project.biblioteca.packagesAR.R;



/**
 * Created by sebastian on 5/05/17.
 */

public class Localizar {

    private TableLayout tabla; // Layout donde se pintará la tabla
    private ArrayList<TableRow> filas; // Array de las filas de la tabla
    private Activity actividad;

    private int FILAS;// Filas de la tabla
   // private int COLUMNAS;  // columnas de la tabla

    // private  Resources rs;


    /**
     * Constructor de la tabla
     * @param actividad Actividad donde va a estar la tabla
     * @param tabla TableLayout donde se pintará la tabla
     */
    public Localizar(Activity actividad, TableLayout tabla)
    {
        this.actividad = actividad;
        this.tabla = tabla;
       // rs = this.actividad.getResources();
        FILAS = 0;
       // COLUMNAS =0;
         filas = new ArrayList<TableRow>();
    }




    /**
     * Agrega una fila a la tabla
     *
     */
    public void agregarFilaTabla(ArrayList<String> elementos)
    {
        TableRow.LayoutParams layoutCelda;
        TableRow.LayoutParams layoutFila = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
        TableRow fila = new TableRow(actividad);
        fila.setLayoutParams(layoutFila);

        for(int i = 0; i< elementos.size(); i++)
        {
            TextView texto = new TextView(actividad);
            texto.setText(String.valueOf(elementos.get(i)));
            texto.setGravity(Gravity.CENTER_HORIZONTAL);
            //texto.setTextAppearance(actividad, R.style.estilo_celda);
            //texto.setBackgroundResource(R.drawable.tabla_celda);
            layoutCelda = new TableRow.LayoutParams(obtenerAnchoPixelesTexto(texto.getText().toString()), TableRow.LayoutParams.WRAP_CONTENT);
            //texto.setLayoutParams(layoutCelda);
          //texto.setBackgroundColor(colorAccent);

           texto.setTextColor(actividad.getResources().getColor(R.color.colorAccent));
            texto.setBackgroundColor(actividad.getResources().getColor(R.color.colorAccent));
            fila.addView(texto);
        }

        tabla.addView(fila);
        filas.add(fila);

        FILAS++;
    }








    /**
     * Obtiene el ancho en píxeles de un texto en un String
     *
     */
    private int obtenerAnchoPixelesTexto(String texto)
    {
        Paint p = new Paint();
        Rect bounds = new Rect();
        p.setTextSize(50);

        p.getTextBounds(texto, 0, texto.length(), bounds);
        return bounds.width();
    }
}
