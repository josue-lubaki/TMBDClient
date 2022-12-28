package ca.josuelubaki.tmdbclient.presentation.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import ca.josuelubaki.tmdbclient.BuildConfig
import ca.josuelubaki.tmdbclient.R
import ca.josuelubaki.tmdbclient.data.model.movie.Movie
import ca.josuelubaki.tmdbclient.databinding.ListItemBinding
import com.bumptech.glide.Glide

class MovieAdapter : RecyclerView.Adapter<MovieViewHolder>() {

    private val moviesList = ArrayList<Movie>()

    fun setList(movies: List<Movie>) {
        moviesList.clear()
        moviesList.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(moviesList[position])
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }
}

class MovieViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: Movie) {
        binding.titleTextView.text = movie.title
        binding.descriptionTextView.text = movie.overview
        val posterURL = BuildConfig.IMAGE_URL + movie.posterPath

        Glide.with(binding.imageView.context)
            .load(posterURL)
            .into(binding.imageView)
    }
}