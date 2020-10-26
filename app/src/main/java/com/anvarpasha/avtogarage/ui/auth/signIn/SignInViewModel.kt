package com.anvarpasha.avtogarage.ui.auth.signIn

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anvarpasha.avtogarage.data.network.model.request.LoginModel
import com.anvarpasha.avtogarage.data.network.model.response.LoginResponse
import com.anvarpasha.avtogarage.data.network.network.APIResponse
import com.anvarpasha.avtogarage.data.network.repository.ProjectRepository
import com.anvarpasha.avtogarage.utils.isEmailAndPasswordValid
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class SignInViewModel(val repository: ProjectRepository) : ViewModel() {

    private val _properties = MutableLiveData<LoginResponse>()
    val properties : LiveData<LoginResponse>
        get() = _properties

    private val _goToOtpFragment = MutableLiveData<Boolean>()
    val goToOtpFragment : LiveData<Boolean>
        get() = _goToOtpFragment

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)


    fun onForgotBtnClick(){
        _goToOtpFragment.value = true
    }

    fun navigationToForgotDone(){
        _goToOtpFragment.value = false
    }

    fun onLoginBtnClick(email: String, pass: String) {

        if (!isEmailAndPasswordValid(email, pass))
            return

        coroutineScope.launch {

            val loginModel = LoginModel(email, pass)

            when (val response  = repository.loginUser(loginModel)) {
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