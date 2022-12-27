package ca.josuelubaki.tmdbclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ca.josuelubaki.tmdbclient.data.model.tvshow.TvShow

@Dao
interface TvShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShows(tvShows: List<TvShow>)

    @Query("DELETE FROM popular_tv_shows")
    suspend fun deleteAllTvShows()

    @Query("SELECT * FROM popular_tv_shows")
    suspend fun getTvShows(): List<TvShow>

}