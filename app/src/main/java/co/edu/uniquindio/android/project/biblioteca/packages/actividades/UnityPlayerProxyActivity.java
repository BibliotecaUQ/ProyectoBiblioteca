package co.edu.uniquindio.android.project.biblioteca.packages.actividades;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Actividad perteneciente a la parte de Realidad aumentada
 *
 * @author jhoan sebastian gomez medina
 * @author john sebastian agudelo ospina
 */

//@deprecated Use UnityPlayerActivity instead.
public class UnityPlayerProxyActivity extends Activity {
    /**
     * metodo oncreate
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.w("Unity", "UnityPlayerNativeActivity has been deprecated, please update your AndroidManifest to use UnityPlayerActivity instead");
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, UnityPlayerActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        Bundle extras = getIntent().getExtras();
        if (extras != null)
            intent.putExtras(extras);
        startActivity(intent);
    }
}
