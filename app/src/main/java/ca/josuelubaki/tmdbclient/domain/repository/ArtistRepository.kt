package ca.josuelubaki.tmdbclient.domain.repository

import ca.josuelubaki.tmdbclient.data.model.artist.Artist

interface ArtistRepository {
    suspend fun getArtists(): List<Artist>?
    suspend fun updateArtists(): List<Artist>?
}