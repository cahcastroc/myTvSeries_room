package br.edu.infnet.mytvseries.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Serie(
    @PrimaryKey(autoGenerate = true) var id: Int? = null,
        val nameSerie: String,
        val channel: String? = null
)