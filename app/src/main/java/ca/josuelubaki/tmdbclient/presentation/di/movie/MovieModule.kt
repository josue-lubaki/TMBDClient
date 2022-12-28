package ca.josuelubaki.tmdbclient.presentation.di.movie

import ca.josuelubaki.tmdbclient.domain.usecase.GetMoviesUseCase
import ca.josuelubaki.tmdbclient.domain.usecase.UpdateMoviesUseCase
import ca.josuelubaki.tmdbclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
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