package ca.josuelubaki.tmdbclient.presentation.di.movie

import ca.josuelubaki.tmdbclient.domain.usecase.GetMoviesUseCase
import ca.josuelubaki.tmdbclient.domain.usecase.UpdateMoviesUseCase
import ca.josuelubaki.tmdbclient.presentation.movie.MovieActivity
import ca.josuelubaki.tmdbclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
class MovieModule {
    @ActivityScoped
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(
            getMoviesUseCase,
            updateMoviesUseCase
        )
    }

}