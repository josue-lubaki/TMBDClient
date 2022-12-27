package ca.josuelubaki.tmdbclient.domain.usecase

import ca.josuelubaki.tmdbclient.data.model.artist.Artist
import ca.josuelubaki.tmdbclient.domain.repository.ArtistRepository

class GetArtistsUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute(): List<Artist>? = artistRepository.getArtists()
}
