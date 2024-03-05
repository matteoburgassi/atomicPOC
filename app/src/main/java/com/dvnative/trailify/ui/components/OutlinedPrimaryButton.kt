package com.dvnative.trailify.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.dvnative.trailify.ui.tokens.sizes
import com.dvnative.trailify.ui.theme.extraColors

@Composable
internal fun OutlinedPrimaryButton(onClick: ()->Unit, text: String, enabled: Boolean, trailingIcon: Int? = null, leadingIcon: Int? = null, colors: ButtonColors) {
    OutlinedButton(
        onClick = onClick,
        enabled = enabled,
        border = BorderStroke(
            color = MaterialTheme.colorScheme.outline,
            width = MaterialTheme.shapes.sizes.buttonOutlineBorder,
        ),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = MaterialTheme.colorScheme.tertiaryContainer,
            contentColor = MaterialTheme.colorScheme.onTertiary,
            disabledContainerColor = MaterialTheme.extraColors.disabledContainer,
            disabledContentColor = MaterialTheme.extraColors.onDisabled
        ),
        shape = RoundedCornerShape(MaterialTheme.shapes.sizes.buttonsBorderRadius),
        modifier = Modifier
            .testTag("login-confirm")
            .fillMaxWidth()
            .height(50.dp),
    ) {
        leadingIcon?.let {
            Icon(
                painter = painterResource(id = it),
                contentDescription = "",
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
        }
        Text(text = text)
        trailingIcon?.let {
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Icon(
                painter = painterResource(id = it),
                contentDescription = "",
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
        }
    }
}