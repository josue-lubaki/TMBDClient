package ca.josuelubaki.tmdbclient.data.repository.artist.datasource

import ca.josuelubaki.tmdbclient.data.model.artist.Artist

interface ArtistCacheDatasource {
    suspend fun getArtistsFromCache(): List<Artist>
    suspend fun saveArtistsToCache(artists: List<Artist>)
}