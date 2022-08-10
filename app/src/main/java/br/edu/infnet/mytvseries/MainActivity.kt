package br.edu.infnet.mytvseries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.view.get
import androidx.lifecycle.ViewModelProvider
import br.edu.infnet.mytvseries.model.Episode
import br.edu.infnet.mytvseries.model.Serie
import br.edu.infnet.mytvseries.viewmodel.SerieViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val tv2 = findViewById<TextView>(R.id.tv2)

        val etNameSerie = this.findViewById<EditText>(R.id.etNameSerie)
        val etChannel = this.findViewById<EditText>(R.id.etChannel)
        val etSeason = this.findViewById<EditText>(R.id.etSeason)
        val etTittleEp = this.findViewById<EditText>(R.id.etTittleEp)
        val etDate =  this.findViewById<EditText>(R.id.etDate)
        val btSend = this.findViewById<Button>(R.id.btSend)
        val etReview = this.findViewById<EditText>(R.id.etReview)
        val etNumberEp = this.findViewById<EditText>(R.id.etNumberEp)



        //----------------

        val serieViewModel = ViewModelProvider(this).get(SerieViewModel::class.java)

        btSend.setOnClickListener {

            if (validated(etNameSerie,etSeason,etTittleEp,etNumberEp)) {
                val serie = Serie(null, etNameSerie.text.toString(), etChannel.text.toString())
                val episode = Episode(null,etSeason.text.toString().toInt(),
                    etTittleEp.text.toString(),etNumberEp.text.toString().toInt(),
                    etDate.text.toString(),etReview.text.toString().toInt())

                serieViewModel.insertAll(serie,episode)


            } else{
                Toast.makeText(this,"Obrigatório os campos de Nome, Temporada, Título e nº do Episódio", Toast.LENGTH_LONG).show()
            }
        }

        serieViewModel.serieAndEpisode.observe(this){
            tv2.text = ""

            it.forEach{ serieEp ->
                tv2.append("${serieEp}\n")
            }
        }



    }

    private fun validated(nameSerie: EditText, season: EditText, title: EditText, numberEp: EditText): Boolean {

        return nameSerie.text.isNotBlank()
                && season.text.isNotBlank() &&
                title.text.isNotBlank() &&
                numberEp.text.isNotBlank()
    }






}