package edu.quinnipiac.ser210.stackd.api

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object Converters {
    private val gson = Gson()
    private val listType = object : TypeToken<List<String>>() {}.type

    @TypeConverter
    @JvmStatic
    fun listToJson(list: List<String>?): String? =
        if (list.isNullOrEmpty()) null else gson.toJson(list)

    @TypeConverter
    @JvmStatic
    fun jsonToList(json: String?): List<String>? =
        if (json.isNullOrBlank()) emptyList() else gson.fromJson(json, listType)
}
