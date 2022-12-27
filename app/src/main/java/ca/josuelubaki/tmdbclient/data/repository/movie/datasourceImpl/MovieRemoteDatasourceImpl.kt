package ca.josuelubaki.tmdbclient.data.repository.movie.datasourceImpl

import ca.josuelubaki.tmdbclient.data.api.TMBDService
import ca.josuelubaki.tmdbclient.data.model.movie.MovieList
import ca.josuelubaki.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import retrofit2.Response

class MovieRemoteDatasourceImpl(
    private val tmbdService: TMBDService,
    private val apiKey: String
    ) : MovieRemoteDatasource {
    override suspend fun getMovies(): Response<MovieList> = tmbdService.getPopularMovies(apiKey)
}