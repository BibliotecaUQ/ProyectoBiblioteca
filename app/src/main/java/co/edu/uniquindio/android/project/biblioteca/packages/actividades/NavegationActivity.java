package co.edu.uniquindio.android.project.biblioteca.packages.actividades;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.JsonReader;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import android.webkit.WebViewClient;
import butterknife.BindView;
import butterknife.ButterKnife;
import co.edu.uniquindio.android.project.biblioteca.packages.fragmentos.HomeFragment;
import co.edu.uniquindio.android.project.biblioteca.packages.vo.JSONReader;
import co.edu.uniquindio.android.project.biblioteca.packagesAR.R;


/**
 * clase principal donde se tiene el manejo de la navegación y el layout principal
 *
 * @author jonh sebastian agudelo ospina
 */
public class NavegationActivity extends AppCompatActivity {

    @BindView(R.id.drawer_layout)
    public DrawerLayout drawerLayout;
    //URL Enlace a datos
    private static String urljson = "https://bibliotecauq.github.io/data.json";
    //TextView
    @BindView(R.id.nombre_Evento)
    public TextView mens;
    @BindView(R.id.descripcion_evento)
    public TextView desc;
    //ImageView
    @BindView(R.id.image_evento)
    public ImageView img;
    //JSON reader
    private JsonReader reader;
    //Listado contenido del Json
    private List list_contenido_json;
    //Variable Bitmap que contendra la imagen del Json
    private Bitmap imagen;
    private Bitmap imagen2;
    @BindView(R.id.nombre_Ev)
    public TextView nom_ev;
    @BindView(R.id.descripcion_ev)
    public TextView desc_ev;
    @BindView(R.id.image_ev)
    public ImageView img_ev;
    private HttpURLConnection urlConnection;
    private WebView WebView;
    /**
     * Este metodo contiene el metodo de opciones del menu, ademas
     * de que se encarga de crear la vista del layout principal de la navegacion. cada opcion del menu realiza un accion distinta.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navegation);
        ButterKnife.bind(this);
        if (!verificaConexion(getBaseContext())) {
            Toast.makeText(getApplicationContext(), R.string.alerta_conexion, Toast.LENGTH_LONG).show();
            WebView = (WebView) this.findViewById(R.id.home_view);
            WebView.loadUrl("file:///android_asset/home.html");
            WebView.setWebViewClient(new WebViewClient());
            WebSettings webSettings = WebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
        } else {
            WebView = (WebView) this.findViewById(R.id.home_view);
            WebView.loadUrl("https://bibliotecauq.github.io/home");
            WebView.setWebViewClient(new WebViewClient());
            WebSettings webSettings = WebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
        }
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_nav_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navView = (NavigationView) findViewById(R.id.navview);
        navView.setItemIconTintList(null);
        //navigation view
        remplazarFragmentohome(new HomeFragment());
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {


            /**
             * este metodo se encarga de verificar que opcion o item de la navegacion es seleccionado
             * para que a partir de ello se cree una vista diferente en cada caso. En cada opcion.
             *
             * @param item
             * @return true segun la opcion de menu escogida
             */
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_seccion_1:
                        remplazarActivity(new LocalizarActivity());
                        break;

                    case R.id.menu_seccion_2:
                        Toast.makeText(getApplicationContext(), R.string.escanear, Toast.LENGTH_SHORT).show();
                        remplazarActivity(new UnityPlayerNativeActivity());
                        break;

                    case R.id.menu_seccion_3:
                        remplazarActivity(new AcercaDeActivity());
                        break;

                    case R.id.menu_opcion_1:
                        if (!verificaConexion(getApplicationContext())) {
                            Toast.makeText(getApplicationContext(), R.string.alerta_conexion, Toast.LENGTH_SHORT).show();
                        } else {
                            remplazarActivity(new WebViewer());
                        }

                        break;

                    case R.id.menu_opcion_4:
                        if (!verificaConexion(getApplicationContext())) {
                            Toast.makeText(getApplicationContext(), R.string.alerta_conexion, Toast.LENGTH_SHORT).show();
                        } else {
                            remplazarActivity(new CommentViewer());
                        }

                        break;

