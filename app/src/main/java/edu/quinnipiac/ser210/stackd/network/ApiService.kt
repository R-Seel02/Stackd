package edu.quinnipiac.ser210.stackd.network

import edu.quinnipiac.ser210.stackd.api.Exercise
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

    @GET("exercises")

    suspend fun getExercise(): Response<ArrayList<Exercise>>

    companion object {
        private const val BASE_URL = "https://exercisedb.p.rapidapi.com/"
        private const val API_KEY = "7f584a90a1mshf02cb77037613e9p17a9e2jsnf0b196a8e07e" // ✅ Replace this with your actual key
        private const val API_HOST = "exercisedb.p.rapidapi.com"

        fun create(): ApiService {
            val client = OkHttpClient.Builder()
                .addInterceptor(Interceptor { chain ->
                    val request = chain.request().newBuilder()
                        .addHeader("X-RapidAPI-Key", API_KEY)
                        .addHeader("X-RapidAPI-Host", API_HOST)
                        .build()
                    chain.proceed(request)
                })
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}
