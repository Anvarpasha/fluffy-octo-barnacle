package com.anvarpasha.avtogarage.ui.orders

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.anvarpasha.avtogarage.databinding.OrderHistoryFragmentBinding
import com.anvarpasha.avtogarage.ui.orderDetail.OrderDetail
import org.koin.androidx.viewmodel.ext.android.viewModel


class OrderHistoryFragment : Fragment() {

    private val viewModel: OrderVM by viewModel()
    private val binding: OrderHistoryFragmentBinding by lazy {
        OrderHistoryFragmentBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding.viewModel = viewModel
        binding.lifecycleOwner = this





        val recyclerView = binding.recyclerView

        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        recyclerView.layoutManager = layoutManager


        viewModel.properties.observe(viewLifecycleOwner, Observer {



            recyclerView.adapter = OrdersAdapter(it.list, OrdersAdapter.OnClickListener {

                startActivity(Intent(activity, OrderDetail::class.java).putExtra("id", it.id))

            })
        })


        return binding.root
    }


}