package ca.josuelubaki.tmdbclient.data.repository.artist.datasource

import ca.josuelubaki.tmdbclient.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDatasource {
    suspend fun getArtists() : Response<ArtistList>
}