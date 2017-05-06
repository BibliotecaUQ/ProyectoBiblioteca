package co.edu.uniquindio.android.electiva.practicanavegationdrawer.actividades.vo;

import android.util.JsonReader;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Pc on 14/04/2017.
 */
public class JSONReaderTest {

    public String Event = "";
    public String Event2 = "";
    public String Descrip = "";
    public String Descrip2 = "";
    public String img = "";
    public String img2 = "";
    @Test
    public List readJSONMsg(JsonReader reader) throws Exception {
        //Lista de camaras
        List Array_json = new ArrayList();
        reader.beginObject();

        while (reader.hasNext()) {

            String name = reader.nextName();
            if (name.equals("Proyecto")) {
                //Estamos en el array de

                reader.beginArray();
                reader.beginObject();
                while (reader.hasNext()) {
                    String object = reader.nextName();
                    if (object.equals("Evento")) {
                        Event = reader.nextString();

                        Array_json.add(Event);
                    }

                    if (object.equals("Descripcion")) {
                        Descrip = reader.nextString();
                        Array_json.add(Descrip);
                    }

                    if (object.equals("image")) {
                        img = reader.nextString();

                        Array_json.add(img);
                    }
                    if (object.equals("Evento2")) {
                        Event2 = reader.nextString();
                        Array_json.add(Event2);
                    }
                    if (object.equals("Descripcion2")) {
                        Descrip2 = reader.nextString();
                        Array_json.add(Descrip2);

                    }

                    if (object.equals("image2")) {
                        img2 = reader.nextString();
                        Array_json.add(img2);
                    }
                }
                reader.endObject();
                reader.endArray();
            } else {
                reader.skipValue();
            }
        }

        reader.endObject();
        return Array_json;
    }

}