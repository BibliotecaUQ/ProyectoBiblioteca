package co.edu.uniquindio.android.project.biblioteca.packages.actividades;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.regex.Pattern;
import butterknife.ButterKnife;
import co.edu.uniquindio.android.project.biblioteca.packagesAR.R;

/**
 * Actividad donde se define logica correspondiente a el caso de uso de localizar libro
 *
 * @author jonh sebastian agudelo ospina
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
                ImageView image = (ImageView) findViewById(R.id.biblioteca);
                TextView textResultado = (TextView) findViewById(R.id.label_resultado);
                if (resultado != -1.0) {
                    setImage(resultado,image);
                    Toast.makeText(getApplicationContext(), R.string.mensaje_exito_localizar_libros, Toast.LENGTH_LONG).show();
                    int estante =(int) resultado;
                    if(estante == 21)
                        textResultado.setText("El libro "+cadena+ "se encuentra en el pasillo R.");
                    else
                        textResultado.setText("El libro "+cadena+ "se encuentra en el pasillo "+estante+".");
                } else {
                    image.setImageDrawable(getResources().getDrawable(R.drawable.biblioteca_localizar0));
                    Toast.makeText(getApplicationContext(), R.string.mensaje_error_localizar_libros, Toast.LENGTH_LONG).show();
                    textResultado.setText("Intente de nuevo.");
                }
            }
        });
    }

    /**
     * Método que cambia la imagen de fondo según el estante
     * @param resultado : Número del estante
     * @param image : Variable imagen
     */
    private void setImage(double resultado, ImageView image) {
        if(resultado == 1.0)
            image.setImageDrawable(getResources().getDrawable(R.drawable.biblioteca_localizar1));
        else if (resultado == 2.0)
            image.setImageDrawable(getResources().getDrawable(R.drawable.biblioteca_localizar2));
        else if (resultado == 3.0)
            image.setImageDrawable(getResources().getDrawable(R.drawable.biblioteca_localizar3));
        else if (resultado == 4.0)
            image.setImageDrawable(getResources().getDrawable(R.drawable.biblioteca_localizar4));
        else if (resultado == 5.0)
            image.setImageDrawable(getResources().getDrawable(R.drawable.biblioteca_localizar5));
        else if (resultado == 6.0)
            image.setImageDrawable(getResources().getDrawable(R.drawable.biblioteca_localizar6));
        else if (resultado == 7.0)
            image.setImageDrawable(getResources().getDrawable(R.drawable.biblioteca_localizar7));
        else if (resultado == 8.0)
            image.setImageDrawable(getResources().getDrawable(R.drawable.biblioteca_localizar8));
        else if (resultado == 9.0)
            image.setImageDrawable(getResources().getDrawable(R.drawable.biblioteca_localizar9));
        else if (resultado == 10.0)
            image.setImageDrawable(getResources().getDrawable(R.drawable.biblioteca_localizar10));
        else if (resultado == 11.0)
            image.setImageDrawable(getResources().getDrawable(R.drawable.biblioteca_localizar11));
        else if (resultado == 12.0)
            image.setImageDrawable(getResources().getDrawable(R.drawable.biblioteca_localizar12));
        else if (resultado == 13.0)
            image.setImageDrawable(getResources().getDrawable(R.drawable.biblioteca_localizar13));
        else if (resultado == 14.0)
            image.setImageDrawable(getResources().getDrawable(R.drawable.biblioteca_localizar14));
        else if (resultado == 15.0)
            image.setImageDrawable(getResources().getDrawable(R.drawable.biblioteca_localizar15));
        else if (resultado == 16.0)
            image.setImageDrawable(getResources().getDrawable(R.drawable.biblioteca_localizar16));
        else if (resultado == 17.0)
            image.setImageDrawable(getResources().getDrawable(R.drawable.biblioteca_localizar17));
        else if (resultado == 18.0)
            image.setImageDrawable(getResources().getDrawable(R.drawable.biblioteca_localizar18));
        else if (resultado == 19.0)
            image.setImageDrawable(getResources().getDrawable(R.drawable.biblioteca_localizar19));
        else if (resultado == 20.0)
            image.setImageDrawable(getResources().getDrawable(R.drawable.biblioteca_localizar20));
        else if (resultado == 21.0)
            image.setImageDrawable(getResources().getDrawable(R.drawable.biblioteca_localizar_r));
    }


    /**
     * Método que indentifica que tipo de código es y ejecuta el método correspondiente
     *
     * @param cadena código a identificar
     * @return ip del estante
     */

    public double localizar(String cadena) {
        try {
            if(cadena.length()>7)
                cadena=cadena.substring(0,7);
            double numero = Double.parseDouble(cadena);
            return localizarGeneral(numero);

        } catch (NumberFormatException nfe) {
            double medicina=localizarMedicina(cadena);
            if(medicina==-1.0)
                return localizarDiccionario(cadena);
            else
                return medicina;
        }
    }
    /**
     * Método que devuelve el estante al que pertenece el código corriespondiente a diccionarios
     *
     * @param cadena código a localizar
     * @return id del estante
     */
    public double localizarDiccionario(String cadena) {
        //Diccionarios
        Pattern patR = Pattern.compile("^(r|R).*");
        if (patR.matcher(cadena).matches()) {
            String numero=cadena.substring(1);
            try {
                double num = Double.parseDouble(numero);
                if(num>=0.0 && num<=950.0)
                    return 21.0;
                else
                    return -1.0;
            } catch (NumberFormatException nfe) {
                return -1.0;
            }
        }
        else
            return -1.0;
    }

    /**
     * Método que lozaliza un código numérico
     *
     * @param n código a localizar
     * @return id del estante
     */
    public double localizarGeneral(double n) {
        // id estante | lado A
        Double[][] estantes = {{1.0, 1.3, 5.19},
                {2.0, 5.2, 158.7},
                {3.0, 158.8, 306.4},
                {4.0, 306.5, 338.479},
                {5.0, 338.480, 354.7},
                {6.0, 354.8, 372.21},
                {7.0, 372.22, 428.1},
                {8.0, 428.2, 515.15},
                {9.0, 515.16, 531.0},
                {10.0, 531.0, 574.19},
                {11.0, 574.20, 613.69},
                {12.0, 613.7, 624.15},
                {13.0, 624.15, 657.0},
                {14.0, 657.1, 659.3},
                {15.0, 700.0, 799.260},
                {16.0, 660.0, 698.1},
                {17.0, 800., 899.0},
                {18.0, 900.0, 990.0},};
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
            return 19.0;
        } else if (patW.matcher(cadena).matches()) {
            return 20.0;
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