package org.movies.android.testesodexo.ui.movies

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.marioguerra.sodexo.R
import com.marioguerra.sodexo.repository.models.ResponseMovies


class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    var movies: List<ResponseMovies> = arrayListOf()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        holder.nameText.text = movie.nomeFilme
        holder.titleText.text = movie.ano

       // Glide.with(holder.itemView.context)
       //         .load(Movie.avatar)
        //        .apply(RequestOptions.circleCropTransform())
        //        .into(holder.avatarImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
                .inflate(R.layout.item_movie, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
       // var avatarImage: ImageView
        var nameText: TextView
        var titleText: TextView

        init {
          //  avatarImage = view.findViewById(R.id.image_avatar)
            nameText = view.findViewById(R.id.text_name)
            titleText = view.findViewById(R.id.text_title)
        }
    }

}