package co.edu.uniquindio.android.electiva.biblioteca.test;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import org.junit.Test;


/**
 * Created by Pc on 14/04/2017.
 */
public class NavegationActivityTest extends Activity{


    @Test
    public void onCreate() throws Exception {

            verificaConexion();
    }
    /**
    @Test
    public void onOptionsItemSelected() throws Exception {
    }
    */
    @Test
    public static boolean verificaConexion() throws Exception {
        Context ctx=null;
        boolean bConectado = false;
        ConnectivityManager connec = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        // No solo wifi, tambien GPRS
        NetworkInfo[] redes = connec.getAllNetworkInfo();
        // este bucle no es tan grande
        for (int i = 0; i < 2; i++) {
            // Cuando se tiene conexion se pone a true
            if (redes[i].getState() == NetworkInfo.State.CONNECTED) {
                bConectado = true;
            }
        }
        return bConectado;
    }


}