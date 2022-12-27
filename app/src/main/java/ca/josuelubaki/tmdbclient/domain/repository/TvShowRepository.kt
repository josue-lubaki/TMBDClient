package ca.josuelubaki.tmdbclient.domain.repository

import ca.josuelubaki.tmdbclient.data.model.tvshow.TvShow

interface TvShowRepository {
    suspend fun getTvShows(): List<TvShow>?
    suspend fun updateTvShows(): List<TvShow>?
}