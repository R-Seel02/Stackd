//package edu.quinnipiac.ser210.stackd.Navigation
//
//import androidx.compose.foundation.layout.Box
//import androidx.compose.material3.Button
//import androidx.compose.material3.DropdownMenu
//import androidx.compose.material3.DropdownMenuItem
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import edu.quinnipiac.ser210.stackd.model.stackdViewModel
//@Composable
//fun DropdownMenu(viewModel: stackdViewModel) {
//    val items = viewModel.bodyPart.value
//    var expanded by remember { mutableStateOf(false) }
//    var selectedItem by remember { mutableStateOf<String?>(null) }
//
//    Box {
//        Button(onClick = { expanded = true }) {
//            Text(selectedItem ?: "Select an item")
//        }
//
//        DropdownMenu(
//            expanded = expanded,
//            onDismissRequest = { expanded = false }
//        ) {
//            items.forEach { item ->
//                DropdownMenuItem(
//                    text = { Text(item) },
//                    onClick = {
//                        selectedItem = item
//                        expanded = false
//                    }
//                )
//            }
//        }
//    }
//}
