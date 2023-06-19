package com.location.detector.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.viewModelScope
import com.location.detector.data.api.ApiResult
import com.location.detector.data.model.Location
import com.location.detector.data.repository.LocationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus
import javax.inject.Inject

// @HiltViewModel will make models to be
// created using Hilt's model factory
// @Inject annotation used to inject all
// dependencies to view model class
@HiltViewModel
class MainViewModel @Inject constructor(private val locationRepository: LocationRepository) :
    ViewModel() {

    val locationData = MutableLiveData<Location>()
    val errorData = MutableLiveData<String>()
    val exceptionData = MutableLiveData<String>()

    var job: Job? = null
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }

    private val scope = viewModelScope + Job() + exceptionHandler


    fun getLocation(ip: String) {
        job = scope.launch(Dispatchers.IO) {
            locationRepository.getLocation(ip)
                .catch {
                    onError(it.message)
                }
                .collect {
                    when (it) {
                        is ApiResult.Success -> locationData.postValue(it.data)
                        is ApiResult.Error -> errorData.postValue("${it.code} ${it.message}")
                        is ApiResult.Exception -> exceptionData.postValue("${it.e.message}")
                    }
                }
        }
    }

    private fun onError(message: String?) {
        message?.let {
            errorData.postValue(it)
        }
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}