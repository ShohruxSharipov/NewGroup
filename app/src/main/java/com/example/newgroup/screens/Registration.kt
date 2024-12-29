package com.example.newgroup.screens

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newgroup.R


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Registration() {
    var fullName: String by remember { mutableStateOf("") }
    var uName: String by remember { mutableStateOf("") }
    var course: Int by remember {
        mutableStateOf(1)
    }
    var faculty: String by remember { mutableStateOf("") }
    var isCourseOpen by remember {
        mutableStateOf(false)
    }
    var courses = listOf("Select course", "SOCIE", "SBL")
    var selectedCouse = courses[0]
    var password by remember { mutableStateOf("") }
    var openCode by remember {
        mutableStateOf(false)
    }
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF2F97E9))
    ) {
//        Image(
//            painter = painterResource(id = R.drawable.img_1),
//            contentDescription = "back",
//            modifier = Modifier.fillMaxSize()
//        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Image(
                painter = painterResource(id = R.drawable.img),
                contentDescription = "logo",
                modifier = Modifier.padding(24.dp)
            )
//            Text(text = "INHA University in Tashkent", fontSize = 25.sp, fontWeight = FontWeight.ExtraBold, color = Color.White, modifier = Modifier.fillMaxWidth().padding(24.dp), textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.height(20.dp))
            Card(
                modifier = Modifier.padding(15.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0x9FB7B8B9)),
                ) {
                Column(modifier = Modifier.padding(24.dp)) {
                    Text(
                        text = "Sign up",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 32.sp
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(text = "Create an account to continue !")

                    Spacer(modifier = Modifier.height(25.dp))

                    Text(text = "Full Name", fontSize = 20.sp)
                    OutlinedTextField(
                        value = fullName,
                        onValueChange = { fullName = it },
                        modifier = Modifier.fillMaxWidth(),
                        maxLines = 1,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                    )

                    Spacer(modifier = Modifier.height(25.dp))

                    Text(text = "User Name", fontSize = 20.sp)
                    OutlinedTextField(
                        value = uName,
                        onValueChange = { uName = it },
                        modifier = Modifier.fillMaxWidth(),
                        maxLines = 1,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                    )

                    Spacer(modifier = Modifier.height(25.dp))

                    Text(text = "Course", fontSize = 20.sp)
                    OutlinedTextField(
                        value = course.toString(),
                        onValueChange = { course = it.toInt() },
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )

                    Spacer(modifier = Modifier.height(25.dp))

                    Text(text = "Faculty", fontSize = 20.sp)
                    ExposedDropdownMenuBox(
                        expanded = isCourseOpen,
                        onExpandedChange = { isCourseOpen = !isCourseOpen }) {

                        OutlinedTextField(
                            value = selectedCouse,
                            onValueChange = {},
                            modifier = Modifier.fillMaxWidth(),
                            readOnly = true,
                            trailingIcon = {
                                ExposedDropdownMenuDefaults.TrailingIcon(expanded = isCourseOpen)
                            }
                        )
                        ExposedDropdownMenu(
                            expanded = isCourseOpen,
                            onDismissRequest = { isCourseOpen = false }) {
                            courses.forEach {
                                DropdownMenuItem(
                                    onClick = {
                                        selectedCouse = it
                                        isCourseOpen = false
                                    },
                                    text = { Text(text = it) })
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(25.dp))

                    Text(text = "Password", fontSize = 20.sp)
                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        modifier = Modifier.fillMaxWidth(),
                        visualTransformation = if (openCode) VisualTransformation.None else PasswordVisualTransformation(),
                        trailingIcon = {
                            val image = if (openCode) Icons.Default.Done else Icons.Default.Close
                            IconButton(onClick = { openCode = !openCode }) {
                                Icon(imageVector = image, contentDescription = "")
                            }
                        },
                        maxLines = 1,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                    )

                    Spacer(modifier = Modifier.height(25.dp))

                    Button(
                        shape = RoundedCornerShape(15.dp),
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = 12.dp,
                            pressedElevation = 8.dp,
                            disabledElevation = 10.dp,
                            hoveredElevation = 4.dp,
                            focusedElevation = 4.dp
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        onClick = {
                            Toast.makeText(context, "Not ready yet !", Toast.LENGTH_SHORT).show()
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
                    ) {
                        Text(text = "Register", fontSize = 24.sp)
                    }
                }
            }
        }

    }
}

@Preview(showSystemUi = true)
@Composable
fun preview() {
    Registration()
}