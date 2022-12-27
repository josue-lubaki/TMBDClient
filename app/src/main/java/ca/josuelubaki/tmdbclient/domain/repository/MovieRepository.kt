package ca.josuelubaki.tmdbclient.domain.repository

import ca.josuelubaki.tmdbclient.data.model.movie.Movie

interface MovieRepository {
    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?
}