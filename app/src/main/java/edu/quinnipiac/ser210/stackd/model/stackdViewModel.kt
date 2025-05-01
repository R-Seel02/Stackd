package edu.quinnipiac.ser210.stackd.model

import android.app.Application
import android.util.Log
import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Button

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.quinnipiac.ser210.stackd.api.AppDatabase
import edu.quinnipiac.ser210.stackd.api.Exercise
import edu.quinnipiac.ser210.stackd.api.ExerciseDao
import edu.quinnipiac.ser210.stackd.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class stackdViewModel (application: Application) : AndroidViewModel(application) {


//    val dao = AppDatabase.getDatabase(getApplication()).exerciseDao()

    private val stackdApi = ApiService.create()
    val _exerciseResult = MutableLiveData<Response<ArrayList<Exercise>>>()
    val exerciseResult: LiveData<Response<ArrayList<Exercise>>> get() = _exerciseResult
    private val _filteredExercises = MutableLiveData<List<Exercise>>()
    val filteredExercises: LiveData<List<Exercise>> get() = _filteredExercises


    fun getData() {
        Log.d("DEBUG", "getData() called")
        viewModelScope.launch {
            try {

                val response = stackdApi.getExercise()
                Log.d("DEBUG", "API response received")
                if (response.isSuccessful) {
                    Log.d("DEBUG", "API success: ${response.body()}")
                    _exerciseResult.value = response
                } else {
                    Log.e(
                        "DEBUG",
                        "API error code: ${response.code()}, error body: ${
                            response.errorBody()?.string()
                        }"
                    )
                }
            } catch (e: Exception) {
                Log.e("DEBUG", "Exception during API call: ${e.message}")
            }
        }

    }
//    fun toggleFavorite(exercise: Exercise) {
//        viewModelScope.launch(Dispatchers.IO) {
//            val updated = exercise.copy(isFavorited = !exercise.isFavorited)
//            dao.insert(updated)
//        }
//    }

    fun getExercisesForPart(part: String) {
        viewModelScope.launch {
            try {
                val response = stackdApi.getExercisesByBodyPart(part.lowercase())
                if (response.isSuccessful) {
                    _filteredExercises.value = response.body() ?: emptyList()
                } else {
                    Log.e(
                        "FILTER_FAIL",
                        "Code: ${response.code()}, body: ${response.errorBody()?.string()}"
                    )
                }
            } catch (e: Exception) {
                Log.e("FILTER_EXCEPTION", e.toString())
            }
        }
    }

    fun getRandomExercises() {
        viewModelScope.launch {
            try {
                val response = stackdApi.getExercise()
                if (response.isSuccessful) {
                    val shuffledList = response.body()?.shuffled() ?: emptyList()
                    _exerciseResult.value = Response.success(ArrayList(shuffledList))
                } else {
                    Log.e("API_ERROR", "Code: ${response.code()}")
                }
            } catch (e: Exception) {
                Log.e("API_EXCEPTION", e.toString())
            }
        }
    }
}