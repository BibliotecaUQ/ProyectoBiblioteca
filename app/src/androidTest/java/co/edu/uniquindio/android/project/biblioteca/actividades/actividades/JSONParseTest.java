package co.edu.uniquindio.android.project.biblioteca.actividades.actividades;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.test.runner.AndroidJUnit4;
import android.util.JsonReader;
import android.widget.ImageView;
import android.widget.TextView;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import co.edu.uniquindio.android.project.biblioteca.packagesAR.R;
import co.edu.uniquindio.android.project.biblioteca.actividades.vo.JSONReaderTest;

/**
 * Created by Pc on 14/04/2017.
 */
@RunWith(AndroidJUnit4.class)
public class JSONParseTest extends AsyncTask<String, String, JsonReader> {

    private static String urljson = "https://bibliotecauq.github.io/data.json";
    //TextView
    private TextView mens;
    private TextView desc;
    //ImageView
    private ImageView img;

    //Listado contenido del Json
    private List list_contenido_json;
    //Variable Bitmap que contendra la imagen del Json
    private Bitmap imagen;
    private Bitmap imagen2;
    private TextView nom_ev;
    private TextView desc_ev;
    private ImageView img_ev;


    @Test
    public void onPreExecute()  {
        super.onPreExecute();
        mens = (TextView) mens.findViewById(R.id.nombre_Evento);
        desc = (TextView) desc.findViewById(R.id.descripcion_evento);
        img = (ImageView) img.findViewById(R.id.image_evento);

        nom_ev = (TextView) nom_ev.findViewById(R.id.nombre_Ev);
        desc_ev = (TextView) desc_ev.findViewById(R.id.descripcion_ev);
        img_ev = (ImageView) img_ev.findViewById(R.id.image_ev);
    }

    @Override
    protected JsonReader doInBackground(String... strings) {
        //JSON reader
        JsonReader reader=null;

       HttpURLConnection urlConnection = null;
        try {

            // https://bibliotecauq.github.io/data.json
            URL url = new URL(urljson);
            urlConnection = (HttpURLConnection) url.openConnection();
            //temp = urlConnection.getResponseMessage();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
            JSONReaderTest cJSONReader = new JSONReaderTest();

            try {

                list_contenido_json = cJSONReader.readJSONMsg(reader);

            } catch (IOException e) {
                e.printStackTrace();
            }
            imagen = getImagenJson("" + list_contenido_json.get(2));
            imagen2 = getImagenJson("" + list_contenido_json.get(5));

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null){
                urlConnection.disconnect();
            }
            return reader;
        }



    }





    @Test
    public void onPostExecute() throws Exception {
        mens.setText("" + list_contenido_json.get(0));
        desc.setText("" + list_contenido_json.get(1));
        img.setImageBitmap(imagen);

        nom_ev.setText("" + list_contenido_json.get(3));
        desc_ev.setText("" + list_contenido_json.get(4));
        img_ev.setImageBitmap(imagen2);
    }

    private Bitmap getImagenJson(String url) {
        Bitmap bm = null;
        try {
            URL _url = new URL(url);
            URLConnection con = _url.openConnection();
            con.connect();
            InputStream is = con.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            bm = BitmapFactory.decodeStream(bis);
            bis.close();
            is.close();
        } catch (IOException e) {
            e.toString();
            e.printStackTrace();
        }
        return bm;
    }

}