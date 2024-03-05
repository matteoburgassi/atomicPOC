package com.dvnative.trailify.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dvnative.trailify.R
import com.dvnative.trailify.ui.theme.AppTheme
import com.dvnative.trailify.ui.theme.extraColors


@Composable
fun PrimaryActiveButton(onClick: ()->Unit, text: String, enabled: Boolean, trailingIcon: Int? = null, leadingIcon: Int? = null){
    val colors = ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.onPrimary,
        disabledContainerColor = MaterialTheme.extraColors.disabledContainer,
        disabledContentColor = MaterialTheme.extraColors.onDisabled
    )
    PrimaryButton(onClick = onClick, text = text, enabled = enabled, colors = colors, trailingIcon = trailingIcon, leadingIcon = leadingIcon)
}

@Composable
fun PrimaryDefaultButton(onClick: ()->Unit, text: String, enabled: Boolean, trailingIcon: Int? = null, leadingIcon: Int? = null){
    val colors = ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.secondaryContainer,
        contentColor = MaterialTheme.colorScheme.onSecondary,
        disabledContainerColor = MaterialTheme.extraColors.disabledContainer,
        disabledContentColor = MaterialTheme.extraColors.onDisabled
    )
    PrimaryButton(onClick = onClick, text = text, enabled = enabled, colors = colors, trailingIcon = trailingIcon, leadingIcon = leadingIcon)
}
@Composable
fun PrimaryOutlineButton(onClick: ()->Unit, text: String, enabled: Boolean = false, trailingIcon: Int? = null, leadingIcon: Int? = null){
    val colors = ButtonDefaults.outlinedButtonColors(
        containerColor = MaterialTheme.colorScheme.tertiaryContainer,
        contentColor = MaterialTheme.colorScheme.onTertiary,
        disabledContainerColor = MaterialTheme.extraColors.disabledContainer,
        disabledContentColor = MaterialTheme.extraColors.onDisabled
    )
    OutlinedPrimaryButton(onClick = onClick, text = text, enabled = enabled, colors = colors, trailingIcon = trailingIcon, leadingIcon = leadingIcon)
}

@Composable
fun PrimaryLinkButton(onClick: () -> Unit, text: String, modifier: Modifier = Modifier, enabled: Boolean) {
    val color = MaterialTheme.colorScheme.onSurface
    PrimaryLink(onclick = onClick, text = text, modifier = modifier, color = color, textStyle = MaterialTheme.typography.bodyMedium)
}
@Composable
fun PrimaryActiveLinkButton(onClick: () -> Unit, text: String, modifier: Modifier = Modifier, enabled: Boolean) {
    val color = MaterialTheme.colorScheme.primaryContainer
    PrimaryLink(onclick = onClick, text = text, modifier = modifier, color = color, textStyle = MaterialTheme.typography.bodyMedium)
}
@Composable
fun SecondaryLinkButton(onClick: () -> Unit, text: String, modifier: Modifier = Modifier, enabled: Boolean) {
    val color = MaterialTheme.extraColors.onDisabled
    PrimaryLink(onclick = onClick, text = text, modifier = modifier, color = color, textStyle = MaterialTheme.typography.bodyMedium)
}

@Preview
@Composable
fun ButtonPreview() {
    AppTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.extraColors.backgroundGradient),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PrimaryActiveButton(onClick = {}, text = "Disabled Button", enabled = false)
            Spacer(Modifier.height(10.dp))
            PrimaryActiveButton(onClick = {}, text = "PrimaryActive Button", enabled = true, trailingIcon = R.drawable.logo)
            Spacer(Modifier.height(10.dp))
            PrimaryDefaultButton(onClick = {}, text = "PrimaryDefault Button", enabled = true)
            Spacer(Modifier.height(10.dp))
            PrimaryOutlineButton(onClick = {}, text = "PrimaryOutline Button", enabled = true)
            Spacer(Modifier.height(10.dp))
            PrimaryLinkButton(onClick = {}, text = "link button", enabled = true)
            PrimaryActiveLinkButton(onClick = {}, text = "link button", enabled = true)
            SecondaryLinkButton(onClick = {}, text = "link button", enabled = true)
        }
    }
}