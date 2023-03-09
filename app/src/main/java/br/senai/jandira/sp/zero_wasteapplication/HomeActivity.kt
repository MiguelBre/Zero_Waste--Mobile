package br.senai.jandira.sp.zero_wasteapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
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
    Column(modifier = Modifier.fillMaxSize()) {
        Button(onClick = { /*TODO*/ }) {
            Image(painter = painterResource(id = R.drawable.borgor), contentDescription = "")
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