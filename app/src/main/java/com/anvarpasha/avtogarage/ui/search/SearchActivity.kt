package com.anvarpasha.avtogarage.ui.search

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.anvarpasha.avtogarage.R
import com.anvarpasha.avtogarage.ui.searchList.SearchResultActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout
import java.text.SimpleDateFormat
import java.util.*

class SearchActivity : AppCompatActivity() {
    // method which is using to get  Calendar class
    private val cal: Calendar = Calendar.getInstance()
    lateinit var fromDatePicker: DatePickerDialog
    lateinit var toDatePicker: DatePickerDialog
    lateinit var dateTxt: TextView
    lateinit var textInputLayoutName: TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.search_fragment)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        dateTxt = findViewById(R.id.dateTxt)
        textInputLayoutName = findViewById(R.id.textInputLayout)

        dateTxt.text = convertToMyDate()

        val fromDateSetListener =
            DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                fromUpdateDateInView()
            }

        fromDatePicker = DatePickerDialog(
            this@SearchActivity,
            fromDateSetListener,
            // set DatePickerDialog to point to today's date when it loads up
            cal.get(Calendar.YEAR),
            cal.get(Calendar.MONTH),
            cal.get(Calendar.DAY_OF_MONTH)
        )


        val toDateSetListener =
            DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                toUpdateDateInView()
            }

        toDatePicker = DatePickerDialog(
            this@SearchActivity,
            toDateSetListener,
            // set DatePickerDialog to point to today's date when it loads up
            cal.get(Calendar.YEAR),
            cal.get(Calendar.MONTH),
            cal.get(Calendar.DAY_OF_MONTH)
        )


        dateTxt.setOnClickListener {
            fromDatePicker.show()
        }

        findViewById<MaterialButton>(R.id.searchBtn).setOnClickListener {

            val bundle = Bundle()
            bundle.putString("date", dateTxt.text.toString())
            bundle.putString("name", textInputLayoutName.editText?.text.toString().trim())

            startActivity(
                Intent(
                    this@SearchActivity,
                    SearchResultActivity::class.java
                ).putExtra("data", bundle)
            )
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return true
    }

    private fun toUpdateDateInView() {
        dateTxt.text = "${dateTxt.text}-${convertToMyDate()}"
    }

    private fun fromUpdateDateInView() {
        dateTxt.text = convertToMyDate()
        toDatePicker.show()
    }

    fun convertToMyDate(): String {
        val toMyFormat = "yyyy-MM-dd"
        val sdf = SimpleDateFormat(toMyFormat, Locale.US)
        return sdf.format(cal.time).toString()
    }


}

