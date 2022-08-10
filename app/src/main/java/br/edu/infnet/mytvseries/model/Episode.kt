package br.edu.infnet.mytvseries.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Episode (
    @PrimaryKey(autoGenerate = true) var id: Int? = null,
        val season: Int,
        val titleEp: String,
        val numberEp: Int,
        val date: String? = null,
        val review: Int? = null

        )