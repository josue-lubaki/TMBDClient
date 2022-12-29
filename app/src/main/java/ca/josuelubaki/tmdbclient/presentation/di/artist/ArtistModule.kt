package ca.josuelubaki.tmdbclient.presentation.di.artist

import ca.josuelubaki.tmdbclient.domain.usecase.GetArtistsUseCase
import ca.josuelubaki.tmdbclient.domain.usecase.UpdateArtistsUseCase
import ca.josuelubaki.tmdbclient.presentation.artist.ArtistActivity
import ca.josuelubaki.tmdbclient.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
class ArtistModule {
    @ActivityScoped
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