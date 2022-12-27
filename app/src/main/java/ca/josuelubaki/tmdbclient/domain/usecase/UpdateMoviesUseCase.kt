package ca.josuelubaki.tmdbclient.domain.usecase

import ca.josuelubaki.tmdbclient.data.model.movie.Movie
import ca.josuelubaki.tmdbclient.domain.repository.MovieRepository

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute(): List<Movie>? = movieRepository.updateMovies()
}