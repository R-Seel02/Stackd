package edu.quinnipiac.ser210.stackd.api

import edu.quinnipiac.ser210.stackd.network.ApiClient
import edu.quinnipiac.ser210.stackd.network.ApiService

class ExerciseRepository(private val dao: ExerciseDao, private val api: ApiService) {

//    suspend fun refreshAll() {
//        val remote = api.getExercise()
//        if (remote.isSuccessful) {
//            val sanitized = remote.body().orEmpty().map { it.sanitized() }
//            dao.insertAll(sanitized)
//        }
//    }
}
