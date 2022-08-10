package br.edu.infnet.mytvseries.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface SerieDao {
    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(serie: Serie, episode: Episode)

    @Transaction
    @Query("SELECT * FROM Serie")
    fun listAllSerieAndEpisode() : LiveData<List<SerieAndEpisode>>


    @Query("SELECT * FROM Serie")
    fun listAllSeries() : LiveData<List<Serie>>


    @Query("DELETE FROM Serie")
    fun deleteAll()

}

