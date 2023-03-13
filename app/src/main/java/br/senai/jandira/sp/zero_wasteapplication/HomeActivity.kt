package br.senai.jandira.sp.zero_wasteapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
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
                    modifier = Modifier.fillMaxSize(),
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
    Image(
        painter = painterResource(id = R.drawable.ellipse_top_home),
        contentDescription = "",
        modifier = Modifier.padding(start = 215.dp),
        alignment = Alignment.TopEnd
    )
    Image(
        painter = painterResource(id = R.drawable.ellipse_bottom_home),
        contentDescription = "",
        modifier = Modifier.padding(end = 260.dp),
        alignment = Alignment.BottomStart
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.borgor),
            contentDescription = "",
            modifier = Modifier
                .size(35.dp)
                .padding(start = 10.dp, top = 10.dp)
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
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
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
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview2() {
    Zero_WasteApplicationTheme {
        HomeContent()
    }
}