package ca.josuelubaki.tmdbclient.data.repository.movie.datasourceImpl

import ca.josuelubaki.tmdbclient.data.model.movie.Movie
import ca.josuelubaki.tmdbclient.data.repository.movie.datasource.MovieCacheDatasource

class MovieCacheDatasourceImpl : MovieCacheDatasource {
    private val movieList = ArrayList<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList.addAll(movies)
    }
}