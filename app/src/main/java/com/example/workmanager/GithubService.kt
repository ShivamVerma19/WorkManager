package com.example.workmanager


import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubService {

    @GET("users")
    suspend fun getUsers(): Response<List<User>>


    @GET("users/{id}")
    suspend fun getUsersById(@Path("id") id : String?) : Response<User>




}