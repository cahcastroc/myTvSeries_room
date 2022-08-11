package br.edu.infnet.mytvseries.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.edu.infnet.mytvseries.model.Episode
import br.edu.infnet.mytvseries.model.Serie

import br.edu.infnet.mytvseries.model.SerieDao

@Database(entities = arrayOf(Serie::class), version = 3, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {

    abstract fun serieDao() :SerieDao

    companion object{
        fun getDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "app_database"
            ).fallbackToDestructiveMigration().build()
        }
    }

}