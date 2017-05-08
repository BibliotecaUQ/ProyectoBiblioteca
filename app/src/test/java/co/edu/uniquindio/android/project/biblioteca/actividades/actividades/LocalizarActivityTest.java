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
        assertEquals(localizarActivity.localizar("qW"), 15.0);
    }

    /**
     * probarCoordenadas
     *
     * @throws Exception
     */
    @Test
    public void probarCoordenadas() throws Exception {
        LocalizarActivity localizarActivity = new LocalizarActivity();
        double[] verdadero = {0.207, 0.86};
        double[] resultado = localizarActivity.coordenadas(1.0);
        assertEquals(verdadero[0], resultado[0]);
        assertEquals(verdadero[1], resultado[1]);
    }

    /**
     * probagGeneral
     *
     * @throws Exception
     */
    @Test
    public void probagGeneral() throws Exception {
        LocalizarActivity localizarActivity = new LocalizarActivity();
        assertEquals(localizarActivity.localizarGeneral(5), 1.0);
    }

    /**
     * probagMedicina
     *
     * @throws Exception
     */
    @Test
    public void probagMedicina() throws Exception {
        LocalizarActivity localizarActivity = new LocalizarActivity();
        assertEquals(localizarActivity.localizarMedicina("wq"), 16.0);
    }

    /**
     * probagMedicina2
     *
     * @throws Exception
     */
    @Test
    public void probagMedicina2() throws Exception {
        LocalizarActivity localizarActivity = new LocalizarActivity();
        assertEquals(localizarActivity.localizarMedicina("q"), 15.0);
    }
}
