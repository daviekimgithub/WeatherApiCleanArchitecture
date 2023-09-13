package com.example.weatherapp.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi

@OptIn(ExperimentalCoilApi::class)
@Composable
fun WeatherCard(
    cardData: WeatherCardDataClass
) {
        val painter = painterResource(id = cardData.image)
        Surface(
        shape = RoundedCornerShape(16.dp),
        color = Color(0xFFDAE1E7),
        modifier = Modifier
            .padding(10.dp),
        shadowElevation = 10.dp
    ) {
        Column(

            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(){
                Image(
                    modifier = Modifier
                        .height(50.dp)
                        .width(50.dp),
                    painter = painter,
                    contentDescription = cardData.description,
                    contentScale = ContentScale.Crop
                )
            }
            Text(
                text = cardData.text,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                text = cardData.description,
                style = TextStyle(
                    fontSize = 16.sp,
                )
            )
        }

    }
}