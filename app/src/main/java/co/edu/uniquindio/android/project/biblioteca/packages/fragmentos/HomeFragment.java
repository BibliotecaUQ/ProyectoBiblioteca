package co.edu.uniquindio.android.project.biblioteca.packages.fragmentos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.edu.uniquindio.android.project.biblioteca.packagesAR.R;

/**
 * clase que contiene el fragmento para una de los opciones del menu de navegacion en este caso la opcion home
 * <p>
 * A simple {@link Fragment} subclass.
 *
 * @author jhoan sebastian gomez medina
 * @author john sebastian agudelo ospina
 */
public class HomeFragment extends Fragment {

    /**
     * este metodo realiza una nueva instancia del fragmento home
     * y la retorna.
     *
     * @return la nueva instancia del fragmento
     */
    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    /**
     * Metodo on create del fragmento home
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    /**
     * En el metodo onCreate view, se crea la vista del fragmento.
     * se retorna el layout inflado para la vista.
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return fragmento en elcontenedor
     */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_home, container, false);
        return vista;
    }

}
