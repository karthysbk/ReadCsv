package com.example.rest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rest.databinding.ActivityMainBinding
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import java.io.BufferedReader

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: CsvAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var tableLayout: TableLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        val csvData = readCsv()

        recyclerView = findViewById(R.id.rvTable)
        tableLayout = findViewById(R.id.tbLayout)

        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = CsvAdapter(csvData)
        recyclerView.adapter = adapter

    }
    private fun readCsv(): List<CsvData> {
        val reader = BufferedReader(assets.open("user-data-sample.csv").reader())
        val parseCsv = CSVParser.parse(
            reader,
            CSVFormat.DEFAULT
        )

        val dataCsv = mutableListOf<CsvData>()
        val dataString = mutableListOf<String>()
        parseCsv.forEach {
            it?.let {
                dataString.addAll(it.toList())
                val data = CsvData(
                    id = it.get(0),
                    name = it.get(1),
                    dob = it.get(2),
                    address = it.get(3),
                    phone = it.get(4),
                    city = it.get(5)
                )
                dataCsv.add(data)
            }
        }

        val list = mutableListOf<Array<String>>()
        for(record in parseCsv) {
            val valueArray = mutableListOf<String>()
            for(value in record) {
                Log.d("VALUE", value)
                valueArray.add(value)
            }
            list.add(valueArray.toTypedArray())
        }
        Log.e("LIST", list.toString())
        parseCsv.close()
        reader.close()

        return dataCsv.toList()
    }

    //https://datahub.io/machine-learning/iris/r/1.html
}