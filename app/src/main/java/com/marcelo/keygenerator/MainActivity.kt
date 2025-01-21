package com.marcelo.keygenerator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ContentCopy
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.marcelo.keygenerator.ui.theme.Gray100
import com.marcelo.keygenerator.ui.theme.Gray700
import com.marcelo.keygenerator.ui.theme.Gray900
import com.marcelo.keygenerator.ui.theme.Teal700
import com.marcelo.keygenerator.ui.theme.White

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Home()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home() {
    var password by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Key Generator")
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Gray100
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(White)
                .padding(paddingValues),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = password,
                    onValueChange = { itPassword ->
                        password = itPassword
                    },
                    label = {
                        Text(text = "Password")
                    },
                    modifier = Modifier
                        .width(250.dp),
                    maxLines = 1,
                    textStyle = TextStyle(
                        color = Gray900,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Gray100,
                        unfocusedContainerColor = Gray100,
                        focusedTextColor = Gray100,
                        focusedIndicatorColor = Gray700,
                        focusedLabelColor = Gray700

                    )
                )
                IconButton(
                    onClick = {

                    },
                    modifier = Modifier
                        .size(50.dp)
                        .background(
                            color = Teal700,
                            shape = RoundedCornerShape(15.dp)
                        )
                ) {
                    Icon(
                        imageVector = Icons.Rounded.ContentCopy,
                        contentDescription = "ContentCopy",
                        tint = White
                    )
                }

                IconButton(
                    onClick = {

                    },
                    modifier = Modifier
                        .size(50.dp)
                        .border(
                            width = 1.dp,
                            color = Gray900,
                            shape = RoundedCornerShape(15.dp)
                        )
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Refresh,
                        contentDescription = "Refresh",
                        tint = Gray900
                    )

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomePreview() {
    Home()
}