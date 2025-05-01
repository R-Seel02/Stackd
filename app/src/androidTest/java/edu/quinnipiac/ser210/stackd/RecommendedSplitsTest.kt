package edu.quinnipiac.ser210.stackd

import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithTag
import org.junit.Rule
import org.junit.Test

class RecommendedSplitsTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>() // replace with your activity

    @Test
    fun recommendedSplitsHeaderAndArrowAreVisible() {
        // Look for the text
        composeTestRule
            .onNodeWithTag("splitsText")
            .assertExists()
            .assertIsDisplayed()

        // Look for the icon
        composeTestRule
            .onNodeWithTag("splitsArrow")
            .assertExists()
            .assertIsDisplayed()

        // Look for the row container (optional)
        composeTestRule
            .onNodeWithTag("recommendedSplitsRow")
            .assertExists()
    }
}