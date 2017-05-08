package co.edu.uniquindio.android.project.biblioteca.packages.actividades;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.regex.Pattern;

import butterknife.ButterKnife;
import co.edu.uniquindio.android.project.biblioteca.packagesAR.R;

/**
 * /**
 * Actividad donde se define logica correspondiente a el caso de uso de localizar libro
 *
 * @author jhoan sebastian gomez medina
 * @author john sebastian agudelo ospina
 */
public class LocalizarActivity extends AppCompatActivity {
    /**
     * onCreate:Evento de android studio en ciclo de vida de la APP, se instancian los elementos necesarios para esta vista
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localizar);
        ButterKnife.bind(this);
        getSupportActionBar().setTitle(R.string.localizar_libro);
        back();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ImageButton btn = (ImageButton) findViewById(R.id.button_Buscar);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText search = (EditText) findViewById(R.id.search);
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(search.getWindowToken(), 0);
                String cadena = search.getText().toString();
                double resultado = localizar(cadena);
                if (resultado != -1.0) {
                    double[] coordenadas = coordenadas(resultado);
                    ImageView im = (ImageView) findViewById(R.id.im);
                     im.setImageDrawable(getResources().getDrawable(R.drawable.location));
                    ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) im.getLayoutParams();
                    int x = getResources().getDrawable(R.drawable.biblioteca).getIntrinsicHeight();
                    int y = getResources().getDrawable(R.drawable.biblioteca).getIntrinsicWidth();
                    Log.v("resultado", String.valueOf(x) + " " + String.valueOf(y));
                    lp.leftMargin = (int) ((x + 130) * coordenadas[0]);
                    lp.topMargin = (int) ((y - 210) * coordenadas[1]);
                    //lp.leftMargin = x + 130;
                    //lp.topMargin = y - 210;
                } else {

                    Toast.makeText(getApplicationContext(), R.string.mensaje_error_localizar_libros, Toast.LENGTH_LONG).show();


                }
            }
        });
    }

    /**
     * Método que contiene las coordenadas correspondientes a cada estante
     *
     * @param estante id del estante
     * @return coordenadas x y y
     */
    public double[] coordenadas(double estante) {
        int x = (int) estante;
        // x | y
        double[][] porcentaje = {{0.207, 0.86},
                {0.207, 0.802},
                {0.207, 0.745},
                {0.207, 0.685},
                {0.207, 0.627},
                {0.207, 0.511},
                {0.207, 0.456},
                {0.207, 0.396},
                {0.207, 0.346},
                {0.207, 0.291},
                {0.207, 0.236},
                {0.207, 0.18},
                {0.207, 0.12},
                {0.535, 0.298},
                {0.89, 0.30},
                {0.89, 0.63}};
        double[] coordenadas = {porcentaje[x - 1][0], porcentaje[x - 1][1]};
        return coordenadas;
    }

    /**
     * Método que indentifica que tipo de código es y ejecuta el método correspondiente
     *
     * @param cadena código a identificar
     * @return ip del estante
     */

    public double localizar(String cadena) {
        try {
            double numero = Double.parseDouble(cadena);
            return localizarGeneral(numero);
        } catch (NumberFormatException nfe) {
            return localizarMedicina(cadena);
        }
    }

    /**
     * Método que lozaliza un código numérico
     *
     * @param n código a localizar
     * @return id del estante
     */
    public double localizarGeneral(double n) {
        // id estante | lado A
        Double[][] estantes = {{1.0, 1.0, 5.276},
                {2.0, 170.0, 307.76},
                {3.0, 307.76, 339.0},
                {4.0, 339.0, 364.3},
                {5.0, 364.36, 396.0},
                {6.0, 398.09861, 511.8},
                {7.0, 511.8, 519.53},
                {8.0, 519.53, 546.0},
                {9.0, 546.0, 612.0},
                {10.0, 621.381, 628.1688},
                {11.0, 628.1688, 657.76},
                {12.0, 657.76, 664.0},
                {13.0, 664.0, 698.1},
                {14.0, 800.0, 900.0}};
        for (Double[] fila : estantes) {
            if (fila[1] <= n && fila[2] >= n) {
                return fila[0];
            }
        }
        return -1.0;
    }

    /**
     * Método que devuelve el estante al que pertenece el código corriespondiente a medicina
     *
     * @param cadena código a localizar
     * @return id del estante
     */
    public double localizarMedicina(String cadena) {
        Pattern patQ = Pattern.compile("^(q|Q)[A-Za-z]?[1-9]*");
        Pattern patW = Pattern.compile("^(w|W)[A-Za-z]?[1-9]*");
        if (patQ.matcher(cadena).matches()) {
            return 15.0;
        } else if (patW.matcher(cadena).matches()) {
            return 16.0;
        }
        return -1.0;
    }

    /**
     * accion atras en toolbar
     */
    private void back() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    /**
     * accion atras en toolbar
     *
     * @return boolean
     */
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }
}