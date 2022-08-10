package br.edu.infnet.mytvseries.model

import androidx.room.Embedded
import androidx.room.Relation

data class SerieAndEpisode (
    @Embedded val serie: Serie,
    @Relation(
        parentColumn = "id",
        entityColumn = "id"
    )
    val episode: Episode

)
