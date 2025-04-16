package edu.quinnipiac.ser210.stackd.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.quinnipiac.ser210.stackd.api.ApiInterface
import edu.quinnipiac.ser210.stackd.api.Exercise
import edu.quinnipiac.ser210.stackd.network.ApiService
import kotlinx.coroutines.launch
import retrofit2.Response

class StackdViewModel : ViewModel() {

    private val stackdApi = ApiService.create()

    class StackdViewModel : ViewModel(){
        private val stackdApi = ApiInterface.create()
        val _excerciseResult = MutableLiveData<Response<ArrayList<Exercise>>>()
        val _exerciseResult : LiveData<Response<ArrayList<Exercise>>> = _excerciseResult



    fun getData() {

        viewModelScope.launch {
            try {

                val response = stackdApi.getExercise()
                if (response.isSuccessful) {
                    Log.d("API response: ", response.body().toString())
                    _excerciseResult.value = response
                } else {
                    Log.d("network error", "Failed to load data")
                }
            }
            catch (e: Exception){
                e.message?.let { Log.d("network error", it) }
            }
            }

        }
    }


}