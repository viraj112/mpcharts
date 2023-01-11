package com.neosoft.mycharts

import android.graphics.Color
import android.os.Bundle
import android.util.Log

import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry

import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import java.util.*


class PieChartActivity : AppCompatActivity() {
    private var pieChart: PieChart? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pie_chart)

        pieChart = findViewById(R.id.pieChart_view)

        showPieChart()
    }

    private fun showPieChart() {
        val pieEntries: ArrayList<PieEntry> = ArrayList()
        val label = "type"

        //initializing data

        //initializing data
        val typeAmountMap: MutableMap<String, Int> = HashMap()
        typeAmountMap["Toys"] = 200
        typeAmountMap["Snacks"] = 230
        typeAmountMap["Clothes"] = 100
        typeAmountMap["Stationary"] = 100
        typeAmountMap["Phone"] = 50

        //initializing colors for the entries

        //initializing colors for the entries


//        val colorArray: IntArray = resources.getIntArray(R.array.rainbow)
//        val colors: ArrayList<Int> = ArrayList()
//        for (color in colorArray) {
//            colors.add(color)
//        }



        //initializing data




        //initializing colors for the entries

        val colors: ArrayList<Int> = ArrayList()
        colors.add(Color.parseColor("#304567"))
        colors.add(Color.parseColor("#309967"))
        colors.add(Color.parseColor("#476567"))
        colors.add(Color.parseColor("#890567"))
        colors.add(Color.parseColor("#a35567"))
        colors.add(Color.parseColor("#ff5f67"))
        colors.add(Color.parseColor("#3ca567"))


        //input data and fit data into pie chart entry

        //input data and fit data into pie chart entry
        for (type in typeAmountMap.keys) {
            pieEntries.add(PieEntry(typeAmountMap[type]!!.toFloat(), type))
        }



        //collecting the entries with label name
        val pieDataSet = PieDataSet(pieEntries, label)
        //setting text size of the value
        //setting text size of the value
        pieDataSet.valueTextSize = 12f


        //providing color list for coloring different entries
        pieDataSet.colors = colors

        //grouping the data set from entry to chart
        val pieData = PieData(pieDataSet)

        //showing the value of the entries, default true if not set
        pieData.setDrawValues(true)
       /* pieData.setValueFormatter(PercentFormatter())*/

        pieChart!!.data = pieData
        pieChart!!.invalidate()
        pieChart!!.isRotationEnabled = false
        pieChart!!.setHoleRadius(0f);
        pieChart!!.setTransparentCircleRadius(0f);

        pieChart!!.setOnChartValueSelectedListener(object :OnChartValueSelectedListener{
            override fun onValueSelected(e: Entry?, h: Highlight?) {
                Log.d("Entry", "onValueSelected: $")
            }

            override fun onNothingSelected() {

            }

        })

       /* pieChart!!.setUsePercentValues(true)*/
    }
}