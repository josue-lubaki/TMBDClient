package ca.josuelubaki.tmdbclient.presentation.di.core

import ca.josuelubaki.tmdbclient.data.repository.artist.datasource.ArtistCacheDatasource
import ca.josuelubaki.tmdbclient.data.repository.artist.datasourceImpl.ArtistCacheDatasourceImpl
import ca.josuelubaki.tmdbclient.data.repository.movie.datasource.MovieCacheDatasource
import ca.josuelubaki.tmdbclient.data.repository.movie.datasourceImpl.MovieCacheDatasourceImpl
import ca.josuelubaki.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDatasource
import ca.josuelubaki.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowCacheDatasourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDatasource() : MovieCacheDatasource {
        return MovieCacheDatasourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDatasource() : ArtistCacheDatasource {
        return ArtistCacheDatasourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDatasource() : TvShowCacheDatasource {
        return TvShowCacheDatasourceImpl()
    }

}