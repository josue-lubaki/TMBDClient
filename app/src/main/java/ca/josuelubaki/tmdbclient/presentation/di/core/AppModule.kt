package ca.josuelubaki.tmdbclient.presentation.di.core

import android.content.Context
import ca.josuelubaki.tmdbclient.presentation.di.artist.ArtistSubComponent
import ca.josuelubaki.tmdbclient.presentation.di.movie.MovieSubComponent
import ca.josuelubaki.tmdbclient.presentation.di.tvshow.TvShowSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [
    ArtistSubComponent::class,
    MovieSubComponent::class,
    TvShowSubComponent::class
])
class AppModule(private val context : Context) {

    @Singleton
    @Provides
    fun provideApplicationContext() : Context {
        return context.applicationContext
    }

}