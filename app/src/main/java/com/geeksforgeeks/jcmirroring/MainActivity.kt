package com.geeksforgeeks.jcmirroring

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.w3c.dom.Text

@Suppress("UNUSED_EXPRESSION")
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            // Creating a Simple Scaffold Layout for the application
            Scaffold(

                // Creating a Top Bar
                topBar = { TopAppBar(title = { Text("GFG | Mirroring", color = Color.White) }, backgroundColor = Color(0xff0f9d58)) },

                // Creating Content
                content = {

                    // Creating a Column Layout
                    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

                        var mMirror by remember { mutableStateOf(false)}

                        MText(bool = mMirror)

                        Spacer(modifier = Modifier.height(100.dp))

                        Button(onClick = {
                            mMirror = !mMirror
                        },
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0XFF0F9D58))
                        ) {
                            Text(text = "Click here", color = Color.White)
                        }

                    }
                }
            )
        }
    }
}

@Composable
fun MText(bool : Boolean) {
    return if(bool){
        Text(modifier = Modifier.scale(scaleX = -1f, scaleY = 1f), text = "GeeksForGeeks", fontSize = 30.sp)
    } else {
        Text(text = "GeeksForGeeks", fontSize = 30.sp)
    }
}
