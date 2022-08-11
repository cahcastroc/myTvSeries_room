package br.edu.infnet.mytvseries.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface SerieDao {

//    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(serie: Serie)

//    @Transaction
    @Query("SELECT * FROM Serie")
    fun listAll() : LiveData<List<Serie>>

//    @Update
//    fun updateSerie(serie: LiveData<List<Serie>>)

    @Delete
    fun deleteSerie(serie: Serie)

    @Query("DELETE FROM Serie")
    fun deleteAll()



}

