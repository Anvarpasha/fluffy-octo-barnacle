package com.anvarpasha.avtogarage.ui.orders

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.anvarpasha.avtogarage.R
import com.anvarpasha.avtogarage.data.network.model.remote.Order
import com.anvarpasha.avtogarage.databinding.ListItemOrderHistoryBinding
import com.bumptech.glide.Glide


class OrdersAdapter(var list: List<Order>, private val onClickListener: OnClickListener) :
    RecyclerView.Adapter<OrdersAdapter.ViewHolder>() {

    class ViewHolder(private var binding: ListItemOrderHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: Order) {
            binding.model = model
            binding.executePendingBindings()
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ListItemOrderHistoryBinding.bind(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.list_item_order_history, parent, false)
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = list[position]
        holder.itemView.setOnClickListener {
            onClickListener.onCLick(model)
        }
        holder.bind(model)

        val socialImage = holder.itemView.findViewById<ImageView>(R.id.socialImg)

        val socialDrawable: Int = when (model.network) {
            "whatsapp" -> {
                R.drawable.whatsappicon
            }
            "instagram" -> {
                R.drawable.instaicon
            }
            else -> {
                R.drawable.facebookicon
            }
        }

        Glide.with(holder.itemView.context).load(socialDrawable).circleCrop().into(socialImage)

//        Glide.with(holder.itemView.context).load(model.socMedIcon)
//            .circleCrop().into(holder.socialImg)
    }


    class OnClickListener(val clickListener: (model: Order) -> Unit) {
        fun onCLick(model: Order) = clickListener(model)
    }

}