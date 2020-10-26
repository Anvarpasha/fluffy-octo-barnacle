package com.anvarpasha.avtogarage.ui.orderDetail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anvarpasha.avtogarage.data.network.model.request.ReportStatusRequestModel
import com.anvarpasha.avtogarage.data.network.model.response.ChangeResponse
import com.anvarpasha.avtogarage.data.network.model.response.ReportStatusResponse
import com.anvarpasha.avtogarage.data.network.model.response.SingleOrderResponse
import com.anvarpasha.avtogarage.data.network.network.APIResponse
import com.anvarpasha.avtogarage.data.network.persistence.prefs
import com.anvarpasha.avtogarage.data.network.repository.ProjectRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class OrderDetailVM(val repository: ProjectRepository) : ViewModel() {

    private val _properties = MutableLiveData<SingleOrderResponse>()
    val properties: LiveData<SingleOrderResponse>
        get() = _properties

    private val _acceptedMessages = MutableLiveData<ReportStatusResponse>()
    val acceptedMessages: LiveData<ReportStatusResponse>
        get() = _acceptedMessages

    private val _cancelMessages = MutableLiveData<ReportStatusResponse>()
    val cancelMessages: LiveData<ReportStatusResponse>
        get() = _cancelMessages

    private val _reportStatus = MutableLiveData<ChangeResponse>()
    val reportStatus: LiveData<ChangeResponse>
        get() = _reportStatus

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)


    init {
        getAcceptedMessages()
        getCancelMessages()
    }

    fun getSingleOrder(id: String) {

        coroutineScope.launch {


            when (val response = repository.getSingleOrder(prefs.getShopId(), id)) {
                is APIResponse.Success -> {
                    _properties.value = response.body
                }
                is APIResponse.Error -> {
                    Log.e("error", "${response.message} ${response.code}")
                }
            }
        }
    }

    fun getAcceptedMessages() {

        coroutineScope.launch {


            when (val response = repository.getAcceptMessages()) {
                is APIResponse.Success -> {
                    _acceptedMessages.value = response.body
                }
                is APIResponse.Error -> {
                    Log.e("error", "${response.message} ${response.code}")
                }
            }
        }
    }

    fun getCancelMessages() {

        coroutineScope.launch {

            when (val response = repository.getCancel()) {
                is APIResponse.Success -> {
                    _cancelMessages.value = response.body
                }
                is APIResponse.Error -> {
                    Log.e("error", "${response.message} ${response.code}")
                }
            }
        }
    }

    fun changeReportStatus(id:String,model:ReportStatusRequestModel) {

        coroutineScope.launch {

            when (val response = repository.changeReportStatus(id,model)) {
                is APIResponse.Success -> {
                    _reportStatus.value = response.body
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