package com.dvnative.trailify.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dvnative.trailify.ui.tokens.sizes

@Composable
fun LinksView(openWebview: MutableState<Boolean>) {
    Column (Modifier
        .fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier.fillMaxWidth(0.05f))
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = MaterialTheme.shapes.sizes.screenHorizontalPadding),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            PrimaryLinkButton(
                onClick = {
                    openWebview.value = true
                }, text = "Forgot Password?",
                modifier = Modifier.padding(MaterialTheme.shapes.sizes.labelPadding),
                enabled = true
            )
        }
        Spacer(
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .padding(horizontal = MaterialTheme.shapes.sizes.screenHorizontalPadding)
                .background(MaterialTheme.colorScheme.outline)
        )
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = MaterialTheme.shapes.sizes.screenHorizontalPadding),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Body(text = "You don't have an account?")
            Body(text = " ")
            PrimaryActiveLinkButton(
                onClick = {
                    openWebview.value = true
                }, text = "Sign up",
                enabled = true
            )
        }
        Row (
            Modifier
                .fillMaxHeight(0.3f)
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            SecondaryLinkButton(
                onClick = {
                    openWebview.value = true
                }, text = "Privacy & Policy",
                modifier = Modifier.padding(MaterialTheme.shapes.sizes.labelPadding),
                enabled = true
            )
        }
    }

}

@Composable
@Preview
fun linksPreview() {
    val open = remember {
        mutableStateOf(true)
    }
    LinksView(openWebview = open)
}