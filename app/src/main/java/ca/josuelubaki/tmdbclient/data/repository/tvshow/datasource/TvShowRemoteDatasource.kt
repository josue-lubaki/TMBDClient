package ca.josuelubaki.tmdbclient.data.repository.tvshow.datasource

import ca.josuelubaki.tmdbclient.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDatasource {
    suspend fun getTvShows() : Response<TvShowList>
}