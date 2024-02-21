package com.mjtammik.wellness

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mjtammik.wellness.ui.theme.WellnessTheme

@Composable
fun PHQ4(modifier: Modifier = Modifier) {
    Text(
        text = "PHQ4",
        modifier = modifier,
        style = MaterialTheme.typography.headlineLarge
    )
    Text(
        text = "The Patient Health Questionnaire-4 (PHQ-4), " +
            "developed by Kurt Kroenke, Robert L Spitzer, " +
            "Janet B W Williams, and Bernd Löwe.",
        modifier = modifier,
        style = MaterialTheme.typography.labelLarge
    )
    Text(
        text = "0. Not at all\n" +
                "1. Several days\n" +
                "2. More than half the days\n" +
                "3. Nearly every day",
        modifier = modifier,
        style = MaterialTheme.typography.bodyLarge
    )

    var answer1 by remember { mutableStateOf(Option.Option0) }
    RadioButtonSelection(
        text = "Over the last 2 weeks, how often have you been bothered by " +
                "feeling nervous, anxious or on edge?",
        selected = answer1,
        min = Option.Option0,
        max = Option.Option3,
        onOptionSelected = {option -> answer1 = option}
    )
    var answer2 by remember { mutableStateOf(Option.Option0) }
    RadioButtonSelection(
        text = "Over the last 2 weeks, how often have you been bothered by " +
                "not being able to stop or control worrying?",
        selected = answer2,
        min = Option.Option0,
        max = Option.Option3,
        onOptionSelected = {option -> answer2 = option}
    )
    var answer3 by remember { mutableStateOf(Option.Option0) }
    RadioButtonSelection(
        text = "Over the last 2 weeks, how often have you been bothered by " +
                "little interest or pleasure in doing things?",
        selected = answer3,
        min = Option.Option0,
        max = Option.Option3,
        onOptionSelected = {option -> answer3 = option}
    )
    var answer4 by remember { mutableStateOf(Option.Option0) }
    RadioButtonSelection(
        text = "Over the last 2 weeks, how often have you been bothered by " +
                "feeling down, depressed, or hopeless?",
        selected = answer4,
        min = Option.Option0,
        max = Option.Option3,
        onOptionSelected = {option -> answer4 = option}
    )

    val result: Int = answer1.ordinal + answer2.ordinal + answer3.ordinal + answer4.ordinal
    val normalized: Float = (1f - (result / 12f)) * 100f
    ResultText(text = "Resulting value is",
        appendix = "(PHQ-4",
        result = result,
        modifier = modifier
    )
    ResultText(text = "Normalized value is",
        appendix = "(Mood)",
        result = normalized.toInt(),
        modifier = modifier
    )

    // None 0-2
    // Mild 3-5
    // Moderate 6-8
    // Severe 9-12

    // Anxiety subscale = sum of items 1 and 2 (score range, 0 to 6)
    // Depression subscale = sum of items 3 and 4 (score range, 0 to 6)
    // On each subscale, a score of 3 or greater is considered positive for screening purposes
}

@Composable
fun ResultText(text: String, result: Int, modifier: Modifier = Modifier, appendix: String = "") {
    Text(
        text = "$text $result $appendix",
        modifier = modifier
    )
}


@Preview(showBackground = true)
@Composable
fun QuestionairePreview() {
    WellnessTheme {
        Column() {
            PHQ4(modifier = Modifier.padding(4.dp))
        }
    }
}