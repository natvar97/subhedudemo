package com.indialone.subhedudemo

import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST(Constants.SIGN_IN_END_POINT)
    suspend fun postUserDetails(@Body user: User): ApiResponse

}