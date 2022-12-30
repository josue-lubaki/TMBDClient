package ca.josuelubaki.tmdbclient.presentation.di.tvshow

import ca.josuelubaki.tmdbclient.domain.usecase.GetTvShowsUseCase
import ca.josuelubaki.tmdbclient.domain.usecase.UpdateTvShowsUseCase
import ca.josuelubaki.tmdbclient.presentation.tv.TvShowActivity
import ca.josuelubaki.tmdbclient.presentation.tv.TvShowViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
class TvShowModule {
    @ActivityScoped
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(
            getTvShowsUseCase,
            updateTvShowsUseCase
        )
    }
}