package co.edu.uniquindio.android.project.biblioteca.packages.actividades;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import static co.edu.uniquindio.android.project.biblioteca.packagesAR.R.drawable;

/**
 * Actividad perteneciente al codigo generado por el proceo realizado en Unity
 *
 * @author jonh sebastian agudelo ospina
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
            sampleButton.setImageResource(drawable.arrow_left);
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
