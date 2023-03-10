package ca.josuelubaki.tmdbclient.presentation.tv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import ca.josuelubaki.tmdbclient.R
import ca.josuelubaki.tmdbclient.databinding.ActivityTvShowBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class TvShowActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: TvShowViewModelFactory

    private lateinit var binding: ActivityTvShowBinding

    private lateinit var tvShowAdapter: TvShowAdapter

    private lateinit var tvShowViewModel: TvShowViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_show)

        // change title of the action bar
        supportActionBar?.title = "Tv Show"

        configuration()
        displayPopularTvShows()
    }

    private fun configuration() {
        // init view model
        tvShowViewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]

        // init recycler view & adapter
        binding.tvShowRecyclerView.layoutManager = LinearLayoutManager(this)
        tvShowAdapter = TvShowAdapter()
        binding.tvShowRecyclerView.adapter = tvShowAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_update -> {
                updateTvShows()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    @SuppressWarnings("notifyDataSetChanged")
    private fun displayPopularTvShows() {
        binding.tvShowProgressBar.visibility = View.VISIBLE
        val responseLiveData = tvShowViewModel.getTvShows()
        responseLiveData.observe(this) {
            if (it != null) {
                tvShowAdapter.setList(it)
                tvShowAdapter.notifyDataSetChanged()
                binding.tvShowProgressBar.visibility = View.GONE
            }
            else {
                binding.tvShowProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "No data available", Toast.LENGTH_LONG).show()
            }
        }
    }

    @SuppressWarnings("notifyDataSetChanged")
    private fun updateTvShows() {
        binding.tvShowProgressBar.visibility = View.VISIBLE
        val responseLiveData = tvShowViewModel.updateTvShows()
        responseLiveData.observe(this) {
            if (it != null) {
                tvShowAdapter.setList(it)
                tvShowAdapter.notifyDataSetChanged()
                binding.tvShowProgressBar.visibility = View.GONE
            }
            else {
                binding.tvShowProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "No data available", Toast.LENGTH_LONG).show()
            }
        }
    }
}