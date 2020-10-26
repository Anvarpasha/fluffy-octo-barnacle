package com.anvarpasha.avtogarage.ui.searchList

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anvarpasha.avtogarage.data.network.model.remote.Search
import com.anvarpasha.avtogarage.data.network.network.APIResponse
import com.anvarpasha.avtogarage.data.network.persistence.prefs
import com.anvarpasha.avtogarage.data.network.repository.ProjectRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class SearchVM(val repository: ProjectRepository) : ViewModel() {

    private val _properties = MutableLiveData<List<Search>>()
    val properties: LiveData<List<Search>>
        get() = _properties

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    val filter = HashMap<String, String>()


    fun getSearchScreen(date: String, name: String?) {

        coroutineScope.launch {

            filter["date_range"] = date

            if (!name.isNullOrEmpty())
                filter["query"] = name

            when (val response = repository.getSearchScreen(prefs.getShopId(), filter)) {
                is APIResponse.Success -> {
                    _properties.value = response.body?.list
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