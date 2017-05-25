package co.edu.uniquindio.android.project.biblioteca.packages.actividades;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import co.edu.uniquindio.android.project.biblioteca.packagesAR.BuildConfig;

import static co.edu.uniquindio.android.project.biblioteca.packagesAR.R.drawable;

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
                    if (getFirstTimeRun()==1)Toast.makeText(getApplicationContext(),"ya estaba"+getFirstTimeRun(), Toast.LENGTH_SHORT).show();


                }
            });
            mUnityPlayer.addView(sampleButton, new ViewGroup.LayoutParams( ViewGroup.LayoutParams.WRAP_CONTENT,  ViewGroup.LayoutParams.WRAP_CONTENT));
            sampleButton.bringToFront();

    }


    private int getFirstTimeRun() {
        SharedPreferences sp = getSharedPreferences("MYAPP", 0);
        int result, currentVersionCode = BuildConfig.VERSION_CODE;
        int lastVersionCode = sp.getInt("FIRSTTIMERUN", -1);
        if (lastVersionCode == -1) result = 0; else
            result = (lastVersionCode == currentVersionCode) ? 1 : 2;
        sp.edit().putInt("FIRSTTIMERUN", currentVersionCode).apply();
        return result;
    }
}
