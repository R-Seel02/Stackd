package edu.quinnipiac.ser210.stackd.network

import edu.quinnipiac.ser210.stackd.model.User
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {
    @GET("users/{id}")
    suspend fun getUser(@Path("id") id: Int): User
}