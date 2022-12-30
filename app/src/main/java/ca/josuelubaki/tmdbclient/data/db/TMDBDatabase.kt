package ca.josuelubaki.tmdbclient.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ca.josuelubaki.tmdbclient.data.model.artist.Artist
import ca.josuelubaki.tmdbclient.data.model.movie.Movie
import ca.josuelubaki.tmdbclient.data.model.tvshow.TvShow

@Database(
    entities = [Movie::class, Artist::class, TvShow::class],
    version = 1,
    exportSchema = false
)
abstract class TMDBDatabase : RoomDatabase() {

        abstract fun movieDao(): MovieDao
        abstract fun artistDao(): ArtistDao
        abstract fun tvShowDao(): TvShowDao

        companion object {
            const val DATABASE_NAME: String = "tmdbclient_db"
        }
}