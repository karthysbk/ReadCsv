package com.example.rest

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CsvAdapter(private val csvData: List<CsvData>) :
    RecyclerView.Adapter<CsvRowViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CsvRowViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row_data, parent, false)
        return CsvRowViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CsvRowViewHolder, position: Int) {
        val rowData = csvData[position]
        holder.tv1.text = rowData.id
        holder.tv2.text = rowData.name
        holder.tv3.text = rowData.dob
        holder.tv4.text = rowData.address
        holder.tv5.text = rowData.phone

//        holder.containerLayout.removeAllViews()
//
//        for (columnValue in rowData) {
//            val value = columnValue.split(",")
//            val textView = TextView(holder.containerLayout.context)
//            textView.layoutParams = ViewGroup.LayoutParams(
//                ViewGroup.LayoutParams.WRAP_CONTENT,
//                ViewGroup.LayoutParams.WRAP_CONTENT
//            )
//            textView.text = columnValue
//            holder.containerLayout.addView(textView)
//        }

//        val tableLayout: TableLayout = findViewById(R.id.tableLayout)
//        val inflater = LayoutInflater.from(this)
//
//        for (rowData in csvData) {
//            val tableRow = inflater.inflate(R.layout.table_row_item, tableLayout, false) as TableRow
//
//            val column1TextView: TextView = tableRow.findViewById(R.id.column1)
//            val column2TextView: TextView = tableRow.findViewById(R.id.column2)
//
//            // Set data for each column
//            column1TextView.text = rowData[0]
//            column2TextView.text = rowData[1]
//
//            // Add the TableRow to the TableLayout
//            tableLayout.addView(tableRow)
//        }
    }

    override fun getItemCount(): Int = csvData.size
}

class CsvRowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
  //  val containerLayout: LinearLayout = itemView.findViewById(R.id.container_layout)
    val tv1: TextView = itemView.findViewById(R.id.col1)
    val tv2: TextView = itemView.findViewById(R.id.col2)
    val tv3: TextView = itemView.findViewById(R.id.col3)
    val tv4: TextView = itemView.findViewById(R.id.col4)
    val tv5: TextView = itemView.findViewById(R.id.col5)
}

