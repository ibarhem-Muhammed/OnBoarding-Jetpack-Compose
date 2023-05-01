package com.example.ibrahim.onboarding

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.ibrahim.onboarding.ui.theme.OnBoardingTheme
import com.example.ibrahim.onboarding.ui.theme.Shapes

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BackScreen()
        }
    }
}

@Composable
fun BackScreen() {
    val mContext = LocalContext.current
  
    
    
    
    Box(
      Modifier.fillMaxSize(),
        Alignment.Center


    ) {

        Text(text = "Welcome in Second Activity", fontSize = 24.sp)
         

             
         }
        
        
        
    }

