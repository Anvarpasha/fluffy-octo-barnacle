package com.anvarpasha.avtogarage.ui.orderDetail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.anvarpasha.avtogarage.R
import com.anvarpasha.avtogarage.data.network.model.remote.ReportStatus
import com.anvarpasha.avtogarage.data.network.model.request.ReportStatusRequestModel
import com.anvarpasha.avtogarage.databinding.OrderDetailActivityBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class OrderDetail : AppCompatActivity() {

    private val viewModel: OrderDetailVM by viewModel()
    lateinit var binding: OrderDetailActivityBinding
    lateinit var acceptDialog: AlertDialog
    lateinit var cancelDialog: AlertDialog
     var orderId: Int = 0

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.order_detail_activity)


        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        orderId = intent.getIntExtra("id", 0)
        viewModel.getSingleOrder(orderId.toString())

        val answered = binding.btnAnswered
        val rejected = binding.btnReject



        viewModel.acceptedMessages.observe(this, {

            //TODO burda type'ikinci parameter olaraq teyin edilib men 1 ve 0 istifade etmishem sen duzgun olan hansidirsa. cavablandi uchun olan type'in duzgun deyerini qeyd edersen
            acceptDialog = createDialog(it.list, 1)
        })
        viewModel.cancelMessages.observe(this, {
            //TODO  imtina edildi uchun olan type'in duzgun deyerini qeyd edersen
            cancelDialog = createDialog(it.list, 0)
        })

        answered.setOnClickListener {

            acceptDialog.show()

        }

        rejected.setOnClickListener {

            cancelDialog.show()
        }

        viewModel.reportStatus.observe(this, Observer {

            Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
        })


    }

    private fun createDialog(list: List<ReportStatus>, type: Int): AlertDialog {

        val view = layoutInflater.inflate(R.layout.reject_spinner, null)
        val spinner = view.findViewById<Spinner>(R.id.spinner)

        val dialogBuilder = AlertDialog.Builder(this)
            .setCancelable(false)
            .setPositiveButton("Done") { dialog, id ->

                val model = ReportStatusRequestModel(list[spinner.selectedItemPosition].id, type)
                viewModel.changeReportStatus(orderId.toString(), model)
            }
            .setNegativeButton("Cancel") { dialog, id ->
                dialog.cancel()
            }


        val data: ArrayList<String> = ArrayList()
        list.forEach {
            data.add(it.description)
        }
        val spAdapter: ArrayAdapter<String> = ArrayAdapter<String>(
            this@OrderDetail,
            android.R.layout.simple_spinner_item,
            data
        )
        spAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = spAdapter

        val alert = dialogBuilder.create()
        alert.setTitle("Select")
        alert.setView(view)
        return alert
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return true
    }

}