                    case R.id.menu_opcion_3:
                        //Sale de la activity principal
                        finish();
                        break;
                    case R.id.atajos_1:
                        if (!verificaConexion(getBaseContext())) {
                            Toast.makeText(getApplicationContext(), R.string.alerta_conexion, Toast.LENGTH_LONG).show();

                        } else {
                            Uri uri = Uri.parse("https://www.uniquindio.edu.co/publicaciones/bases_de_datos_pub");
                            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                            startActivity(intent);
                        }
                        break;
                    case R.id.atajos_2:
                        if (!verificaConexion(getBaseContext())) {
                            Toast.makeText(getApplicationContext(), R.string.alerta_conexion, Toast.LENGTH_LONG).show();

                        } else {
                            Uri uri = Uri.parse("https://ecotic.uniquindio.edu.co/ecotic/#!/home");
                            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                            startActivity(intent);
                        }
                        break;
                    case R.id.social_1:
                        if (!verificaConexion(getBaseContext())) {
                            Toast.makeText(getApplicationContext(), R.string.alerta_conexion, Toast.LENGTH_LONG).show();

                        } else {
                            Uri uri = Uri.parse("https://www.youtube.com/c/JHDACRAI?sub_confirmation=1");
                            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                            startActivity(intent);
                        }
                        break;
                    case R.id.social_2:
                        if (!verificaConexion(getBaseContext())) {
                            Toast.makeText(getApplicationContext(), R.string.alerta_conexion, Toast.LENGTH_LONG).show();

                        } else {
                            Uri uri = Uri.parse("https://api.whatsapp.com/send?phone=573205064442");
                            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                            startActivity(intent);
                        }
                        break;
                    default: //nothing
                }
                item.setChecked(true);
                drawerLayout.closeDrawers();
                return true;
            }
        });
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bot_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bot_inicio:
                        if (!verificaConexion(getBaseContext())) {
                            Toast.makeText(getApplicationContext(), R.string.alerta_conexion, Toast.LENGTH_LONG).show();
                            WebView.loadUrl("file:///android_asset/home.html");
                            WebView.setWebViewClient(new WebViewClient());
                            WebSettings webSettings = WebView.getSettings();
                            webSettings.setJavaScriptEnabled(true);
                        } else {
                            WebView.loadUrl("https://bibliotecauq.github.io/home");
                            WebView.setWebViewClient(new WebViewClient());
                            WebSettings webSettings = WebView.getSettings();
                            webSettings.setJavaScriptEnabled(true);
                        }
                        break;
                    case R.id.bot_localizar:
                        remplazarActivity(new LocalizarActivity());
                        break;

                    case R.id.bot_recorrido:
                        Toast.makeText(getApplicationContext(), R.string.escanear, Toast.LENGTH_SHORT).show();
                        remplazarActivity(new UnityPlayerNativeActivity());
                        break;

                    case R.id.bot_catalogo:
                        if (!verificaConexion(getApplicationContext())) {
                            Toast.makeText(getApplicationContext(), R.string.alerta_conexion, Toast.LENGTH_SHORT).show();
                        } else {
                            remplazarActivity(new WebViewer());
                        }

                        break;

                    default: //nothing

                }
                return false;
            }
        });

    }

    /**
     * metodo que define verdadero o falso dependiento de si se
     * selecciona una opcion del menu de la navegación.
     *
     * @param item del menu de la navegacion
     * @return true o false segyn sea la seleccion
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;

            case android.R.id.button3:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            default://nothing
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Este metodo se encarga de reemplazar el layout principal de la navegacion por el Fragmento que contenga diferente informacion
     * dependiendo de la opcion del menu que se lecciones y el fragmento que contenga. este metodo se llama desde el item
     * deseado.
     */
    private void remplazarFragmentohome(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).addToBackStack(null).commit();

    }

    /**
     * Este metodo se encarga de reemplazar el layout principal de la navegacion por una Actividad que contenga diferente informacion
     * dependiendo de la opcion del menu que se lecciones y el fragmento que contenga. este metodo se llama desde el item
     * deseado.
     */
    private void remplazarActivity(Activity activity) {
        Intent intent = new Intent(this, activity.getClass());
        startActivity(intent);
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
            // Cuando se tiene conexion se pone a true
            if (redes[i].getState() == NetworkInfo.State.CONNECTED) {
                bConectado = true;
            }
        }
        return bConectado;
    }

    /**
     * Servicios rest-full
     * Class que realizará de forma asíncrona(BackGround) la consulta a la dirección HTTP donde se encuentra el archivo Json
     */
    private class JSONParse extends AsyncTask<String, String, JsonReader> {

        /**
         * onPreExecute:Evento de android studio en ciclo de vida de la APP e cuanto a procesar información
         */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            /*
            progressDialog = new ProgressDialog(NavegationActivity.this);
            progressDialog.setMessage("Cargando");
            progressDialog.setIndeterminate(false);
            progressDialog.setCancelable(true);
            progressDialog.show();
            */
        }

        /**
         * doInBackground:Evento de android studio en ciclo de vida de la APP e cuanto a procesar información
         *
         * @param args
         * @return
         */
        //Este metodo realizará la conexión devolviendo el JSON
        @Override
        protected JsonReader doInBackground(String... args) {

            try {
                // https://bibliotecauq.github.io/data.json
                URL url = new URL(urljson);
                urlConnection = (HttpURLConnection) url.openConnection();
                //temp = urlConnection.getResponseMessage();
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
                JSONReader cJSONReader = new JSONReader();
                try {
                    list_contenido_json = cJSONReader.readJSONMsg(reader);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                imagen = getImagenJson("" + list_contenido_json.get(2));
                imagen2 = getImagenJson("" + list_contenido_json.get(5));

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (urlConnection != null) urlConnection.disconnect();
            }
            return reader;
        }

        /**
         * onPostExecute:Evento de android studio en ciclo de vida de la APP e cuanto a procesar información
         *
         * @param reader
         */
        @Override
        protected void onPostExecute(JsonReader reader) {
            mens.setText("" + list_contenido_json.get(0));
            desc.setText("" + list_contenido_json.get(1));
            img.setImageBitmap(imagen);

            nom_ev.setText("" + list_contenido_json.get(3));
            desc_ev.setText("" + list_contenido_json.get(4));
            img_ev.setImageBitmap(imagen2);
/*
            if (progressDialog.isShowing()){
                progressDialog.dismiss();
            }
 */       }
    }

    /**
     * En este metodo se obtiene la imagen desde la url que se obtiene en el JSon y se retorna en una variable de tipo bitmap
     *
     * @param url
     * @return
     */
    private Bitmap getImagenJson(String url) {
        Bitmap bm = null;
        try {
            URL _url = new URL(url);
            URLConnection con = _url.openConnection();
            con.connect();
            InputStream is = con.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            bm = BitmapFactory.decodeStream(bis);
            bis.close();
            is.close();
        } catch (IOException e) {
            e.toString();
            e.printStackTrace();
        }
        return bm;
    }
}