package br.senai.jandira.sp.zero_wasteapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.jandira.sp.zero_wasteapplication.ui.theme.Zero_WasteApplicationTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Zero_WasteApplicationTheme {

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    HomeContent()
                }
            }
        }
    }
}

@Composable
fun HomeContent() {

    var menuVisibility by remember {
        mutableStateOf(false)
    }

//    Box(modifier = Modifier.blur(blurEffect)) {
    Image(
        painter = painterResource(id = R.drawable.ellipse_top_home),
        contentDescription = "",
        modifier = Modifier
            .padding(start = 215.dp)
            .blur(radius = blurEffect(menuVisibility)),
        alignment = Alignment.TopEnd
    )
    Image(
        painter = painterResource(id = R.drawable.ellipse_bottom_home),
        contentDescription = "",
        modifier = Modifier
            .padding(end = 260.dp)
            .blur(radius = blurEffect(menuVisibility)),
        alignment = Alignment.BottomStart
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .blur(blurEffect(menuVisibility))
    ) {
        Image(
            painter = painterResource(id = R.drawable.borgor),
            contentDescription = "",
            modifier = Modifier
                .size(50.dp)
                .padding(start = 15.dp, top = 15.dp)
                .clickable {
                    menuVisibility = !menuVisibility
                }
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.app_logo),
                contentDescription = "App Logo",
                modifier = Modifier
                    .size(65.dp)
                    .blur(radius = 100.dp, edgeTreatment = BlurredEdgeTreatment.Unbounded)
            )
            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color(8, 113, 19))) {
                        append("Zero")
                    }
                    append(' ')
                    withStyle(style = SpanStyle(color = Color.Black)) {
                        append("Waste")
                    }
                }, fontSize = 26.sp, fontWeight = FontWeight.Bold
            )
        }
        Image(
            painter = painterResource(id = R.drawable.lata_melhor),
            contentDescription = "",
            modifier = Modifier.size(380.dp),
            alignment = Alignment.Center
        )
        Text(
            text = stringResource(id = R.string.lorem_ipsum),
            textAlign = TextAlign.Center,
            fontSize = 16.sp
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { /*TODO*/ },
                border = BorderStroke(2.dp, color = Color.White),
                modifier = Modifier.padding(start = 25.dp, top = 20.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(8, 113, 19))
            ) {
                Text(
                    text = stringResource(id = R.string.learn_more),
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            }
        }
    }
    AnimatedVisibility(visible = menuVisibility,
        enter = slideInHorizontally(animationSpec = tween(500)) { fullWidth -> -fullWidth } + fadeIn(
            animationSpec = tween(durationMillis = 200)
        ),
        exit = slideOut(tween(100, easing = FastOutSlowInEasing)) {
            IntOffset(-180, 0)
        } + fadeOut(animationSpec = tween(durationMillis = 200))
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(end = 100.dp),
            backgroundColor = Color.White

        ) {
            Image(painter = painterResource(id = R.drawable.back_arrow), contentDescription = "Voltar", modifier = Modifier.size(1.dp).clickable { menuVisibility = !menuVisibility })
        }
    }
//    }
}

fun blurEffect(menuVisibility: Boolean): Dp {
    return if (menuVisibility) {
        10.dp
    } else {
        0.dp
    }
}