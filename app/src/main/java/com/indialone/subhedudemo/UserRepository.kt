package com.indialone.subhedudemo

import androidx.annotation.WorkerThread

class UserRepository {

    @WorkerThread
    suspend fun postUserDetails(user: User) = RetrofitBuilder.getApiService()
        .postUserDetails(user)

}