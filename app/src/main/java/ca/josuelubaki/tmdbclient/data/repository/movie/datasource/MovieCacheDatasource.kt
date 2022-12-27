package ca.josuelubaki.tmdbclient.data.repository.movie.datasource

import ca.josuelubaki.tmdbclient.data.model.movie.Movie

interface MovieCacheDatasource {
    suspend fun getMoviesFromCache(): List<Movie>
    suspend fun saveMoviesToCache(movies: List<Movie>)
}