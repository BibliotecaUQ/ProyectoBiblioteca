package co.edu.uniquindio.android.project.biblioteca.packages.actividades;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import co.edu.uniquindio.android.project.biblioteca.packagesAR.R;

/**
 * Created by sebastian on 5/05/17.
 */

public class LocalizarActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localizar);
        getSupportActionBar().setTitle(R.string.localizar_libro);
       back();


        Button boton=(Button) findViewById(R.id.button_Buscar);
      boton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              ImageView im=(ImageView) findViewById(R.id.im);
              im.setImageDrawable(getResources().getDrawable(R.drawable.ubicacion));
              ViewGroup.MarginLayoutParams lp= (ViewGroup.MarginLayoutParams)im.getLayoutParams();
              lp.leftMargin+=8;
              lp.topMargin+=8;
              im.setLayoutParams(lp);

          }
      });


        /**


         Localizar tabla = new Localizar(this, (TableLayout)findViewById(R.id.tabla));

        for(int i = 0; i < 15; i++)
        {
            ArrayList<String> elementos = new ArrayList<String>();
            for(int j= 0; j < 10; j++) {
                elementos.add(Integer.toString(j));

            }
            tabla.agregarFilaTabla(elementos);
        }
         */

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
