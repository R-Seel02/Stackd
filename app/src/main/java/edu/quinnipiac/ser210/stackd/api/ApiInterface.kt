package edu.quinnipiac.ser210.stackd.api
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.converter.gson.GsonConverterFactory

interface ApiInterface {
    @GET("marvel/")
    suspend fun getExercise() : Response<ArrayList<Exercise>>


    companion object {

        var BASE_URL = "https://simplifiedcoding.net/demos/"


        fun create() : ApiInterface {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)

        }
    }
}