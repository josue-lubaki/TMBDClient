package ca.josuelubaki.tmdbclient.data.repository.tvshow.datasourceImpl

import ca.josuelubaki.tmdbclient.data.api.TMBDService
import ca.josuelubaki.tmdbclient.data.model.tvshow.TvShowList
import ca.josuelubaki.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDatasource
import retrofit2.Response

class TvShowRemoteDatasourceImpl(
    private val tmbdService: TMBDService,
    private val apiKey: String
) : TvShowRemoteDatasource {
    override suspend fun getTvShows(): Response<TvShowList> = tmbdService.getPopularTvShows(apiKey)
}