package com.example.ibrahim.onboarding

import android.content.Context
import android.content.Intent
import androidx.compose.animation.AnimatedContentScope.SlideDirection.Companion.Start
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*


import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.VerticalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch
import kotlin.text.Typography


@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingScreen(
) {
    val items = OnBoardingItems.getData()
    val pageState = rememberPagerState()
    val scope = rememberCoroutineScope()
    Column(
        modifier = Modifier.fillMaxSize()


    ) {

        Spacer(modifier = Modifier.height(51.dp))
        HorizontalPager(
            count = items.size,
            state = pageState,
            modifier = Modifier
                .fillMaxHeight(0.9f)
                .fillMaxWidth()
                .weight(2f)


        ) { page ->

            OnBoardingItem(items = items[page])


        }// end horizontal pager

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 60.dp)
                .weight(1f)

        ) {
            Indicators(size = items.size, index = pageState.currentPage)

        }

        BottomSection() {
            if (pageState.currentPage + 1 < items.size) scope.launch {
                pageState.scrollToPage(pageState.currentPage + 1)
            }
        }

    } // end column


}// end fun

@Composable
fun OnBoardingItem(items: OnBoardingItems) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = items.title,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            letterSpacing = 1.sp,
            lineHeight = 30.sp,


            )
        Spacer(modifier = Modifier.height(50.dp))
        Image(
            painter = painterResource(id = items.image),
            contentDescription = "Image1",
            modifier = Modifier.fillMaxSize()
        )

    }
}

@Composable
fun BottomSection(onButtonClick: () -> Unit = {}, onSkipClicked: () -> Unit) {
    val mContext = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 33.dp)


    ) {
        ClickableText(
            onClick = {  mContext.startActivity(Intent(mContext, SecondActivity::class.java)) },
            text = AnnotatedString("Skip"),
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 25.dp, bottom = 10.dp),


            )


        Button(
            onClick = { mContext.startActivity(Intent(mContext, SecondActivity::class.java)) },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFFFD8700)
            ),
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .wrapContentWidth()
                .padding(end = 25.dp, bottom = 10.dp),
            shape = RoundedCornerShape(20.dp)

        ) {
            Text(text = "Get Started", color = Color.White)
        }
    }
}


@Composable
fun BoxScope.Indicators(size: Int, index: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier
            .align(Alignment.CenterStart)
            .padding(start = 15.dp)
    ) {
        repeat(size) {
            Indicator(isSelected = it == index)
        }
    }
}

@Composable
fun Indicator(isSelected: Boolean) {
    val width = animateDpAsState(
        targetValue = if (isSelected) 25.dp else 10.dp,
        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy)
    )

    Box(
        modifier = Modifier
            .height(9.dp)
            .width(width.value)
            .clip(CircleShape)
            .background(
                color = if (isSelected) Color(0xFFFD8700) else Color(0xDDD4D4D4)
            )
    ) {

    }
}





    
    
    
    
    
    
    
    
    

