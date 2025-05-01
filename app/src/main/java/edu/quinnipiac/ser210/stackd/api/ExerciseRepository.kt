package edu.quinnipiac.ser210.stackd.api

import edu.quinnipiac.ser210.stackd.network.ApiClient

class ExerciseRepository {
    private val apiService = ApiClient.apiService

//    suspend fun getExercises(): NetworkResponse<List<Exercise>> {
//        return try {
//            val response = apiService.getExercises()
//            if (response.isSuccessful) {
//                val exercises = response.body() ?: emptyList()
//                NetworkResponse.Success(exercises)
//            } else {
//                NetworkResponse.Error("Error: ${response.code()}")
//            }
//        } catch (e: Exception) {
//            NetworkResponse.Error("Exception: ${e.message}")
//        }
//    }
}