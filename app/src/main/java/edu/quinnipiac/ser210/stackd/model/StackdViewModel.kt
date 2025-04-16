package edu.quinnipiac.ser210.stackd.model

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.quinnipiac.ser210.stackd.network.ApiService
import kotlinx.coroutines.launch

class StackdViewModel : ViewModel() {

    private val stackdApi = ApiService.create()


//    val id: Int,
//    val name: String,
//    val exercises: ArrayList<String>,
//    val targetList: ArrayList<String>,
//    val type: ArrayList<String>,
//    val bodyPart: ArrayList<String>,
//    val target: ArrayList<String>


    fun getData() {

        viewModelScope.launch {
            try {
                val response = stackdApi.getUser()
                    if(response.isSuccessful){
                        Log.d("API response: ", response.body().toString())
                    }
                )
            }
        }
    }


}