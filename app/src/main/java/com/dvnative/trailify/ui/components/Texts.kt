package com.dvnative.trailify.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.dvnative.trailify.R
import com.dvnative.trailify.ui.tokens.sizes
import com.dvnative.trailify.ui.theme.AppTheme


@Composable
fun Title(modifier: Modifier = Modifier, text: String) {
    Text(
        text = text,
        modifier = modifier.padding(vertical = MaterialTheme.shapes.sizes.titleVerticalPadding),
        style = MaterialTheme.typography.titleLarge,
        color = MaterialTheme.colorScheme.onPrimary
    )
}
@Composable
fun Body(modifier: Modifier = Modifier, text: String, textAlign: TextAlign? = null) {
    Text(
        textAlign = textAlign,
        text = text,
        modifier = modifier,
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.onPrimary
    )
}

@Composable
fun InputField(
    value: String,
    modifier: Modifier = Modifier,
    label:  @Composable (() -> Unit)?= null,
    testTag: String? = "",
    isError: Boolean = false,
    errorLabel: String? = "",
    focusManager: FocusManager? = null,
    onValueChange: (String) -> Unit,
) {
    OutlinedTextField(
        value = value,
        modifier = modifier,
        onValueChange = onValueChange,
        shape = RoundedCornerShape(MaterialTheme.shapes.sizes.textFieldBorderRadius),
        label =  label,
        supportingText = { if (isError) {Text(errorLabel?: "")} },
        isError = isError,
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = MaterialTheme.colorScheme.onPrimary,
            unfocusedTextColor = MaterialTheme.colorScheme.onPrimary,
            focusedBorderColor = MaterialTheme.colorScheme.outline,
            errorBorderColor = MaterialTheme.colorScheme.error,
            errorContainerColor = MaterialTheme.colorScheme.onErrorContainer,
            unfocusedBorderColor = Color.Transparent,
            unfocusedContainerColor = MaterialTheme.colorScheme.onPrimaryContainer,
            focusedContainerColor = MaterialTheme.colorScheme.onPrimaryContainer,
//            disabledTextColor = MaterialTheme.colorScheme.secondaryContainer,
//            errorTextColor = MaterialTheme.colorScheme.error,
//            disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
//            errorContainerColor = MaterialTheme.colorScheme.secondaryContainer,
            cursorColor = MaterialTheme.colorScheme.outline,
//            errorCursorColor = MaterialTheme.colorScheme.secondaryContainer,
            selectionColors = TextSelectionColors(
                handleColor = MaterialTheme.colorScheme.outline,
                backgroundColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.5f)
            ),
//            focusedLeadingIconColor = MaterialTheme.colorScheme.secondaryContainer,
//            unfocusedLeadingIconColor = MaterialTheme.colorScheme.secondaryContainer,
//            disabledLeadingIconColor = MaterialTheme.colorScheme.secondaryContainer,
//            errorLeadingIconColor = MaterialTheme.colorScheme.secondaryContainer,
//            focusedTrailingIconColor = MaterialTheme.colorScheme.secondaryContainer,
//            unfocusedTrailingIconColor = MaterialTheme.colorScheme.secondaryContainer,
//            disabledTrailingIconColor = MaterialTheme.colorScheme.secondaryContainer,
//            errorTrailingIconColor = MaterialTheme.colorScheme.secondaryContainer,
            focusedLabelColor = MaterialTheme.colorScheme.outline,
            unfocusedLabelColor = MaterialTheme.colorScheme.outline,
//            disabledLabelColor = MaterialTheme.colorScheme.secondaryContainer
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(
            onNext ={
                focusManager?.moveFocus(FocusDirection.Down)
            }
        )
    )
}

