package com.neosoft.mycharts


import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet
import com.github.mikephil.charting.model.GradientColor


class MainActivity : AppCompatActivity() {
    private var chart: BarChart? = null
    private val seekBarX: SeekBar? = null
    private var seekBarY: SeekBar? = null
    private var l: Legend = Legend()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        chart =findViewById(R.id.chart1)

        chart?.apply {
            setDrawBarShadow(false)
            setDrawValueAboveBar(true)
            description.isEnabled = false
            setMaxVisibleValueCount(100)
            setPinchZoom(false)
            setDrawGridBackground(false)
            l = legend


        }


        l.verticalAlignment = Legend.LegendVerticalAlignment.BOTTOM
        l.orientation = Legend.LegendOrientation.HORIZONTAL
        l.setDrawInside(false)
        l.form = Legend.LegendForm.SQUARE
        l.textSize = 11f
        l.xEntrySpace = 4f

        setData(5, 10F);

           }

    private fun setData(count: Int, range: Float) {
        val start = 1f
        var values: ArrayList<BarEntry> = ArrayList()
        var i = start
        while (i < start + count) {
            val `va` = (Math.random() * (range + 1)).toFloat()
             if (Math.random() * 100 < 25) {
                 values.add(BarEntry(i, `va`,resources.getDrawable(R.drawable.ic_baseline_star_24)))

             } else {
                 values.add(BarEntry(i, `va`))

             }
            i++
        }
        val set1: BarDataSet
        if (chart?.data != null &&
            chart!!.data.dataSetCount > 0
        ) {
            set1 = chart!!.data.getDataSetByIndex(0) as BarDataSet
            set1.values = values
            chart!!.data.notifyDataChanged()
            chart!!.notifyDataSetChanged()
        } else {
            set1 = BarDataSet(values, "The year 2017")
            set1.setDrawIcons(false)
            val startColor1 = ContextCompat.getColor(this, R.color.black)
            val startColor2 = ContextCompat.getColor(this, R.color.purple_200)
            val startColor3 = ContextCompat.getColor(this, R.color.teal_200)
            val startColor4 = ContextCompat.getColor(this, R.color.black)
            val startColor5 = ContextCompat.getColor(this, R.color.purple_700)
            val endColor1 = ContextCompat.getColor(this, R.color.purple_500)
            val endColor2 = ContextCompat.getColor(this, R.color.white)
            val endColor3 = ContextCompat.getColor(this, R.color.teal_200)
            val endColor4 = ContextCompat.getColor(this, R.color.purple_200)
            val endColor5 = ContextCompat.getColor(this, R.color.purple_500)
            val gradientFills: MutableList<GradientColor> = ArrayList()
            gradientFills.add(GradientColor(startColor1, endColor1))
            gradientFills.add(GradientColor(startColor2, endColor2))
            gradientFills.add(GradientColor(startColor3, endColor3))
            gradientFills.add(GradientColor(startColor4, endColor4))
            gradientFills.add(GradientColor(startColor5, endColor5))
            set1.gradientColors = gradientFills
            val dataSets: ArrayList<IBarDataSet> = ArrayList()
            dataSets.add(set1)
            val data = BarData(dataSets)
            data.setValueTextSize(10f)
            data.barWidth = 0.9f
            chart?.data = data
        }
    }
}
