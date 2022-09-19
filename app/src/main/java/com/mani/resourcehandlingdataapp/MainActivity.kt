package com.mani.resourcehandlingdataapp

import android.app.Activity
import android.app.DatePickerDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.util.*


class MainActivity : Activity(), View.OnClickListener {

    lateinit var calendar : Calendar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calendar = Calendar.getInstance()

        findViewById<TextView>(R.id.tvAlertDialog).setOnClickListener(this)
        findViewById<TextView>(R.id.tvInputDialog).setOnClickListener(this)
        findViewById<TextView>(R.id.tvToastDialog).setOnClickListener(this)
        findViewById<TextView>(R.id.tvDateDialog).setOnClickListener(this)
        findViewById<TextView>(R.id.tvTimeDialog).setOnClickListener(this)
        findViewById<TextView>(R.id.tvProgressDialog).setOnClickListener(this)
        findViewById<TextView>(R.id.tvCustomDialog).setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        when(v?.id){

            R.id.tvAlertDialog ->{
                openAlertDialog()
            }

            R.id.tvInputDialog ->{
                openInputDialog()
            }

            R.id.tvToastDialog ->{
                Toast.makeText(this,"editableText",Toast.LENGTH_SHORT).show()

            }
            R.id.tvDateDialog ->{
                var dateDialog = DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    var selectedMonth = month + 1
                    var selectedDate = "$dayOfMonth/$selectedMonth/$year"
                    Toast.makeText(this,"$selectedDate",Toast.LENGTH_SHORT).show()
                },calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH))
                dateDialog.show()

            }

            R.id.tvTimeDialog ->{}

            R.id.tvCustomDialog ->{}

            R.id.tvProgressDialog ->{}

        }
    }

    private fun openInputDialog() {
        var alertDialog = AlertDialog.Builder(this)
        alertDialog.setIcon(R.drawable.no_internet)
        alertDialog.setTitle("INPUT DIALOG")
        var edittext = EditText(this)
        alertDialog.setView(edittext)
        alertDialog.setPositiveButton("YES",DialogInterface.OnClickListener { dialog, which ->
            var editableText = edittext.text.toString()
            Toast.makeText(this,editableText,Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        })
        alertDialog.setNegativeButton("NO",DialogInterface.OnClickListener { dialog, which ->
            dialog.dismiss()
        })
        alertDialog.show()

    }

    private fun openAlertDialog() {
        var alertDialog = AlertDialog.Builder(this)
        alertDialog.setIcon(R.drawable.no_internet)
        alertDialog.setTitle("No Internet")
        alertDialog.setMessage("DO You want to Connect with Internet")
        alertDialog.setPositiveButton("YES",DialogInterface.OnClickListener { dialog, which ->
            val intent = Intent(Settings.ACTION_WIRELESS_SETTINGS)
            startActivity(intent)
            dialog.dismiss()
        })
        alertDialog.setNegativeButton("NO",DialogInterface.OnClickListener { dialog, which ->
            dialog.dismiss()
        })

        alertDialog.show()


    }
}