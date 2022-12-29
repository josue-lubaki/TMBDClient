package ca.josuelubaki.tmdbclient.presentation.tv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import ca.josuelubaki.tmdbclient.BuildConfig
import ca.josuelubaki.tmdbclient.R
import ca.josuelubaki.tmdbclient.data.model.tvshow.TvShow
import ca.josuelubaki.tmdbclient.databinding.ListItemBinding
import com.bumptech.glide.Glide

class TvShowAdapter : RecyclerView.Adapter<TvShowViewHolder>(){
    private val tvShowsList: MutableList<TvShow> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val binding : ListItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.list_item,
            parent,
            false
        )
        return TvShowViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.bind(tvShowsList[position])
    }

    override fun getItemCount(): Int {
        return tvShowsList.size
    }

    fun setList(tvShows: List<TvShow>){
        tvShowsList.clear()
        tvShowsList.addAll(tvShows)
    }
}

class TvShowViewHolder(private val binding : ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(tvShow: TvShow) {
        binding.titleTextView.text = tvShow.name
        binding.descriptionTextView.text = tvShow.overview
        val posterURL = BuildConfig.IMAGE_URL + tvShow.posterPath

        Glide.with(binding.imageView.context)
            .load(posterURL)
            .placeholder(R.drawable.image)
            .error(R.drawable.image)
            .into(binding.imageView)
    }
}