@Composable
fun PasswordField(
    value: String,
    modifier: Modifier = Modifier,
    label:  @Composable (() -> Unit)?= null,
    testTag: String? = "",
    isError: Boolean = false,
    errorLabel: String? = "",
    focusManager: FocusManager? = null,
    onValueChange: (String) -> Unit,
)
{
    val passwordVisible = remember { mutableStateOf(false) }
    OutlinedTextField(
        value = value,
        modifier = modifier,
        onValueChange = onValueChange,
        shape = RoundedCornerShape(MaterialTheme.shapes.sizes.textFieldBorderRadius),
        label =  label,
        visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
        supportingText = { if (isError) {
            Text(modifier=Modifier.padding(vertical = MaterialTheme.shapes.sizes.labelPadding), text = errorLabel?:"")
        }},
        isError = isError,
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = MaterialTheme.colorScheme.onPrimary,
            unfocusedTextColor = MaterialTheme.colorScheme.onPrimary,
            focusedBorderColor = MaterialTheme.colorScheme.outline,
            errorBorderColor = MaterialTheme.colorScheme.error,
            errorContainerColor = MaterialTheme.colorScheme.errorContainer,
            unfocusedBorderColor = Color.Transparent,
            unfocusedContainerColor = MaterialTheme.colorScheme.onPrimaryContainer,
            focusedContainerColor = MaterialTheme.colorScheme.onPrimaryContainer,
//            disabledTextColor = MaterialTheme.colorScheme.secondaryContainer,
//            errorTextColor = MaterialTheme.colorScheme.error,
//            disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
//            errorContainerColor = MaterialTheme.colorScheme.secondaryContainer,
            cursorColor = MaterialTheme.colorScheme.outline,
            errorCursorColor = MaterialTheme.colorScheme.error,
            selectionColors = TextSelectionColors(
                handleColor = MaterialTheme.colorScheme.outline,
                backgroundColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.5f)
            ),
//            disabledIndicatorColor = MaterialTheme.colorScheme.secondaryContainer,
//            errorIndicatorColor = MaterialTheme.colorScheme.secondaryContainer,
//            focusedLeadingIconColor = MaterialTheme.colorScheme.secondaryContainer,
//            unfocusedLeadingIconColor = MaterialTheme.colorScheme.secondaryContainer,
//            disabledLeadingIconColor = MaterialTheme.colorScheme.secondaryContainer,
//            errorLeadingIconColor = MaterialTheme.colorScheme.secondaryContainer,
            focusedTrailingIconColor = MaterialTheme.colorScheme.outline,
            unfocusedTrailingIconColor = MaterialTheme.colorScheme.outline,
            disabledTrailingIconColor = MaterialTheme.colorScheme.outline,
            errorTrailingIconColor = MaterialTheme.colorScheme.outline,
            focusedLabelColor = MaterialTheme.colorScheme.outline,
            unfocusedLabelColor = MaterialTheme.colorScheme.outline,
//            disabledLabelColor = MaterialTheme.colorScheme.secondaryContainer
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        trailingIcon = {
            val image = if (passwordVisible.value) painterResource(id = R.drawable.eye_show)
            else painterResource(id = R.drawable.eye_hide)

            IconButton(modifier = Modifier
                .testTag("insert-field-pwd-img"), onClick = {passwordVisible.value = !passwordVisible.value}){
                Icon(image,"")
            }
        }
    )
}




@Preview
@Composable
fun TextPreview() {
    AppTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.horizontalGradient(
                    colorStops = arrayOf(
                        0.0f to MaterialTheme.colorScheme.background,  //MaterialTheme.colorScheme.background
                        0.5f to MaterialTheme.colorScheme.background,
                        1.0f to MaterialTheme.colorScheme.background   //MaterialTheme.colorScheme.background
                    )
                    )
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Title(text = "Title")
            Body(text = "this is a body text")
            InputField("", label = {Text("this is an input label") }) {}
            InputField("input text", label = {Text("this is an input label") }, isError = true) {}
            PasswordField("input text", label = {Text("this is a password label") }, isError = false) {}
        }
    }
}