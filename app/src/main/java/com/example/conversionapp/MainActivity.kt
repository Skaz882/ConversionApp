package com.example.conversionapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setLogo(R.mipmap.ic_launcher)
        supportActionBar!!.setDisplayUseLogoEnabled(true)

        val convertNum = findViewById<EditText>(R.id.idConvertNumber)
        val rbDolltoP = findViewById<RadioButton>(R.id.idRBDollarstoPesos)
        val rbPtoDoll = findViewById<RadioButton>(R.id.idRBPesostoDollars)
        val txtResult = findViewById<TextView>(R.id.idresults)
        val convertIt = findViewById<Button>(R.id.idButton)

        convertIt.setOnClickListener {
            val tenth = DecimalFormat("#.#")
            val dblMeasure = convertNum.text.toString().toDouble()
            val conversionRate = 2.54
            var convertMeasureNum: Double?

            if (rbPtoDoll.isChecked) {
                if (dblMeasure <= 72) {
                    convertMeasureNum = dblMeasure * conversionRate
                    txtResult.text=tenth.format(convertMeasureNum)
                } else{
                    Toast.makeText(this@MainActivity, "Currency must be less than 72",Toast.LENGTH_LONG ).show()
                }
            }

            if (rbDolltoP.isChecked) {
                if (dblMeasure <= 185) {
                    convertMeasureNum = dblMeasure / conversionRate
                    txtResult.text=tenth.format(convertMeasureNum)
                } else{
                    Toast.makeText(this@MainActivity, "Currency must be less than 185",Toast.LENGTH_LONG ).show()
                }
            }

        }
    }
}