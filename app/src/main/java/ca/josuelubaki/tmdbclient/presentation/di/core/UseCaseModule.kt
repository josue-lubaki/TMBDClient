package ca.josuelubaki.tmdbclient.presentation.di.core

import ca.josuelubaki.tmdbclient.domain.repository.ArtistRepository
import ca.josuelubaki.tmdbclient.domain.repository.MovieRepository
import ca.josuelubaki.tmdbclient.domain.repository.TvShowRepository
import ca.josuelubaki.tmdbclient.domain.usecase.GetArtistsUseCase
import ca.josuelubaki.tmdbclient.domain.usecase.GetMoviesUseCase
import ca.josuelubaki.tmdbclient.domain.usecase.GetTvShowsUseCase
import ca.josuelubaki.tmdbclient.domain.usecase.UpdateArtistsUseCase
import ca.josuelubaki.tmdbclient.domain.usecase.UpdateMoviesUseCase
import ca.josuelubaki.tmdbclient.domain.usecase.UpdateTvShowsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    fun provideGetMoviesUseCase(movieRepository: MovieRepository) : GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideUpdateMoviesUseCase(movieRepository: MovieRepository) : UpdateMoviesUseCase {
        return UpdateMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideGetArtistsUseCase(artistRepository : ArtistRepository) : GetArtistsUseCase {
        return GetArtistsUseCase(artistRepository)
    }

    @Provides
    fun provideUpdateArtistsUseCase(artistRepository : ArtistRepository) : UpdateArtistsUseCase {
        return UpdateArtistsUseCase(artistRepository)
    }

    @Provides
    fun provideGetTvShowsUseCase(tvShowRepository : TvShowRepository) : GetTvShowsUseCase {
        return GetTvShowsUseCase(tvShowRepository)
    }

    @Provides
    fun provideUpdateTvShowsUseCase(tvShowRepository : TvShowRepository) : UpdateTvShowsUseCase {
        return UpdateTvShowsUseCase(tvShowRepository)
    }

}