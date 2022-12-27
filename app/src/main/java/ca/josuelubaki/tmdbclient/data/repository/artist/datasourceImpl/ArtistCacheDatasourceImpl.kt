package ca.josuelubaki.tmdbclient.data.repository.artist.datasourceImpl

import ca.josuelubaki.tmdbclient.data.model.artist.Artist
import ca.josuelubaki.tmdbclient.data.repository.artist.datasource.ArtistCacheDatasource

class ArtistCacheDatasourceImpl : ArtistCacheDatasource {

    private var artistList = ArrayList<Artist>()

    override suspend fun getArtistsFromCache(): List<Artist> = artistList

    override suspend fun saveArtistsToCache(artists: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artists)
    }
}