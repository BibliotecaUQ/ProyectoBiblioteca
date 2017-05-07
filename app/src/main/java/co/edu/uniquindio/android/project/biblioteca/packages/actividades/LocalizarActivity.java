package co.edu.uniquindio.android.project.biblioteca.packages.actividades;


import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
<<<<<<< HEAD
=======
import java.util.regex.Pattern;
>>>>>>> 1394898ee64cc413e978d41e6f1442fc1451269e

import co.edu.uniquindio.android.project.biblioteca.packagesAR.R;

/**
 /**
 * Actividad donde se define logica correspondiente a el caso de uso de localizar libro
 *
 * @author jhoan sebastian gomez medina
 * @author john sebastian agudelo ospina
 */

public class LocalizarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localizar);
        getSupportActionBar().setTitle(R.string.localizar_libro);
        back();
        ImageButton btn=( ImageButton) findViewById(R.id.button_Buscar);
        btn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              EditText search=(EditText) findViewById(R.id.search);



              InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
              inputMethodManager.hideSoftInputFromWindow(search.getWindowToken(), 0);
              String cadena =search.getText().toString();
              double resultado = localizar(cadena);
              if(resultado!=-1.0) {
                  double[] coordenadas=coordenadas(resultado);
                  ImageView im=(ImageView) findViewById(R.id.im);
                  im.setImageDrawable(getResources().getDrawable(R.drawable.ubicacion));
                  ViewGroup.MarginLayoutParams lp= (ViewGroup.MarginLayoutParams)im.getLayoutParams();
                  int y = getResources().getDrawable(R.drawable.biblioteca).getIntrinsicHeight();
                  int x = getResources().getDrawable(R.drawable.biblioteca).getIntrinsicWidth();
                  lp.leftMargin=(int)(y*coordenadas[0])+22;
                  lp.topMargin=(int)(x*coordenadas[1])-95;
                  im.setLayoutParams(lp);
              }
              else {
                  Log.v("resulltado", String.valueOf("Ingrese un código valido"));
              }
          }
        });
    }


    private static double[] coordenadas(double estante) {
        int x=(int)estante;
        // x | y
        double[][] porcentaje ={{0.202,0.846},
                {0.202,0.791},
                {0.202,0.735},
                {0.202,0.68},
                {0.202,0.62},
                {0.202,0.56},
                {0.202,0.506},
                {0.202,0.456},
                {0.202,0.396},
                {0.202,0.346},
                {0.202,0.291},
                {0.202,0.24},
                {0.202,0.185},
                {0.202,0.131},
                {0.89,0.30},
                {0.89,0.63}};
        double[] coordenadas={porcentaje[x-1][0],porcentaje[x-1][1]};
        return coordenadas;

<<<<<<< HEAD
              ImageView im=(ImageView) findViewById(R.id.im);
              im.setImageDrawable(getResources().getDrawable(R.drawable.ubicacion));
              ViewGroup.MarginLayoutParams lp= (ViewGroup.MarginLayoutParams)im.getLayoutParams();
              lp.leftMargin+=8;
              lp.topMargin+=8;
              im.setLayoutParams(lp);

          }
      });

=======
    }
>>>>>>> 1394898ee64cc413e978d41e6f1442fc1451269e


<<<<<<< HEAD
         Localizar tabla = new Localizar(this, (TableLayout)findViewById(R.id.tabla));
=======

    /**
     * Método que indentifica que tipo de código es y ejecuta el método correspondiente
     * @param cadena código a identificar
     * @return ip del estante
     */
    private static double localizar(String cadena) {
        try {
            double numero=Double.parseDouble(cadena);
            return localizarGeneral(numero);
        } catch (NumberFormatException nfe){
            return localizarMedicina(cadena);
        }
    }
>>>>>>> 1394898ee64cc413e978d41e6f1442fc1451269e


    /**
     * Método que lozaliza un código numérico
     * @param n código a localizar
     * @return id del estante
     */
    private static double localizarGeneral(double n) {
        // id estante | lado A
        Double[][] estantes={{1.0,1.0,5.276},
                {2.0,170.0,307.76},
                {3.0,307.76,339.0},
                {4.0,339.0,364.3},
                {5.0,364.36,396.0},
                {6.0,398.09861,511.8},
                {7.0,511.8,519.53},
                {8.0,519.53,546.0},
                {9.0,546.0,612.0},
                {10.0,621.381,628.1688},
                {11.0,628.1688,657.76},
                {12.0,657.76,664.0},
                {13.0,664.0,698.1},
                {14.0,800.0,900.0}};
        for (Double[] fila : estantes) {
            if(fila[1]<=n && fila[2]>=n){
                return fila[0];
            }
        }
        return -1.0;
    }

    /**
     * Método que devuelve el estante al que pertenece el código corriespondiente a medicina
     * @param cadena código a localizar
     * @return id del estante
     */
    private static double localizarMedicina(String cadena){
        Pattern patQ = Pattern.compile("^(q|Q)[A-Za-z]?[1-9]*");
        Pattern patW = Pattern.compile("^(w|W)[A-Za-z]?[1-9]*");
        if(patQ.matcher(cadena).matches()){
            return 15.0;
        }
        else if (patW.matcher(cadena).matches()){
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
     * @return boolean
     */
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }
}
