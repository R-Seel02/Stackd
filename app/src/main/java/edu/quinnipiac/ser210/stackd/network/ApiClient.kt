package edu.quinnipiac.ser210.stackd.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val BASE_URL = "https://rapidapi.com/justin-WFnsXH_t6/api/exercisedb/playground/apiendpoint_8ae18d70-75aa-4164-b4ef-0afde01402c2"

    val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}