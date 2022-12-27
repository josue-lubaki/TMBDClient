package ca.josuelubaki.tmdbclient.data.repository.tvshow.datasource

import ca.josuelubaki.tmdbclient.data.model.tvshow.TvShow

interface TvShowCacheDatasource {
    suspend fun getTvShowsFromCache() : List<TvShow>
    suspend fun saveTvShowsToCache(tvShows: List<TvShow>)
}