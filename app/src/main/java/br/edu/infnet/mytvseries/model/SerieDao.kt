package br.edu.infnet.mytvseries.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface SerieDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(serie: Serie)


    @Query("SELECT * FROM Serie")
    fun listAll() : LiveData<List<Serie>>


    @Query("DELETE FROM Serie")
    fun deleteAll()



}

