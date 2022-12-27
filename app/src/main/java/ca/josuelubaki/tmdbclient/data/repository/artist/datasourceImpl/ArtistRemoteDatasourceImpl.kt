package ca.josuelubaki.tmdbclient.data.repository.artist.datasourceImpl

import ca.josuelubaki.tmdbclient.data.api.TMBDService
import ca.josuelubaki.tmdbclient.data.model.artist.ArtistList
import ca.josuelubaki.tmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import retrofit2.Response

class ArtistRemoteDatasourceImpl(
    private val tmbdService: TMBDService,
    private val apiKey: String
) : ArtistRemoteDatasource {
    override suspend fun getArtists(): Response<ArtistList> = tmbdService.getPopularArtists(apiKey)
}