package co.edu.uniquindio.android.project.biblioteca.packages.actividades;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.edu.uniquindio.android.project.biblioteca.packagesAR.R;

/**
 * Clase que contiene la información para mostrar información de la aplicacion y quienes la crearon
 *
 * @author jhoan sebastian gomez medina
 * @author john sebastian agudelo ospina
 */
public class AcercaDeActivity extends AppCompatActivity {

    //Views usados en el Loyout correspondiente
    @BindView(R.id.creada_por)
    public TextView creada_por;
    @BindView(R.id.autor_1)
    public TextView autor_1;
    @BindView(R.id.autor_2)
    public TextView autor_2;
    @BindView(R.id.creada_anio)
    public TextView creada_anio;
    @BindView(R.id.imagen_detalle)
    public ImageView image;

    /**
     * aca se crea la vista dela layout correspondiente a la clase.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);
        ButterKnife.bind(this);
        atras();
        asignarElementosLayout();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    /**
     * Elementos mostrados en el layout
     */
    private void asignarElementosLayout() {
        //Se define lo que va a cotener cada view que componen el Layout
        image.setImageResource(R.drawable.crai_acerca_de);
        creada_por.setText(R.string.creada_por);
        autor_1.setText(R.string.autor_1);
        autor_2.setText(R.string.autor_2);
        creada_anio.setText(R.string.creada_anio);
    }

    /**
     * Se adiciona Accion atras en el Action Bar
     */
    private void atras() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    /**
     * Accion atras:Evento de android studio en ciclo de vida de la APP, se instancian los elementos necesarios para esta vista
     *
     * @return Boolean dependiendo de lo que se presione
     */
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }
}
