package br.edu.infnet.mytvseries.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.*
import androidx.lifecycle.ViewModelProvider
import br.edu.infnet.mytvseries.R
import br.edu.infnet.mytvseries.model.Serie
import br.edu.infnet.mytvseries.viewmodel.SerieViewModel
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val etNameSerie = this.findViewById<EditText>(R.id.etNameSerie)
        val etChannel = this.findViewById<EditText>(R.id.etChannel)
        val etSeason = this.findViewById<EditText>(R.id.etSeason)
        val etTittleEp = this.findViewById<EditText>(R.id.etTittleEp)

        val btSend = this.findViewById<Button>(R.id.btSend)
        val etReview = this.findViewById<EditText>(R.id.etReview)
        val etNumberEp = this.findViewById<EditText>(R.id.etNumberEp)
        val btList = this.findViewById<Button>(R.id.btList)


        //----------------

        val serieViewModel = ViewModelProvider(this).get(SerieViewModel::class.java)


        btSend.setOnClickListener {

            val date = date()
            if (validated(etNameSerie, etSeason, etTittleEp, etNumberEp)) {

                val serie = Serie(
                    null,
                    date,
                    etNameSerie.text.toString(),
                    etChannel.text.toString(),
                    etSeason.text.toString().toInt(),
                    etTittleEp.text.toString(),
                    etNumberEp.text.toString().toInt(),
                    etReview.text.toString().toInt()
                )
                serieViewModel.insert(serie)

                etNameSerie.setText("")
                etChannel.setText("")
                etSeason.setText("")
                etTittleEp.setText("")
                etNumberEp.setText("")
                etReview.setText("")

                Toast.makeText(
                    this,
                    "Registro salvo com sucesso",
                    Toast.LENGTH_LONG
                ).show()

            } else {
                Toast.makeText(
                    this,
                    "Obrigatório os campos de Nome, Temporada, Título e nº do Episódio",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        btList.setOnClickListener {
            val intent = Intent(this, List::class.java)
            startActivity(intent)
        }


    }

    private fun validated(
        nameSerie: EditText,
        season: EditText,
        title: EditText,
        numberEp: EditText
    ): Boolean {

        return nameSerie.text.isNotBlank()
                && season.text.isNotBlank() &&
                title.text.isNotBlank() &&
                numberEp.text.isNotBlank()
    }

     fun date(): String {
        val date = Calendar.getInstance().time

        val dateTimeFormat = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())

        return dateTimeFormat.format(date)
    }


}