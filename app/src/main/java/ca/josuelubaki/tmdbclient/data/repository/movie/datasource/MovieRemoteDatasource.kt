package ca.josuelubaki.tmdbclient.data.repository.movie.datasource

import ca.josuelubaki.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDatasource {
    suspend fun getMovies(): Response<MovieList>
}