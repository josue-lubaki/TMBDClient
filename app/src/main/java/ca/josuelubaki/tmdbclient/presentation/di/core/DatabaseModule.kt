package ca.josuelubaki.tmdbclient.presentation.di.core

import android.content.Context
import androidx.room.Room
import ca.josuelubaki.tmdbclient.data.db.ArtistDao
import ca.josuelubaki.tmdbclient.data.db.MovieDao
import ca.josuelubaki.tmdbclient.data.db.TMDBDatabase
import ca.josuelubaki.tmdbclient.data.db.TvShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(context : Context) : TMDBDatabase {
        return Room.databaseBuilder(
            context,
            TMDBDatabase::class.java,
            TMDBDatabase.DATABASE_NAME
        ).build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase) : MovieDao = tmdbDatabase.movieDao()

    @Singleton
    @Provides
    fun provideArtistDao(tmdbDatabase: TMDBDatabase) : ArtistDao = tmdbDatabase.artistDao()

    @Singleton
    @Provides
    fun provideTvShowDao(tmdbDatabase: TMDBDatabase) : TvShowDao = tmdbDatabase.tvShowDao()

}