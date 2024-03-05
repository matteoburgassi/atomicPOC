package com.dvnative.trailify.ui.widgets

import androidx.compose.foundation.background
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.dvnative.trailify.ui.components.Title
import com.dvnative.trailify.ui.components.backgroundGradient
import com.dvnative.trailify.ui.theme.extraColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrganismsTopAppBar() {
        TopAppBar(
            modifier = Modifier.background(MaterialTheme.extraColors.backgroundGradient),
            title = { Title(text = "SemicolonSpace") },
            colors = TopAppBarDefaults.topAppBarColors(
                titleContentColor = MaterialTheme.colorScheme.onPrimary,
                containerColor = Color.Transparent
            )
        )
}