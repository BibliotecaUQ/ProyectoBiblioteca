package co.edu.uniquindio.android.project.biblioteca.packages.actividades;

import android.os.Bundle;
import android.util.Log;

/**
 * Actividad perteneciente al codigo generado por el proceo realizado en Unity
 *
 * @author jhoan sebastian gomez medina
 * @author john sebastian agudelo ospina
 **/
//@deprecated It's recommended that you base your code directly on UnityPlayerActivity or make your own NativeActitivty implementation.
public class UnityPlayerNativeActivity extends UnityPlayerActivity {
    /**
     * metodo oncreate
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.w("Unity", "UnityPlayerNativeActivity has been deprecated, please update your AndroidManifest to use UnityPlayerActivity instead");
        super.onCreate(savedInstanceState);
    }

    /**
     * Metodo que genera la acción atras
     */
    @Override
    public void onBackPressed() {  // Añade más funciones si fuese necesario
        super.onBackPressed();  // Invoca al método
    }

}
