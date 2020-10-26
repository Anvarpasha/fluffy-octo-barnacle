package com.anvarpasha.avtogarage.ui.profile

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anvarpasha.avtogarage.data.network.model.remote.Profile
import com.anvarpasha.avtogarage.data.network.network.APIResponse
import com.anvarpasha.avtogarage.data.network.repository.ProjectRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class ProfileVM(val repository: ProjectRepository) : ViewModel() {

    private val _properties = MutableLiveData<Profile>()
    val properties  : LiveData<Profile>
        get() = _properties

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    fun getProfileScreenAsync(){
        coroutineScope.launch {
            when (val response  = repository.getProfile()) {
                is APIResponse.Success -> {
                    _properties.value = response.body?.data
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