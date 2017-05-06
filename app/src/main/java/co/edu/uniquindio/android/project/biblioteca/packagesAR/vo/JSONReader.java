package co.edu.uniquindio.android.project.biblioteca.packagesAR.vo;


import android.util.JsonReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created  on 07/04/2017.
 *
 * Esta clase se encarga de realizar el procdimiento adecado en cuanto a la lectura y
 * obtención de los elementos que se encuatran en el formato Json
 *
 * @author jhoan sebastian gomez medina
 * @author john sebastian agudelo ospina
 */

public class JSONReader {
    public String Event = "";
    public String Event2 = "";
    public String Descrip = "";
    public String Descrip2 = "";
    public String img = "";
    public String img2 = "";

    /**
     * Método Constructor d la clase
     */
    public JSONReader() {
    }

    //Método que lee apartado a apartado dentro del JSON
    public List readJSONMsg(JsonReader reader) throws IOException {
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
                        setEvent(Event);
                        Array_json.add(Event);
                    }

                    if (object.equals("Descripcion")) {
                        Descrip = reader.nextString();
                        Array_json.add(Descrip);
                    }

                    if (object.equals("image")) {
                        img = reader.nextString();
                        setImg(img);
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

    //metodo get
    public String getEvent() {
        return Event;
    }

    //metodo set
    public void setEvent(String event) {
        Event = event;
    }

    //metodo get
    public String getDescrip() {
        return Descrip;
    }

    //metodo set
    public void setDescrip(String descrip) {
        Descrip = descrip;
    }

    //metodo get
    public String getImg() {
        return img;
    }

    //metodo set
    public void setImg(String img) {
        this.img = img;
    }


}
