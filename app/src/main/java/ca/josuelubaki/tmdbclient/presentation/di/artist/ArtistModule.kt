package ca.josuelubaki.tmdbclient.presentation.di.artist

import ca.josuelubaki.tmdbclient.domain.usecase.GetArtistsUseCase
import ca.josuelubaki.tmdbclient.domain.usecase.UpdateArtistsUseCase
import ca.josuelubaki.tmdbclient.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(
            getArtistsUseCase,
            updateArtistsUseCase
        )
    }
}