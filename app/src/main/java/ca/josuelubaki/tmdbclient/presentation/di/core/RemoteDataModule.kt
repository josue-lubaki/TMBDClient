package ca.josuelubaki.tmdbclient.presentation.di.core

import ca.josuelubaki.tmdbclient.BuildConfig
import ca.josuelubaki.tmdbclient.data.api.TMDBService
import ca.josuelubaki.tmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import ca.josuelubaki.tmdbclient.data.repository.artist.datasourceImpl.ArtistRemoteDatasourceImpl
import ca.josuelubaki.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import ca.josuelubaki.tmdbclient.data.repository.movie.datasourceImpl.MovieRemoteDatasourceImpl
import ca.josuelubaki.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDatasource
import ca.josuelubaki.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowRemoteDatasourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule {

     @Singleton
     @Provides
     fun provideArtistRemoteDataSource(TMDBService: TMDBService): ArtistRemoteDatasource {
         return ArtistRemoteDatasourceImpl(TMDBService, BuildConfig.API_KEY)
     }

     @Singleton
     @Provides
     fun provideMovieRemoteDataSource(TMDBService: TMDBService): MovieRemoteDatasource {
         return MovieRemoteDatasourceImpl(TMDBService, BuildConfig.API_KEY)
     }

     @Singleton
     @Provides
     fun provideTvShowRemoteDataSource(TMDBService: TMDBService): TvShowRemoteDatasource {
         return TvShowRemoteDatasourceImpl(TMDBService, BuildConfig.API_KEY)
     }
}