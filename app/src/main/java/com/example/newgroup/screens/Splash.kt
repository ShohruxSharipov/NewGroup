package com.example.newgroup.screens

import android.annotation.SuppressLint
import android.widget.Space
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newgroup.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Splash() {
    Scaffold() {
        Box(modifier= Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.calculus),
                contentDescription = "calc",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .border(2.dp, Color.Black)
            )
            Column {

                Spacer(modifier = Modifier.height(120.dp))
                Column (modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally){
                    Card(
                        modifier = Modifier.size(150.dp),
                        shape = CircleShape,
                        border = BorderStroke(2.dp, Color.Black)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.dokov),
                            contentDescription = "dokov",
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun prevSplash() {
    Splash()
}