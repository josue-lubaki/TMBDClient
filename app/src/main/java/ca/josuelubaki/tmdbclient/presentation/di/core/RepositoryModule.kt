package ca.josuelubaki.tmdbclient.presentation.di.core

import ca.josuelubaki.tmdbclient.data.repository.artist.ArtistRepositoryImpl
import ca.josuelubaki.tmdbclient.data.repository.artist.datasource.ArtistCacheDatasource
import ca.josuelubaki.tmdbclient.data.repository.artist.datasource.ArtistLocalDatasource
import ca.josuelubaki.tmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import ca.josuelubaki.tmdbclient.data.repository.movie.MovieRepositoryImpl
import ca.josuelubaki.tmdbclient.data.repository.movie.datasource.MovieCacheDatasource
import ca.josuelubaki.tmdbclient.data.repository.movie.datasource.MovieLocalDatasource
import ca.josuelubaki.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import ca.josuelubaki.tmdbclient.data.repository.tvshow.TvShowRepositoryImpl
import ca.josuelubaki.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDatasource
import ca.josuelubaki.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDatasource
import ca.josuelubaki.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDatasource
import ca.josuelubaki.tmdbclient.domain.repository.ArtistRepository
import ca.josuelubaki.tmdbclient.domain.repository.MovieRepository
import ca.josuelubaki.tmdbclient.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDatasource: MovieRemoteDatasource,
        movieLocalDatasource: MovieLocalDatasource,
        movieCacheDatasource: MovieCacheDatasource
    ) : MovieRepository {
        return MovieRepositoryImpl(
            movieRemoteDatasource,
            movieLocalDatasource,
            movieCacheDatasource
        )
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDatasource: ArtistRemoteDatasource,
        artistLocalDatasource: ArtistLocalDatasource,
        artistCacheDatasource: ArtistCacheDatasource
    ) : ArtistRepository {
        return ArtistRepositoryImpl(
            artistRemoteDatasource,
            artistLocalDatasource,
            artistCacheDatasource
        )
    }

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowRemoteDatasource: TvShowRemoteDatasource,
        tvShowLocalDatasource: TvShowLocalDatasource,
        tvShowCacheDatasource: TvShowCacheDatasource
    ) : TvShowRepository {
        return TvShowRepositoryImpl(
            tvShowRemoteDatasource,
            tvShowLocalDatasource,
            tvShowCacheDatasource
        )
    }
}