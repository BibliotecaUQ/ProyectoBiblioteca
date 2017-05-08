package co.edu.uniquindio.android.project.biblioteca.actividades.actividades;

import android.util.JsonReader;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import co.edu.uniquindio.android.project.biblioteca.packages.vo.JSONReader;

/**
 * Clase Junit
 */

@RunWith(JUnit4.class)
public class NavegationActivityTest extends TestCase {

    /**
     * probarConexionURLJSon
     *
     * @throws Exception
     */
    @Test
    public void probarConexionURLJSon() throws Exception {
        String urljson = "https://bibliotecauq.github.io/data.json";
        try {
            URL temp = null;
            URL url = new URL(urljson);
            URLConnection urlConnection = (HttpURLConnection) url.openConnection();
            temp = urlConnection.getURL();
            assertTrue(url.equals(temp));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * probarJSon
     *
     * @throws Exception
     */
    @Test
    public void probarJSon() throws Exception {

        HttpURLConnection urlConnection;
        JsonReader reader;
        try {
            // https://bibliotecauq.github.io/data.json
            String urljson = "https://bibliotecauq.github.io/data.json";
            URL url = new URL(urljson);
            urlConnection = (HttpURLConnection) url.openConnection();
            //temp = urlConnection.getResponseMessage();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
            JSONReader cJSONReader = new JSONReader();
            assertTrue(cJSONReader.readJSONMsg(reader) != null);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}