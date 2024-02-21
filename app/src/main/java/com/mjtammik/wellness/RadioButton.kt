package com.mjtammik.wellness

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp

enum class Option (val value: Int) {
    Option0(0),
    Option1(1),
    Option2(2),
    Option3(3),
    Option4(4),
    Option5(5),
    Option6(6),
    Option7(7),
    Option8(8)
}

@Composable
fun RadioButtonSelection(
    text: String,
    selected: Option,
    onOptionSelected: (Option) -> Unit, // Callback function to return the selected option
    modifier: Modifier = Modifier,
    min: Option = Option.Option0,
    max: Option = Option.Option8
) {
    Column(modifier = modifier) {
        Text(
            text = text,
            modifier = Modifier.padding(top = 6.dp),
            style = MaterialTheme.typography.bodyMedium
        )

        Row() {
            val options = Option.entries
            options.forEach { option ->
                if(option in min..max) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        var mod = Modifier.scale(.7f, .7f)
                        RadioButton(
                            modifier = mod,
                            selected = selected == option,
                            // Invoke the callback
                            onClick = { onOptionSelected(option) }
                        )
                        // Display the option's name
                        Text(text = option.ordinal.toString())
                    }
                }
            }
        }
    }
}
