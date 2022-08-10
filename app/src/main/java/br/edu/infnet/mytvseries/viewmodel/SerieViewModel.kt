package br.edu.infnet.mytvseries.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import br.edu.infnet.mytvseries.database.AppDatabase
import br.edu.infnet.mytvseries.model.Episode
import br.edu.infnet.mytvseries.model.Serie
import br.edu.infnet.mytvseries.model.SerieAndEpisode
import br.edu.infnet.mytvseries.model.SerieDao

class SerieViewModel (application: Application) : AndroidViewModel(application)  {

    val serieAndEpisode: LiveData<List<SerieAndEpisode>>

    private val serieDao: SerieDao

    init {
        val database = AppDatabase.getDatabase(application)
        serieDao = database.serieDao()
        serieAndEpisode = serieDao.listAllSerieAndEpisode()
    }

    fun insertAll (serie: Serie, episode: Episode){
        Thread{
            serieDao.insertAll(serie,episode)
        }.start()
    }

    fun deleteAll(){
        Thread{
            serieDao.deleteAll()
        }
    }
}