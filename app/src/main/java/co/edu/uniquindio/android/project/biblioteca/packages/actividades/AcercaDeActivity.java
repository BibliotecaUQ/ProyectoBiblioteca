package co.edu.uniquindio.android.project.biblioteca.packages.actividades;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import butterknife.ButterKnife;
import co.edu.uniquindio.android.project.biblioteca.packagesAR.R;

/**
 * Clase que contiene la información para mostrar información de la aplicacion y quienes la crearon
 * @author jonh sebastian agudelo ospina
 */
public class AcercaDeActivity extends AppCompatActivity {


    /**
     * aca se crea la vista del layout correspondiente a la clase.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);
        ButterKnife.bind(this);

        WebView WebView = (WebView) this.findViewById(R.id.about_view);
        WebView.loadUrl("file:///android_asset/about.html");
        WebView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = WebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        atras();
        getSupportActionBar().setTitle("Acerca De");
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
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
