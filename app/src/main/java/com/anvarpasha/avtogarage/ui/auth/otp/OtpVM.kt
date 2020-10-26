package com.anvarpasha.avtogarage.ui.auth.otp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anvarpasha.avtogarage.data.network.model.request.LoginModel
import com.anvarpasha.avtogarage.data.network.model.request.OtpModel
import com.anvarpasha.avtogarage.data.network.model.response.LoginResponse
import com.anvarpasha.avtogarage.data.network.model.response.OtpMainResponse
import com.anvarpasha.avtogarage.data.network.model.response.OtpResponse
import com.anvarpasha.avtogarage.data.network.network.APIResponse
import com.anvarpasha.avtogarage.data.network.repository.ProjectRepository
import com.anvarpasha.avtogarage.utils.isEmailAndPasswordValid
import com.anvarpasha.avtogarage.utils.isEmailValid
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class OtpVM(val repository: ProjectRepository) : ViewModel() {

    private val _properties = MutableLiveData<OtpMainResponse>()
    val properties : LiveData<OtpMainResponse>
        get() = _properties

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)


    fun sendOtpBtnClick(email: String) {

        if (!isEmailValid(email))
            return

        coroutineScope.launch {

            val model = OtpModel(email)

            when (val response  = repository.sendOtp(model)) {
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