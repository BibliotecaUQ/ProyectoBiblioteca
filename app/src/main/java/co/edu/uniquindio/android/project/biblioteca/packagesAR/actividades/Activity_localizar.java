package co.edu.uniquindio.android.project.biblioteca.packagesAR.actividades;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.Toast;

import java.util.ArrayList;

import co.edu.uniquindio.android.project.biblioteca.packagesAR.R;

import static co.edu.uniquindio.android.project.biblioteca.packagesAR.R.drawable.ubicacion;

/**
 * Created by sebastian on 5/05/17.
 */

public class Activity_localizar extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localizar);



        Button boto=(Button) findViewById(R.id.button_Buscar);
      boto.setOnClickListener(new View.OnClickListener() {
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


        localizar tabla = new localizar(this, (TableLayout)findViewById(R.id.tabla));

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



}
