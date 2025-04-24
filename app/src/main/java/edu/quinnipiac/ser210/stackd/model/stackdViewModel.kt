package edu.quinnipiac.ser210.stackd.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.quinnipiac.ser210.stackd.api.Exercise
import edu.quinnipiac.ser210.stackd.network.ApiService
import kotlinx.coroutines.launch
import retrofit2.Response

class stackdViewModel : ViewModel() {



        private val stackdApi = ApiService.create()
          val _exerciseResult = MutableLiveData<Response<ArrayList<Exercise>>>()
    val exerciseResult: LiveData<Response<ArrayList<Exercise>>> get() = _exerciseResult




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
                    Log.e("DEBUG", "API error code: ${response.code()}, error body: ${response.errorBody()?.string()}")
                }
            }
            catch (e: Exception){
                Log.e("DEBUG", "Exception during API call: ${e.message}")
            }
            }

        }
    }


