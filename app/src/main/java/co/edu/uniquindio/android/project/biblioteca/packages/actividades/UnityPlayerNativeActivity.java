package co.edu.uniquindio.android.project.biblioteca.packages.actividades;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.IOException;
import java.io.InterruptedIOException;

import co.edu.uniquindio.android.project.biblioteca.packagesAR.R;

import static co.edu.uniquindio.android.project.biblioteca.packagesAR.R.*;

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
        super.onCreate(savedInstanceState);
            // Add a Button over the Unity view
            ImageButton sampleButton = new ImageButton(UnityPlayerNativeActivity.this);
            sampleButton.getBackground().setAlpha(0);
            sampleButton.setBackgroundResource(0);
            sampleButton.setImageResource(drawable.abc_ic_ab_back_mtrl_am_alpha);
            sampleButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onDestroy();

                }
            });
            mUnityPlayer.addView(sampleButton, new ViewGroup.LayoutParams( ViewGroup.LayoutParams.WRAP_CONTENT,  ViewGroup.LayoutParams.WRAP_CONTENT));
            sampleButton.bringToFront();

    }
}
