package co.edu.uniquindio.android.project.biblioteca.packages.actividades;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

    @BindView(R.id.autor_2)
    public TextView autor_2;
    @BindView(R.id.info)
    public TextView info;
    @BindView(R.id.creada_anio)
    public TextView creada_anio;
    @BindView(R.id.version)
    public TextView version;

    /**
     * aca se crea la vista del layout correspondiente a la clase.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);
        ButterKnife.bind(this);
        atras();
        getSupportActionBar().setTitle("Acerca De");
        asignarElementosLayout();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    /**
     * Elementos mostrados en el layout
     */
    private void asignarElementosLayout() {
        info.setText(R.string.info);
        version.setText(R.string.version);
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
