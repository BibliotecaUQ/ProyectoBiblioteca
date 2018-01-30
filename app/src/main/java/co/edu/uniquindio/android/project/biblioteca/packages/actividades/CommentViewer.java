package co.edu.uniquindio.android.project.biblioteca.packages.actividades;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import butterknife.ButterKnife;
import co.edu.uniquindio.android.project.biblioteca.packagesAR.R;

/**
 * clase principal donde se tiene el manejo de la navegacion a la pagina web de comentarios
 *
 * @author john sebastian agudelo ospina
 */
public class CommentViewer extends AppCompatActivity {

    //Variable Web view
    private WebView WebView;

    /**
     * metodo onCreate, en este metodo se instancia el layout que se debe iniciar y sus correspondientes confguraciones
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comment_view);
        ButterKnife.bind(this);

        WebView = (WebView) this.findViewById(R.id.comment_view);
        WebView.loadUrl("https://bibliotecauq.github.io/comments");
        WebView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = WebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        atras();
        getSupportActionBar().setTitle("Comentarios");
    }

    /**
     * Metodo que adiciona el Toolbar que contiene accion atras en toolbar
     */
    private void atras() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    /**
     * accion atras en toolbar
     */
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }

    /**
     * opciones del menu puestas en el toolbar
     *
     * @param menu
     * @return Boolean
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Infla el menu.
        getMenuInflater().inflate(R.menu.menu_wv, menu);
        return true;
    }

    /**
     * seleccion de las opciones del menu
     *
     * @param item
     * @return Boolean
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_1:
                Log.i("ActionBar", "Nuevo!");
                if (!verificaConexion(getBaseContext())) {
                    Toast.makeText(getApplicationContext(), R.string.alerta_conexion, Toast.LENGTH_LONG).show();
                } else {
                    WebView = (WebView) this.findViewById(R.id.comment_view);
                    WebView.loadUrl("https://bibliotecauq.github.io/comments");
                    WebView.setWebViewClient(new WebViewClient());
                    WebSettings webSettings = WebView.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                }
                return true;

            case R.id.menu_2:
                  if (!verificaConexion(getBaseContext())) {
                    Toast.makeText(getApplicationContext(), R.string.alerta_conexion, Toast.LENGTH_LONG).show();

                } else {
                    Uri uri = Uri.parse("https://bibliotecauq.github.io/comments");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                return true;

            case R.id.menu_3:
                String ur = "https://bibliotecauq.github.io/comments";
                if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.HONEYCOMB) {
                    android.text.ClipboardManager clipboard = (android.text.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                    clipboard.setText(ur);
                } else {
                    android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                    android.content.ClipData clip = android.content.ClipData.newPlainText("Copied Text", ur);
                    clipboard.setPrimaryClip(clip);
                    Toast.makeText(getApplicationContext(), R.string.mensaje_texto_copiado, Toast.LENGTH_LONG).show();
                }
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Este metodo verifica si la conexion a internet esta disponible,
     * si lo esta devuelve un true de lo contrario un false.
     *
     * @param ctx
     * @return true o false segun sea el estado de la conexion
     */
    public static boolean verificaConexion(Context ctx) {
        boolean bConectado = false;
        ConnectivityManager connec = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        // No solo wifi, tambien GPRS
        NetworkInfo[] redes = connec.getAllNetworkInfo();
        // este bucle no es tan grande
        for (int i = 0; i < 2; i++) {
            // Cuando Tenemos conexion se pone a true
            if (redes[i].getState() == NetworkInfo.State.CONNECTED) {
                bConectado = true;
            }
        }
        return bConectado;
    }
}
