package edu.quinnipiac.ser210.stackd.network

import edu.quinnipiac.ser210.stackd.model.User
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path


interface ApiService {

//    @Headers(
//    "7f584a90a1mshf02cb77037613e9p17a9e2jsnf0b196a8e07e"
//    )


    @GET("users/{id}")
    suspend fun getUser(@Path("id") id: Int): User

    companion object {

        var BASE_URL = "https://rapidapi.com/justin-WFnsXH_t6/api/exercisedb/playground/apiendpoint_8ae18d70-75aa-4164-b4ef-0afde01402c2"


        fun create() : ApiService{


            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(ApiService::class.java)
        }

    }
}