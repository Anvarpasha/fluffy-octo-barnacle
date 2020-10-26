package com.anvarpasha.avtogarage.ui.searchList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anvarpasha.avtogarage.R
import com.anvarpasha.avtogarage.data.network.model.remote.Search
import com.anvarpasha.avtogarage.databinding.ListItemSearchHistoryBinding

class SearchAdapter(var list: List<Search>, private val onClickListener: OnClickListener) :
    RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    class ViewHolder(private var binding: ListItemSearchHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: Search) {
            binding.model = model
            binding.executePendingBindings()

        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ListItemSearchHistoryBinding.bind(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.list_item_search_history, parent, false)
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model=list[position]
        holder.itemView.setOnClickListener {
            onClickListener.onCLick(model)
        }
        holder.bind(model)

    }

    class OnClickListener(val clickListener: (model: Search) -> Unit) {
        fun onCLick(model: Search) = clickListener(model)
    }


}