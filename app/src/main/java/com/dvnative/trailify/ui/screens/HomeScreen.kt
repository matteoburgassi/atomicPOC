package com.dvnative.trailify.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dvnative.trailify.R
import com.dvnative.trailify.ui.components.Body
import com.dvnative.trailify.ui.components.Caption
import com.dvnative.trailify.ui.components.PrimaryActiveButton
import com.dvnative.trailify.ui.components.PrimaryOutlineActiveButton
import com.dvnative.trailify.ui.components.PrimaryOutlineButton
import com.dvnative.trailify.ui.components.SecondaryBody
import com.dvnative.trailify.ui.components.Title
import com.dvnative.trailify.ui.theme.AppTheme
import com.dvnative.trailify.ui.theme.extraValues
import com.dvnative.trailify.viewmodel.MainViewModel
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun HomeScreen(viewModel: MainViewModel?) {
    AppTheme {
        Scaffold {paddingValues ->
            Column(
                modifier = Modifier
                    .background(MaterialTheme.extraValues.backgroundGradient)
                    .fillMaxSize()
                    .padding(paddingValues = paddingValues)
                    .padding(MaterialTheme.extraValues.sizes.containerHorizontalPadding),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Card(modifier = Modifier
                    .fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.onBackground,
                ),elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp
                )){
                    Column {
                        MiniPlayerView()
                        Column (
                            modifier = Modifier
                                .padding(MaterialTheme.extraValues.sizes.containerHorizontalPadding)
                        ){
                            Title(text = "Dune: Part Two")
                            Body(modifier = Modifier.alpha(0.7f), text = "Dune, deuxième partie est un film de science-fiction américano-canadien réalisé par Denis Villeneuve et dont la sortie en prévue en 2024.")
                            Spacer(modifier = Modifier.height(16.dp))
                            SecondaryBody(modifier = Modifier.alpha(0.7f), text = "Distribution")
                            Caption(
                                modifier = Modifier.alpha(0.7f),
                                text= "Directeur: Denis Villeneuve - Scénario: Denis Villeneuve, Jon Spaihts, Frank Herbert - Acteurs: Timothée Chalamet, Zendaya, Rebecca Ferguson"
                            )
                            Spacer(Modifier.height(40.dp))
                            Row(horizontalArrangement = Arrangement.SpaceEvenly){
                                Column(modifier = Modifier.weight(1f)) {
                                    PrimaryActiveButton(onClick = {}, text = "PLAY", enabled = true)
                                }
                                Spacer(modifier = Modifier.width(30.dp))
                                Column(modifier = Modifier.weight(1f)) {
                                    PrimaryOutlineActiveButton(onClick = {}, text = "SHARE")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MiniPlayerView() {
    Image(modifier = Modifier
        .fillMaxWidth()
        .aspectRatio(372f / 250f), painter = painterResource(id = R.drawable.mini_player), contentDescription = "mini player")
}

@Composable
@Preview
fun HomePreview() {
    HomeScreen(viewModel = null)
}
