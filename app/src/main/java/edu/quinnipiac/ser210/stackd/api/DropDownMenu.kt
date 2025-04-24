package edu.quinnipiac.ser210.stackd.api

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ExerciseDropdownMenu(exercises: List<Exercise>) {
    var expanded by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf<Exercise?>(null) }

    Box {
        Button(onClick = { expanded = true }) {
            Text(text = selectedItem?.name ?: "Select Exercise")
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            exercises.forEach { exercise ->
                DropdownMenuItem(
                    text = { Text(exercise.name) },
                    onClick = {
                        selectedItem = exercise
                        expanded = false
                    }
                )
            }
        }
    }

    selectedItem?.let {
        Column(modifier = Modifier.padding(top = 8.dp)) {
            Text("Targets: ${it.target.joinToString()}", color = Color.Black)
            Text("Type: ${it.type.joinToString()}", color = Color.Black)
            // Add more if needed
        }
    }
}

fun groupExercisesByBodyPart(exercises: List<Exercise>): Map<String, List<Exercise>> {
    return exercises
        .flatMap { exercise -> exercise.bodyPart.map { it to exercise } }
        .groupBy({ it.first }, { it.second })
}

@Composable
fun GroupedExerciseDropdowns(exercises: List<Exercise>) {
    val grouped = groupExercisesByBodyPart(exercises)

    Column {
        grouped.forEach { (bodyPart, exerciseList) ->
            Text(
                text = bodyPart,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 16.dp)
            )
            ExerciseDropdownMenu(exerciseList)
        }
    }
}
