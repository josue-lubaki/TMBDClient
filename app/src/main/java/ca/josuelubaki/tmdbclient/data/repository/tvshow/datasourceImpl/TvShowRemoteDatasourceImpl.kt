package ca.josuelubaki.tmdbclient.data.repository.tvshow.datasourceImpl

import ca.josuelubaki.tmdbclient.data.api.TMDBService
import ca.josuelubaki.tmdbclient.data.model.tvshow.TvShowList
import ca.josuelubaki.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDatasource
import retrofit2.Response

class TvShowRemoteDatasourceImpl(
    private val TMDBService: TMDBService,
    private val apiKey: String
) : TvShowRemoteDatasource {
    override suspend fun getTvShows(): Response<TvShowList> = TMDBService.getPopularTvShows(apiKey)
}