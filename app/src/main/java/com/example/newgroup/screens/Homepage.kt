package com.example.newgroup.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newgroup.R
import com.google.accompanist.pager.HorizontalPager

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Homepage() {
    var query by remember{
        mutableStateOf("")
    }
    var isSearching by remember {
        mutableStateOf(false)
    }
    val pagerState = com.google.accompanist.pager.rememberPagerState()
    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column {
                    Text(text = "Hello Student !", fontSize = 25.sp, fontWeight = FontWeight.Bold)
                    Text(
                        text = "What you want to learn today ?",
                        fontSize = 15.sp,
                        fontStyle = FontStyle.Italic
                    )
                }
                Card(shape = CircleShape) {
                    Image(
                        painter = painterResource(id = R.drawable.person),
                        contentDescription = "",
                        modifier = Modifier
                            .size(50.dp)
                            .background(
                                Color(0x0187fff)
                            )
                            .padding(3.dp),
                    )
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            SearchBar(
                query = query,
                onQueryChange = { query = it},
                onSearch = {isSearching = true},
                active = isSearching,
                onActiveChange = {isSearching = !isSearching},
                placeholder = {
                    Text(
                        text = "Search"
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = ""
                    )
                },
                trailingIcon = {
                    if (query.isNotEmpty()) {
                        IconButton(onClick = { query = "" }) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Clear Search"
                            )
                        }
                    }
                },
                colors = SearchBarDefaults.colors(
                    containerColor = Color(0xFFF1F1F1),
                )) {}
            Spacer(modifier = Modifier.height(16.dp))
            HorizontalPager(
                state = pagerState,
                count = 2,
                modifier = Modifier,
                contentPadding = PaddingValues(end = 20.dp), // Padding to show adjacent pages
                itemSpacing = 10.dp
            ) {
                Card(
                    modifier = Modifier
                        .height(200.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp)),
                    colors = when (it) {
                        0 -> CardDefaults.cardColors(containerColor = Color.Blue)
                        1 -> CardDefaults.cardColors(containerColor = Color.Red)
                        else -> {
                            CardDefaults.cardColors(containerColor = Color.Blue)
                        }
                    }
                ) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        when (it) {
                            0 -> {
                                Text(text = "Bekzod", color = Color.White)
                            }

                            1 -> {
                                Text(text = "Shohruh", color = Color.White)
                            }

                            else -> {
                                Text(text = "Page $it", color = Color.White)
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            LazyRow {
                items(5) {
                    Card(
                        modifier = Modifier
                            .size(130.dp)
                            .padding(5.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.sarvar),
                            contentDescription = "",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            LazyColumn {
                items(5) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp)
                            .padding(vertical = 10.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Image(painter = painterResource(id = R.drawable.calculus), contentDescription = "", modifier = Modifier.fillMaxHeight(), contentScale = ContentScale.Crop)
                            Spacer(modifier = Modifier.width(20.dp))
                            Column(verticalArrangement = Arrangement.SpaceAround, modifier = Modifier.fillMaxHeight()) {
                                Text(text = "Calculus", fontSize = 32.sp, fontWeight = FontWeight.Bold, fontFamily = FontFamily.Monospace)
                                Text(text = "Steftcho Dokov", fontStyle = FontStyle.Italic)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun prevHomepage() {
    Homepage()
}