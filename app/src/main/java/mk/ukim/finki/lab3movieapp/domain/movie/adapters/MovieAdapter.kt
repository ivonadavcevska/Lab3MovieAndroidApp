package mk.ukim.finki.lab3movieapp.domain.movie.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import mk.ukim.finki.lab3movieapp.R
import mk.ukim.finki.lab3movieapp.domain.movie.Communicator
import mk.ukim.finki.lab3movieapp.domain.movie.model.MovieDetails

class MovieAdapter(private val movies:ArrayList<MovieDetails> = ArrayList<MovieDetails>(),
                   private val listener: Communicator
): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    inner class MovieViewHolder(view: View): RecyclerView.ViewHolder(view), View.OnClickListener {
        private var image: ImageView = view.findViewById(R.id.movie_image)
        private var titleText: TextView = view.findViewById(R.id.movie_title)
        private var yearMovie: TextView = view.findViewById(R.id.movie_year)

        init {
            itemView.setOnClickListener (this)
        }

        fun bind(movie: MovieDetails){
            Glide.with(image).load(movie.poster)
                .centerCrop().placeholder(R.drawable.ic_movie).into(image)

            titleText.text = movie.title

            yearMovie.text = movie.year
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            val imdbId = movies[position].imdbId
            listener.passData(position, imdbId)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_movie_items, parent, false)
        return MovieViewHolder(view)
    }


    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }

}