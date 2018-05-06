package co.edu.uniquindio.android.project.biblioteca.actividades.actividades;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import co.edu.uniquindio.android.project.biblioteca.packages.actividades.LocalizarActivity;

/**
 * Clase Prueba de la actividad Localizar
 */

@RunWith(JUnit4.class)
public class LocalizarActivityTest extends TestCase {

    /**
     * probarLocalizar
     *
     * @throws Exception
     */
    @Test
    public void probarLocalizar() throws Exception {
        LocalizarActivity localizarActivity = new LocalizarActivity();
        assertEquals(localizarActivity.localizar("5"), 1.0);
    }

    /**
     * probarLocalizar2
     *
     * @throws Exception
     */
    @Test
    public void probarLocalizar2() throws Exception {
        LocalizarActivity localizarActivity = new LocalizarActivity();
        assertEquals(localizarActivity.localizar("qW"), 19.0);
    }


    /**
     * probagGeneral
     *
     * @throws Exception
     */
    @Test
    public void probarGeneral() throws Exception {
        LocalizarActivity localizarActivity = new LocalizarActivity();
        assertEquals(localizarActivity.localizarGeneral(5), 1.0);
    }

    /**
     * probagMedicina
     *
     * @throws Exception
     */
    @Test
    public void probarMedicina() throws Exception {
        LocalizarActivity localizarActivity = new LocalizarActivity();
        assertEquals(localizarActivity.localizarMedicina("wq300.45"), 20.0);
    }

    /**
     * probagMedicina2
     *
     * @throws Exception
     */
    @Test
    public void probarMedicina2() throws Exception {
        LocalizarActivity localizarActivity = new LocalizarActivity();
        assertEquals(localizarActivity.localizarMedicina("q34.345"), 19.0);
    }

    /**
     * probagDiccionarios
     *
     * @throws Exception
     */
    @Test
    public void probarDiccionarios() throws Exception {
        LocalizarActivity localizarActivity = new LocalizarActivity();
        assertEquals(localizarActivity.localizarDiccionario("r-554.34"), 21.0);
    }
}
