package ca.josuelubaki.tmdbclient.data.repository.artist

import android.util.Log
import ca.josuelubaki.tmdbclient.data.model.artist.Artist
import ca.josuelubaki.tmdbclient.data.repository.artist.datasource.ArtistCacheDatasource
import ca.josuelubaki.tmdbclient.data.repository.artist.datasource.ArtistLocalDatasource
import ca.josuelubaki.tmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import ca.josuelubaki.tmdbclient.domain.repository.ArtistRepository

class ArtistRepositoryImpl(
    private val artistRemoteDatasource: ArtistRemoteDatasource,
    private val artistLocalDatasource: ArtistLocalDatasource,
    private val artistCacheDatasource: ArtistCacheDatasource
) : ArtistRepository {
    override suspend fun getArtists(): List<Artist> {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist> {
        val newListOfArtists = getArtistsFromAPI()
        artistLocalDatasource.clearAll()
        artistLocalDatasource.saveArtistsToDB(newListOfArtists)
        artistCacheDatasource.saveArtistsToCache(newListOfArtists)
        return newListOfArtists
    }

    /**
     * method to get artists from remote
     * @return List<Artist>
     */
    private suspend fun getArtistsFromAPI(): List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            val response = artistRemoteDatasource.getArtists()
            val body = response.body()

            if (body != null) {
                artistList = body.artists
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        return artistList
    }

    /**
     * method to get artists from Database otherwise get from API
     * @return List<Artist>
     */
    private suspend fun getArtistsFromDB() : List<Artist> {
        lateinit var artistList: List<Artist>

        try{
            artistList = artistLocalDatasource.getArtistsFromDB()
        }catch (exception: Exception){
            Log.i("MyTag", exception.message.toString())
        }

        if(artistList.isNotEmpty()){
            return artistList
        } else {
            artistList = getArtistsFromAPI()
            artistLocalDatasource.saveArtistsToDB(artistList)
        }

        return artistList
    }

    /**
     * method to get artists from cache otherwise get from Database
     * @return List<Artist>
     */
    private suspend fun getArtistsFromCache() : List<Artist> {
        lateinit var artistList: List<Artist>

        try{
            artistList = artistCacheDatasource.getArtistsFromCache()
        }catch (exception: Exception){
            Log.i("MyTag", exception.message.toString())
        }

        if(artistList.isNotEmpty()){
            return artistList
        } else {
            artistList = getArtistsFromDB()
            artistCacheDatasource.saveArtistsToCache(artistList)
        }

        return artistList
    }
}