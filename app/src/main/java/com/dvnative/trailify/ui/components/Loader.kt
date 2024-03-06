package com.dvnative.trailify.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dvnative.trailify.ui.theme.AppTheme
import com.dvnative.trailify.ui.theme.extraValues

@Composable
fun Loader() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        CircularProgressIndicator(trackColor = MaterialTheme.extraValues.disabledContainer, color = MaterialTheme.colorScheme.onPrimary, strokeCap  = StrokeCap.Round, strokeWidth = 5.dp)
    }
}

@Composable
@Preview
fun LoaderPreview() {
    AppTheme {
            Loader()
    }
}