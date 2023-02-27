package br.senai.jandira.sp.zero_wasteapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.jandira.sp.zero_wasteapplication.ui.theme.Zero_WasteApplicationTheme

class LogInActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Zero_WasteApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    LogInActivityBody()
                }
            }
        }
    }
}

@Preview
@Composable
fun LogInActivityBody() {

    var recicladorClick by remember {
        mutableStateOf(true)
    }

    var catadorClick by remember {
        mutableStateOf(false)
    }

    var color1 by remember {
        mutableStateOf(Color(128, 204, 40))
    }
    var color2 by remember {
        mutableStateOf(Color.Transparent)
    }

    Column() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, bottom = 7.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.app_logo),
                contentDescription = "App Logo",
                modifier = Modifier
                    .size(96.dp)
                    .padding(end = 13.dp)
            )
            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.Black)) {
                        append("Zero")
                    }
                    append(' ')
                    withStyle(style = SpanStyle(color = Color(8, 113, 19))) {
                        append("Waste")
                    }
                }, fontSize = 36.sp, fontWeight = FontWeight.Bold
            )
        }
        Card(
            modifier = Modifier
                .height(450.dp)
                .padding(start = 25.dp, end = 25.dp),
            shape = RoundedCornerShape(20.dp),
            backgroundColor = Color(8, 113, 19)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Row(
                    modifier = Modifier.background(
                        color = Color.White, shape = RoundedCornerShape(7.dp)
                    ), verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = stringResource(id = R.string.recycler),
                        modifier = Modifier
                            .background(
                                color1,
                                shape = RoundedCornerShape(topStart = 7.dp, bottomStart = 7.dp)
                            )
                            .clickable {
                                recicladorClick = true
                                catadorClick = false
                                color1 = Color(128, 204, 40)
                                color2 = Color.Transparent
                            }
                            .padding(
                                top = 15.dp, bottom = 15.dp
                            )
                            .width(130.dp),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center)
                    Text(text = stringResource(id = R.string.catador),
                        modifier = Modifier
                            .background(
                                color2, shape = RoundedCornerShape(topEnd = 7.dp, bottomEnd = 7.dp)
                            )
                            .clickable {
                                recicladorClick = false
                                catadorClick = true
                                color2 = Color(128, 204, 40)
                                color1 = Color.Transparent
                            }
                            .padding(
                                top = 15.dp,
                                bottom = 15.dp,
                            )
                            .width(130.dp),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center)
                }
            }
            Text(
                text = stringResource(id = R.string.welcome_message),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, bottom = 20.dp),
                fontSize = 18.sp,
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview3() {
    Zero_WasteApplicationTheme {
        LogInActivityBody()
    }
}