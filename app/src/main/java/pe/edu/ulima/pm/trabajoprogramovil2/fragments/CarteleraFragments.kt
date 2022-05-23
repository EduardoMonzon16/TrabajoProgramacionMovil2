package pe.edu.ulima.pm.trabajoprogramovil2.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import android.view.animation.Animation
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import pe.edu.ulima.pm.trabajoprogramovil2.R
import pe.edu.ulima.pm.trabajoprogramovil2.adapter.ListadoPeliculasAdapter
import pe.edu.ulima.pm.trabajoprogramovil2.fragments.models.GestorPeliculas
import pe.edu.ulima.pm.trabajoprogramovil2.fragments.models.beans.Pelicula


class CarteleraFragments : Fragment() {
    private lateinit var mRviPeliculas : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.title = "Hola 'Nombre de Usuario'"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.cartelera_fragments, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mRviPeliculas = view.findViewById(R.id.tviPeliculas)

        val listaPeliculas : List<Pelicula> = GestorPeliculas().obtenerPeliculas()
        val adapter = ListadoPeliculasAdapter(listaPeliculas) {
            Log.i("PeliculasFragment","Se hizo click en el pelicula" + it.nombre)
        }
        mRviPeliculas.adapter = adapter

    }

}