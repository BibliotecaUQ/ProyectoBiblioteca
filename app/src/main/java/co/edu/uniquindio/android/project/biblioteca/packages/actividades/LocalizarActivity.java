package co.edu.uniquindio.android.project.biblioteca.packages.actividades;


import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import co.edu.uniquindio.android.project.biblioteca.packagesAR.R;

/**
 * Created by sebastian on 5/05/17.
 */

public class LocalizarActivity extends AppCompatActivity {

    private EditText search;
    private ImageButton boton;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localizar);
        getSupportActionBar().setTitle(R.string.localizar_libro);
       back();


       boton=( ImageButton) findViewById(R.id.button_Buscar);
      boton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {

              search=(EditText) findViewById(R.id.search);
              InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
              inputMethodManager.hideSoftInputFromWindow(search.getWindowToken(), 0);



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
