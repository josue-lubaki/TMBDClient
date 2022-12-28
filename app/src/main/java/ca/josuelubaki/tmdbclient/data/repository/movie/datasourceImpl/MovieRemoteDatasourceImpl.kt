package ca.josuelubaki.tmdbclient.data.repository.movie.datasourceImpl

import ca.josuelubaki.tmdbclient.data.api.TMDBService
import ca.josuelubaki.tmdbclient.data.model.movie.MovieList
import ca.josuelubaki.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import retrofit2.Response

class MovieRemoteDatasourceImpl(
    private val TMDBService: TMDBService,
    private val apiKey: String
    ) : MovieRemoteDatasource {
    override suspend fun getMovies(): Response<MovieList> = TMDBService.getPopularMovies(apiKey)
}