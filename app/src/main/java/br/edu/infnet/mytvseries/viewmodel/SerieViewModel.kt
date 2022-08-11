package br.edu.infnet.mytvseries.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import br.edu.infnet.mytvseries.database.AppDatabase
import br.edu.infnet.mytvseries.model.Serie

import br.edu.infnet.mytvseries.model.SerieDao

class SerieViewModel (application: Application) : AndroidViewModel(application)  {

//    val serieAndEpisode: LiveData<List<SerieAndEpisode>>

    val serie: LiveData<List<Serie>>

    private val serieDao: SerieDao

    init {
        val database = AppDatabase.getDatabase(application)
        serieDao = database.serieDao()
        serie = serieDao.listAll()
    }

    fun insert (serie: Serie){
        Thread{
            serieDao.insert(serie)
        }.start()
    }

    fun deleteSerie(serie: Serie){
        Thread{
            serieDao.deleteSerie(serie)
        }
    }

    fun deleteAll(){
        Thread{
            serieDao.deleteAll()
        }.start()

    }

    fun listAll(){
        Thread{
            serieDao.listAll()
        }
    }




}