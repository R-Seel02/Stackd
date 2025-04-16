package edu.quinnipiac.ser210.stackd.api

data class Exercise( val id: Int,
                     val name: String,
                     val exercises: ArrayList<String>,
                     val targetList: ArrayList<String>,
                     val type: ArrayList<String>,
                     val bodyPart: ArrayList<String>,
                     val target: ArrayList<String>)

