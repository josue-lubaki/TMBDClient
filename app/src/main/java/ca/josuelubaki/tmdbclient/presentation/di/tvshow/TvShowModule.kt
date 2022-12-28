package ca.josuelubaki.tmdbclient.presentation.di.tvshow

import ca.josuelubaki.tmdbclient.domain.usecase.GetTvShowsUseCase
import ca.josuelubaki.tmdbclient.domain.usecase.UpdateTvShowsUseCase
import ca.josuelubaki.tmdbclient.presentation.tv.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
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