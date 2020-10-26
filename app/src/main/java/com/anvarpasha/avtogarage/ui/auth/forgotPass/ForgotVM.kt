package com.anvarpasha.avtogarage.ui.auth.forgotPass

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anvarpasha.avtogarage.data.network.model.request.ForgotModel
import com.anvarpasha.avtogarage.data.network.model.request.LoginModel
import com.anvarpasha.avtogarage.data.network.model.request.OtpModel
import com.anvarpasha.avtogarage.data.network.model.response.ForgotResponse
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

class ForgotVM(val repository: ProjectRepository) : ViewModel() {

    private val _properties = MutableLiveData<ForgotResponse>()
    val properties : LiveData<ForgotResponse>
        get() = _properties

    var  otpToken:String = ""

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)


    fun sendNewPassword(password: String,newPassword:String,code:String) {

        coroutineScope.launch {

            Log.e("data","$password \n$newPassword \n$code \n$otpToken ")
            val model = ForgotModel(code,password,newPassword,otpToken)

            when (val response  = repository.recoverPassword(model)) {
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