package ca.josuelubaki.tmdbclient.presentation.di

import ca.josuelubaki.tmdbclient.presentation.di.artist.ArtistSubComponent
import ca.josuelubaki.tmdbclient.presentation.di.movie.MovieSubComponent
import ca.josuelubaki.tmdbclient.presentation.di.tvshow.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
}