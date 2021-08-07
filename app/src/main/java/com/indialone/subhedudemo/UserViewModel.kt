package com.indialone.subhedudemo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class UserViewModel(
    private val repository: UserRepository
): ViewModel() {

    private val apiResponse = MutableLiveData<ApiResponse>()

    init {
        postUserDetails(User())
    }

    fun postUserDetails(user: User) {
        viewModelScope.launch {
            try {
                coroutineScope {
                    val response = async {
                        repository.postUserDetails(user)
                    }
                    apiResponse.postValue(response.await())
                }
            } catch (e : Exception) {}
        }
    }

    fun getUserDetails() = apiResponse

}