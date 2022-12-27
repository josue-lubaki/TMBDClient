package ca.josuelubaki.tmdbclient.data.repository.tvshow.datasourceImpl

import ca.josuelubaki.tmdbclient.data.model.tvshow.TvShow
import ca.josuelubaki.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDatasource

class TvShowCacheDatasourceImpl : TvShowCacheDatasource {

    private val tvShowList = ArrayList<TvShow>()

    override suspend fun getTvShowsFromCache(): List<TvShow> = tvShowList

    override suspend fun saveTvShowsToCache(tvShows: List<TvShow>) {
        tvShowList.clear()
        tvShowList.addAll(tvShows)
    }
}