package co.edu.uniquindio.android.project.biblioteca.actividades.actividades;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.test.AndroidTestRunner;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import co.edu.uniquindio.android.project.biblioteca.packages.actividades.NavegationActivity;

import static android.content.Context.*;


/**
 * Created by Pc on 14/04/2017.
 */


@RunWith(JUnit4.class)
public class NavegationActivityTest extends TestCase {


    @Test
    public void ProbarConexionURLJSon() throws Exception {
        String urljson = "https://bibliotecauq.github.io/data.json";

        try {
            URL temp = null;
            Boolean t = true;
            // https://bibliotecauq.github.io/data.json
            URL url = new URL(urljson);
            URLConnection urlConnection = (HttpURLConnection) url.openConnection();
            temp = urlConnection.getURL();
            assertTrue(url.equals(temp));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }






}