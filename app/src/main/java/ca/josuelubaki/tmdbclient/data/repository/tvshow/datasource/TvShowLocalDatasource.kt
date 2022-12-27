package ca.josuelubaki.tmdbclient.data.repository.tvshow.datasource

import ca.josuelubaki.tmdbclient.data.model.tvshow.TvShow

interface TvShowLocalDatasource {
    suspend fun getTvShowsFromDB() : List<TvShow>
    suspend fun saveTvShowsToDB(tvShows: List<TvShow>)
    suspend fun clearAll()
}