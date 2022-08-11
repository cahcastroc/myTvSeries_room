package br.edu.infnet.mytvseries.view

import android.content.Context
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
import kotlin.collections.ArrayList

class List : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val list = ArrayList<String>()

        val tv2 = findViewById<TextView>(R.id.tv2)
        val serieViewModel = ViewModelProvider(this).get(SerieViewModel::class.java)

                serieViewModel.serie.observe(this) {
                    tv2.text = ""

            it.forEach { serieEp ->
                tv2.append("${serieEp}\n")
                list.add(serieEp.toString())

            }
        }

        val btDel = this.findViewById<Button>(R.id.btDel)

        btDel.setOnClickListener {
            serieViewModel.deleteAll()

            Toast.makeText(this,"Registros deletados",Toast.LENGTH_LONG).show()

        }


        val btSave = this.findViewById<Button>(R.id.btSave)

        btSave.setOnClickListener {


            val filename = "lista_series-${date()}.txt"
            val fileContents =  list.toString()
                 openFileOutput(filename, Context.MODE_PRIVATE).use {
                it.write(fileContents.toByteArray())
            }
                Toast.makeText(this,"Salvo com sucesso",Toast.LENGTH_LONG).show()
              }
       
   }


    fun date(): String {
        val date = Calendar.getInstance().time

        val dateTimeFormat = SimpleDateFormat("dd-MM-yyyy-hh-mm", Locale.getDefault())

        return dateTimeFormat.format(date)
    }
}