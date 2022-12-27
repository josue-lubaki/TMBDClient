package ca.josuelubaki.tmdbclient.domain.usecase

import ca.josuelubaki.tmdbclient.data.model.tvshow.TvShow
import ca.josuelubaki.tmdbclient.domain.repository.TvShowRepository

class GetTvShowsUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute(): List<TvShow>? = tvShowRepository.getTvShows()
}