package ca.josuelubaki.tmdbclient.presentation.artist

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import ca.josuelubaki.tmdbclient.R
import ca.josuelubaki.tmdbclient.databinding.ActivityArtistBinding
import ca.josuelubaki.tmdbclient.presentation.di.Injector
import javax.inject.Inject

class ArtistActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ArtistViewModelFactory

    private lateinit var artistViewModel: ArtistViewModel

    private lateinit var artistAdapter: ArtistAdapter

    private lateinit var binding: ActivityArtistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artist)
        (application as Injector).createArtistSubComponent().inject(this)

        // change title of the action bar
        supportActionBar?.title = "Artists"

        configuration()
        displayPopularArtists()
    }

    private fun configuration() {
        // init view model
        artistViewModel = ViewModelProvider(this, factory)[ArtistViewModel::class.java]

        // init recycler view & adapter
        binding.artistRecyclerView.layoutManager = LinearLayoutManager(this)
        artistAdapter = ArtistAdapter()
        binding.artistRecyclerView.adapter = artistAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_update -> {
                updateArtists()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    @SuppressWarnings("notifyDataSetChanged")
    private fun displayPopularArtists(){
        binding.artistProgressBar.visibility = View.VISIBLE
        val responseLiveData = artistViewModel.getArtists()
        responseLiveData.observe(this){
            if(it != null){
                artistAdapter.setList(it)
                artistAdapter.notifyDataSetChanged()
                binding.artistProgressBar.visibility = View.GONE
            } else {
                binding.artistProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "No data available", Toast.LENGTH_LONG).show()
            }
        }
    }

    @SuppressWarnings("notifyDataSetChanged")
    private fun updateArtists() {
        binding.artistProgressBar.visibility = View.VISIBLE
        val responseLiveData = artistViewModel.updateArtists()
        responseLiveData.observe(this){
            if(it != null){
                artistAdapter.setList(it)
                artistAdapter.notifyDataSetChanged()
                binding.artistProgressBar.visibility = View.GONE
            } else {
                binding.artistProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "No data available", Toast.LENGTH_LONG).show()
            }
        }
    }
}