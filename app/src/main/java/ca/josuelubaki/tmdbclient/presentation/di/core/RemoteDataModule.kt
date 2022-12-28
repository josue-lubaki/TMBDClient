package ca.josuelubaki.tmdbclient.presentation.di.core

import ca.josuelubaki.tmdbclient.data.api.TMDBService
import ca.josuelubaki.tmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import ca.josuelubaki.tmdbclient.data.repository.artist.datasourceImpl.ArtistRemoteDatasourceImpl
import ca.josuelubaki.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import ca.josuelubaki.tmdbclient.data.repository.movie.datasourceImpl.MovieRemoteDatasourceImpl
import ca.josuelubaki.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDatasource
import ca.josuelubaki.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowRemoteDatasourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

     @Singleton
     @Provides
     fun provideArtistRemoteDataSource(TMDBService: TMDBService): ArtistRemoteDatasource {
         return ArtistRemoteDatasourceImpl(TMDBService, apiKey)
     }

     @Singleton
     @Provides
     fun provideMovieRemoteDataSource(TMDBService: TMDBService): MovieRemoteDatasource {
         return MovieRemoteDatasourceImpl(TMDBService, apiKey)
     }

     @Singleton
     @Provides
     fun provideTvShowRemoteDataSource(TMDBService: TMDBService): TvShowRemoteDatasource {
         return TvShowRemoteDatasourceImpl(TMDBService, apiKey)
     }
}