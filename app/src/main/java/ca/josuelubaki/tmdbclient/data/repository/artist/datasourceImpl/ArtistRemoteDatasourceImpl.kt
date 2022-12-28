package ca.josuelubaki.tmdbclient.data.repository.artist.datasourceImpl

import ca.josuelubaki.tmdbclient.data.api.TMDBService
import ca.josuelubaki.tmdbclient.data.model.artist.ArtistList
import ca.josuelubaki.tmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import retrofit2.Response

class ArtistRemoteDatasourceImpl(
    private val TMDBService: TMDBService,
    private val apiKey: String
) : ArtistRemoteDatasource {
    override suspend fun getArtists(): Response<ArtistList> = TMDBService.getPopularArtists(apiKey)
}