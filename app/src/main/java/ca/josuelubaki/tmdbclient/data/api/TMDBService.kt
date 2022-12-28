package ca.josuelubaki.tmdbclient.data.api

import ca.josuelubaki.tmdbclient.data.model.artist.ArtistList
import ca.josuelubaki.tmdbclient.data.model.movie.MovieList
import ca.josuelubaki.tmdbclient.data.model.tvshow.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey : String): Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTvShows(@Query("api_key") apiKey : String): Response<TvShowList>

    @GET("person/popular")
    suspend fun getPopularArtists(@Query("api_key") apiKey : String): Response<ArtistList>
}