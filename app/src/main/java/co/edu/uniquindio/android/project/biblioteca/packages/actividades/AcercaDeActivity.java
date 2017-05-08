package co.edu.uniquindio.android.project.biblioteca.packages.actividades;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import co.edu.uniquindio.android.project.biblioteca.packagesAR.R;

/**
 * Clase que contiene la información para mostrar información de la aplicacion y quienes la crearon
 * Created on 12/04/2017.
 *
 * @author jhoan sebastian gomez medina
 *
 * @author john sebastian agudelo ospina
 */

public class AcercaDeActivity extends AppCompatActivity {
   
    //textview usados en la vista
    public TextView creada_por;
    public TextView autor_1;
    public TextView autor_2;
    public TextView creada_anio;
    public ImageView image;

    /**
     * aca se crea la vista dela layout correspondiente a la clase.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);
        atras();
        asignarElementosLayout();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    //Elementos mostrados en el layout
    private void asignarElementosLayout() {

        image = (ImageView) findViewById(R.id.imagen_detalle);
        image.setImageResource(R.drawable.crai_acerca_de);
        creada_por = (TextView) findViewById(R.id.creada_por);
        creada_por.setText(R.string.creada_por);
        autor_1 = (TextView) findViewById(R.id.autor_1);
        autor_1.setText(R.string.autor_1);
        autor_2 = (TextView) findViewById(R.id.autor_2);
        autor_2.setText(R.string.autor_2);
        creada_anio = (TextView) findViewById(R.id.creada_anio);
        creada_anio.setText(R.string.creada_anio);
    }

    //Accion atras
    private void atras() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    //Accion atras
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }

}
