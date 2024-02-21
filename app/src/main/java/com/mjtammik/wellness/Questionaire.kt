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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mjtammik.wellness.ui.theme.WellnessTheme

@Composable
fun QuestionaireContent(modifier: Modifier = Modifier){
    Column {
        PHQ4(modifier = modifier)
        WEMWBS(modifier = modifier)
        WSAS(modifier = modifier)
    }
}

@Composable
fun PHQ4(modifier: Modifier = Modifier) {
    // Title
    Text(
        text = stringResource(id = R.string.q1_title),
        modifier = modifier,
        style = MaterialTheme.typography.headlineLarge
    )
    // Long name
    Text(
        text = stringResource(id = R.string.q1_sub_title),
        modifier = modifier,
        style = MaterialTheme.typography.labelLarge
    )
    // Scoring
    Text(
        text = stringResource(id = R.string.q1_scoring),
        modifier = Modifier.padding(12.dp),
        style = MaterialTheme.typography.bodyLarge
    )

    var answer1 by remember { mutableStateOf(Option.Option0) }
    RadioButtonSelection(
        text = stringResource(id = R.string.q1_p01),
        selected = answer1,
        min = Option.Option0,
        max = Option.Option3,
        onOptionSelected = {option -> answer1 = option}
    )
    var answer2 by remember { mutableStateOf(Option.Option0) }
    RadioButtonSelection(
        text = stringResource(id = R.string.q1_p02),
        selected = answer2,
        min = Option.Option0,
        max = Option.Option3,
        onOptionSelected = {option -> answer2 = option}
    )
    var answer3 by remember { mutableStateOf(Option.Option0) }
    RadioButtonSelection(
        text = stringResource(id = R.string.q1_p03),
        selected = answer3,
        min = Option.Option0,
        max = Option.Option3,
        onOptionSelected = {option -> answer3 = option}
    )
    var answer4 by remember { mutableStateOf(Option.Option0) }
    RadioButtonSelection(
        text = stringResource(id = R.string.q1_p04),
        selected = answer4,
        min = Option.Option0,
        max = Option.Option3,
        onOptionSelected = {option -> answer4 = option}
    )

    val result: Int = answer1.ordinal + answer2.ordinal +
            answer3.ordinal + answer4.ordinal
    val normalized: Float = (1f - (result / 12f)) * 100f
    ResultText(text = "Resulting value is",
        appendix = "(PHQ-4)",
        result = result,
        modifier = modifier
    )
    ResultText(text = "Normalized value is",
        appendix = "(Mood)",
        result = normalized.toInt(),
        modifier = modifier
    )

    // TODO: add some context

    // None 0-2
    // Mild 3-5
    // Moderate 6-8
    // Severe 9-12

    // Anxiety subscale = sum of items 1 and 2 (score range, 0 to 6)
    // Depression subscale = sum of items 3 and 4 (score range, 0 to 6)
    // On each subscale, a score of 3 or greater is considered positive for screening purposes
}

