package com.dvnative.trailify.ui.components

import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle


@Composable
internal fun PrimaryLink(onclick: ()->Unit, modifier: Modifier = Modifier, text: String, color: Color, textStyle: TextStyle) {
    ClickableText(
        text = buildAnnotatedString{
            withStyle(SpanStyle(color = color)){
                append(text)
            }
        },
        style = textStyle,
        modifier = modifier
            .testTag("login-sub-btn"),
        onClick = { onclick() },
    )
}