package pe.edu.ulima.pm.trabajoprogramovil2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pe.edu.ulima.pm.trabajoprogramovil2.R
import pe.edu.ulima.pm.trabajoprogramovil2.fragments.models.beans.Pelicula

class ListadoPeliculasAdapter(private val mListaPeliculas : List<Pelicula>,
    private val mOnItemClickListener: (pelicula : Pelicula) -> Unit)
    : RecyclerView.Adapter<ListadoPeliculasAdapter.ViewHolder>(){
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val tviPeliculaNombre : TextView
        val tviPeliculaHora : TextView
        val tviEstrella: ImageView

        init {
            tviPeliculaNombre = view.findViewById(R.id.tviPeliculaNombre)
            tviPeliculaHora = view.findViewById(R.id.tviPeliculaHora)
            tviEstrella = view.findViewById(R.id.tviEstrella)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pelicula, parent, false)
        val viewHolder = ViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pelicula = mListaPeliculas[position]
        holder.tviPeliculaNombre.text = pelicula.nombre
        holder.tviPeliculaHora.text = pelicula.hora

        holder.itemView.setOnClickListener{
            mOnItemClickListener(pelicula)
        }
    }

    override fun getItemCount(): Int {
        return mListaPeliculas.size
    }

}