@Composable
fun WEMWBS(modifier: Modifier = Modifier) {
    // Title
    Text(
        text = "Wellbeing (WEMWBS)",
        modifier = modifier,
        style = MaterialTheme.typography.headlineLarge
    )
    // Long name
    Text(
        text = "The Warwick-Edinburgh Mental Well-being Scale (WEMWBS), " +
                "developed by Ruth Tennant, Louise Hiller, Ruth Fishwick, " +
                "Stephen Platt, Stephen Joseph, Scott Weich, Jane Parkinson, " +
                "Jenny Secker, and Sarah Stewart-Brown.",
        modifier = modifier,
        style = MaterialTheme.typography.labelLarge
    )
    // Scoring
    Text(
        text = "1. None of the time\n" +
                "2. Rarely\n" +
                "3. Some of the time\n" +
                "4. Often\n" +
                "5. All of the time"
        ,
        modifier = Modifier.padding(12.dp),
        style = MaterialTheme.typography.bodyLarge
    )

    var p01 by remember { mutableStateOf(Option.Option1) }
    RadioButtonSelection(
        text = stringResource(id = R.string.q2_p01),
        selected = p01,
        min = Option.Option1,
        max = Option.Option5,
        onOptionSelected = {option -> p01 = option}
    )
    var p02 by remember { mutableStateOf(Option.Option1) }
    RadioButtonSelection(
        text = stringResource(id = R.string.q2_p02),
        selected = p02,
        min = Option.Option1,
        max = Option.Option5,
        onOptionSelected = {option -> p02 = option}
    )
    var p03 by remember { mutableStateOf(Option.Option1) }
    RadioButtonSelection(
        text = stringResource(id = R.string.q2_p03),
        selected = p03,
        min = Option.Option1,
        max = Option.Option5,
        onOptionSelected = {option -> p03 = option}
    )
    var p04 by remember { mutableStateOf(Option.Option1) }
    RadioButtonSelection(
        text = stringResource(id = R.string.q2_p04),
        selected = p04,
        min = Option.Option1,
        max = Option.Option5,
        onOptionSelected = {option -> p04 = option}
    )
    var p05 by remember { mutableStateOf(Option.Option1) }
    RadioButtonSelection(
        text = stringResource(id = R.string.q2_p05),
        selected = p05,
        min = Option.Option1,
        max = Option.Option5,
        onOptionSelected = {option -> p05 = option}
    )
    var p06 by remember { mutableStateOf(Option.Option1) }
    RadioButtonSelection(
        text = stringResource(id = R.string.q2_p06),
        selected = p06,
        min = Option.Option1,
        max = Option.Option5,
        onOptionSelected = {option -> p06 = option}
    )
    var p07 by remember { mutableStateOf(Option.Option1) }
    RadioButtonSelection(
        text = stringResource(id = R.string.q2_p07),
        selected = p07,
        min = Option.Option1,
        max = Option.Option5,
        onOptionSelected = {option -> p07 = option}
    )
    var p08 by remember { mutableStateOf(Option.Option1) }
    RadioButtonSelection(
        text = stringResource(id = R.string.q2_p08),
        selected = p08,
        min = Option.Option1,
        max = Option.Option5,
        onOptionSelected = {option -> p08 = option}
    )
    var p09 by remember { mutableStateOf(Option.Option1) }
    RadioButtonSelection(
        text = stringResource(id = R.string.q2_p09),
        selected = p09,
        min = Option.Option1,
        max = Option.Option5,
        onOptionSelected = {option -> p09 = option}
    )
    var p10 by remember { mutableStateOf(Option.Option1) }
    RadioButtonSelection(
        text = stringResource(id = R.string.q2_p10),
        selected = p10,
        min = Option.Option1,
        max = Option.Option5,
        onOptionSelected = {option -> p10 = option}
    )
    var p11 by remember { mutableStateOf(Option.Option1) }
    RadioButtonSelection(
        text = stringResource(id = R.string.q2_p11),
        selected = p11,
        min = Option.Option1,
        max = Option.Option5,
        onOptionSelected = {option -> p11 = option}
    )
    var p12 by remember { mutableStateOf(Option.Option1) }
    RadioButtonSelection(
        text = stringResource(id = R.string.q2_p12),
        selected = p12,
        min = Option.Option1,
        max = Option.Option5,
        onOptionSelected = {option -> p12 = option}
    )
    var p13 by remember { mutableStateOf(Option.Option1) }
    RadioButtonSelection(
        text = stringResource(id = R.string.q2_p13),
        selected = p13,
        min = Option.Option1,
        max = Option.Option5,
        onOptionSelected = {option -> p13 = option}
    )
    var p14 by remember { mutableStateOf(Option.Option1) }
    RadioButtonSelection(
        text = stringResource(id = R.string.q2_p14),
        selected = p14,
        min = Option.Option1,
        max = Option.Option5,
        onOptionSelected = {option -> p14 = option}
    )

    val result: Int = (
            p01.ordinal + p02.ordinal + p03.ordinal
        + p04.ordinal + p05.ordinal + p06.ordinal + p07.ordinal
        + p08.ordinal + p09.ordinal + p10.ordinal + p11.ordinal
        + p12.ordinal + p13.ordinal + p14.ordinal
            )
    val normalized: Float = ((result - 14f) / 56f) * 100f
    ResultText(text = "Resulting value is",
        appendix = "(WEMWBS)",
        result = result,
        modifier = modifier
    )
    ResultText(text = "Normalized value is",
        appendix = "(Wellbeing)",
        result = normalized.toInt(),
        modifier = modifier
    )
}

@Composable
fun WSAS(modifier: Modifier = Modifier) {
    // Title
    Text(
        text = "Functioning (WSAS)",
        modifier = modifier,
        style = MaterialTheme.typography.headlineLarge
    )
    // Long name
    Text(
        text = "The Work and Social Adjustment Scale (WSAS), developed by " +
                "James C Mundt, Isaac M Marks, M Katherine Shear, and John H Greist.",
        modifier = modifier,
        style = MaterialTheme.typography.labelLarge
    )
    // Scoring
    Text(
        text = "Rate each of the following questions on a 0 to 8 scale: " +
                "0 indicates no impairment at all and 8 indicates very severe impairment.",
        modifier = Modifier.padding(12.dp),
        style = MaterialTheme.typography.bodyLarge
    )

    var answer1 by remember { mutableStateOf(Option.Option0) }
    RadioButtonSelection(
        text = stringResource(id = R.string.q3_p01),
        selected = answer1,
        min = Option.Option0,
        max = Option.Option8,
        onOptionSelected = {option -> answer1 = option}
    )
    var answer2 by remember { mutableStateOf(Option.Option0) }
    RadioButtonSelection(
        text = stringResource(id = R.string.q3_p02),
        selected = answer2,
        min = Option.Option0,
        max = Option.Option8,
        onOptionSelected = {option -> answer2 = option}
    )
    var answer3 by remember { mutableStateOf(Option.Option0) }
    RadioButtonSelection(
        text = stringResource(id = R.string.q3_p03),
        selected = answer3,
        min = Option.Option0,
        max = Option.Option8,
        onOptionSelected = {option -> answer3 = option}
    )
    var answer4 by remember { mutableStateOf(Option.Option0) }
    RadioButtonSelection(
        text = stringResource(id = R.string.q3_p04),
        selected = answer4,
        min = Option.Option0,
        max = Option.Option8,
        onOptionSelected = {option -> answer4 = option}
    )
    var answer5 by remember { mutableStateOf(Option.Option0) }
    RadioButtonSelection(
        text = stringResource(id = R.string.q3_p05),
        selected = answer5,
        min = Option.Option0,
        max = Option.Option8,
        onOptionSelected = {option -> answer5 = option}
    )

    val result: Int = answer1.ordinal + answer2.ordinal +
            answer3.ordinal + answer4.ordinal + answer5.ordinal
    val normalized: Float = (1f - (result / 40f)) * 100f
    ResultText(text = "Resulting value is",
        appendix = "(WSAS)",
        result = result,
        modifier = modifier
    )
    ResultText(text = "Normalized value is",
        appendix = "(Functioning)",
        result = normalized.toInt(),
        modifier = modifier
    )

    // TODO: add some context

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
        QuestionaireContent()
    }
}