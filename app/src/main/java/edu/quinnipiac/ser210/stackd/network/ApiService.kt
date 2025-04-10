package edu.quinnipiac.ser210.stackd.network

import edu.quinnipiac.ser210.model.user



interface ApiService {
    @GET("users/{id}")
    suspend fun getUser(@Path("id") id: Int): User
}