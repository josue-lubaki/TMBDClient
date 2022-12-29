package ca.josuelubaki.tmdbclient.presentation.di.core

import ca.josuelubaki.tmdbclient.data.db.ArtistDao
import ca.josuelubaki.tmdbclient.data.db.MovieDao
import ca.josuelubaki.tmdbclient.data.db.TvShowDao
import ca.josuelubaki.tmdbclient.data.repository.artist.datasource.ArtistLocalDatasource
import ca.josuelubaki.tmdbclient.data.repository.artist.datasourceImpl.ArtistLocalDatasourceImpl
import ca.josuelubaki.tmdbclient.data.repository.movie.datasource.MovieLocalDatasource
import ca.josuelubaki.tmdbclient.data.repository.movie.datasourceImpl.MovieLocalDatasourceImpl
import ca.josuelubaki.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDatasource
import ca.josuelubaki.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowLocalDatasourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDatasource(movieDao: MovieDao) : MovieLocalDatasource {
        return MovieLocalDatasourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDatasource(artistDao: ArtistDao) : ArtistLocalDatasource {
        return ArtistLocalDatasourceImpl(artistDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDatasource(tvShowDao: TvShowDao) : TvShowLocalDatasource {
        return TvShowLocalDatasourceImpl(tvShowDao)
    }
}