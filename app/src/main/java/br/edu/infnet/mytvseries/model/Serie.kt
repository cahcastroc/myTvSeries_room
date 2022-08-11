package br.edu.infnet.mytvseries.model

import androidx.lifecycle.LiveData
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Serie(
    @PrimaryKey(autoGenerate = true) var id: Int? = null,
        val registrationDate: String,
        val nameSerie: String,
        val channel: String? = null,
        val season: Int,
        val titleEp: String,
        val numberEp: Int,
        val review: Int? = null


) {
    override fun toString(): String {
        return "$registrationDate' - Streaming: $channel \n" +
                " Série: $nameSerie \n" +
                " $season temporada - Ep $numberEp - $titleEp \n" +
                "Avaliação: $review\n" +
                "\n"
    }
}