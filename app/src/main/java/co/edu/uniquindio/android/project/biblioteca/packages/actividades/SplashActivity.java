package co.edu.uniquindio.android.project.biblioteca.packages.actividades;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import co.edu.uniquindio.android.project.biblioteca.packagesAR.R;

/**
 * Actividad donde se define el splash inicial
 *
 * @author jonh sebastian agudelo ospina
 */
public class SplashActivity extends Activity {
    private final int DURACION_SPLASH = 500;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable(){
            public void run(){
                Intent intent = new Intent(SplashActivity.this, NavegationActivity.class);
                startActivity(intent);
                finish();
            };
        }, DURACION_SPLASH);
    }
}