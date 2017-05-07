package co.edu.uniquindio.android.project.biblioteca.actividades.actividades;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import co.edu.uniquindio.android.project.biblioteca.packages.actividades.LocalizarActivity;

/**
 * Created by Pc on 14/04/2017.
 */

@RunWith(JUnit4.class)
public class NavegationActivityTest extends TestCase {

    @Test
    public void probarConexionURLJSon() throws Exception {
        String urljson = "https://bibliotecauq.github.io/data.json";
        try {
            URL temp = null;
            // https://bibliotecauq.github.io/data.json
            URL url = new URL(urljson);
            URLConnection urlConnection = (HttpURLConnection) url.openConnection();
            temp = urlConnection.getURL();
            assertTrue(url.equals(temp));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void probarLocalizar() throws Exception {
        LocalizarActivity localizarActivity = new LocalizarActivity();
        assertEquals(localizarActivity.localizar("5"),1.0);
    }

    @Test
    public void probarLocalizar2() throws Exception {
        LocalizarActivity localizarActivity = new LocalizarActivity();
        assertEquals(localizarActivity.localizar("qW"),15.0);
    }

    @Test
    public void probarCoordenadas() throws Exception {
        LocalizarActivity localizarActivity = new LocalizarActivity();
        double[] verdadero ={0.207, 0.86};
        double[] resultado= localizarActivity.coordenadas(1.0);
        assertEquals(verdadero[0],resultado[0]);
        assertEquals(verdadero[1],resultado[1]);
    }

    @Test
    public void probagGeneral() throws Exception {
        LocalizarActivity localizarActivity = new LocalizarActivity();
        assertEquals(localizarActivity.localizarGeneral(5),1.0);
    }

    @Test
    public void probagMedicina() throws Exception {
        LocalizarActivity localizarActivity = new LocalizarActivity();
        assertEquals(localizarActivity.localizarMedicina("wq"),16.0);
    }

    @Test
    public void probagMedicina2() throws Exception {
        LocalizarActivity localizarActivity = new LocalizarActivity();
        assertEquals(localizarActivity.localizarMedicina("q"),15.0);
    }






}