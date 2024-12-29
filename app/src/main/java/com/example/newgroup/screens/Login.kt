package com.example.newgroup.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newgroup.R


@Composable
fun Login(){
    var uName: String by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var openCode by remember {
        mutableStateOf(false)
    }
    val context = LocalContext.current
    Box(modifier = Modifier.fillMaxSize()){
        Column {
            Spacer(modifier = Modifier.height(40.dp))
            Image(
                painter = painterResource(id = R.drawable.img),
                contentDescription = "logo",
                modifier = Modifier.padding(24.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Row(modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically) {
                Card(
                    modifier = Modifier.padding(15.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0x9FB7B8B9)),
                ) {
                    Column(modifier = Modifier.padding(24.dp)) {
                        Text(
                            text = "Sign in",
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 32.sp
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(text = "Fill the gaps to continue !")

                        Spacer(modifier = Modifier.height(25.dp))

                        Text(text = "Username", fontSize = 20.sp)
                        OutlinedTextField(
                            value = uName,
                            onValueChange = { uName = it },
                            modifier = Modifier.fillMaxWidth(),
                            maxLines = 1,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                        )
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
                            Text(text = "Login", fontSize = 24.sp)
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun prevLogin(){
    Login()
}