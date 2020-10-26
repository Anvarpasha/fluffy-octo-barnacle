package com.anvarpasha.avtogarage.ui.orders

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anvarpasha.avtogarage.data.network.model.response.OrderResponse
import com.anvarpasha.avtogarage.data.network.network.APIResponse
import com.anvarpasha.avtogarage.data.network.repository.ProjectRepository
import com.anvarpasha.avtogarage.data.network.persistence.prefs
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class OrderVM(val repository: ProjectRepository) : ViewModel() {

    private val _properties = MutableLiveData<OrderResponse>()
    val properties : LiveData<OrderResponse>
        get() = _properties

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)



    init {
        getOrders()
    }

    private fun getOrders() {

        coroutineScope.launch {

            when (val response  = repository.getOrders(prefs.getShopId())) {
                is APIResponse.Success -> {
                    _properties.value = response.body
                }
                is APIResponse.Error -> {
                    Log.e("error", "${response.message} ${response.code}")
                }
            }
        }
    }


    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}