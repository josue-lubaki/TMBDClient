package ca.josuelubaki.tmdbclient.presentation.artist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import ca.josuelubaki.tmdbclient.BuildConfig
import ca.josuelubaki.tmdbclient.R
import ca.josuelubaki.tmdbclient.data.model.artist.Artist
import ca.josuelubaki.tmdbclient.databinding.ListItemBinding
import com.bumptech.glide.Glide

class ArtistAdapter : RecyclerView.Adapter<ArtistViewHolder>() {

    private val artistsList = ArrayList<Artist>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )
        return ArtistViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        holder.bind(artistsList[position])
    }

    override fun getItemCount(): Int {
        return artistsList.size
    }

    fun setList(artists: List<Artist>) {
        artistsList.clear()
        artistsList.addAll(artists)
    }

}

class ArtistViewHolder(private val binding : ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(artist: Artist) {
        binding.titleTextView.text = artist.name
        binding.descriptionTextView.text = buildString { append("Popularity : ${artist.popularity}") }
        val posterURL = BuildConfig.IMAGE_URL + artist.profilePath

        Glide.with(binding.imageView.context)
            .load(posterURL)
            .placeholder(R.drawable.image)
            .error(R.drawable.image)
            .into(binding.imageView)
    }
}