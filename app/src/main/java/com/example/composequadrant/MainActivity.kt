package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ComposeQuadrants()
                }
            }
        }
    }
}


@Composable
fun Singleton(header: String, body: String, color: Int, modifier: Modifier=Modifier){
    Column(
        verticalArrangement=Arrangement.Center,
        horizontalAlignment=Alignment.CenterHorizontally,
        modifier=modifier.fillMaxSize().background(colorResource(color)).padding(16.dp)
    ) {
        Text(
            text = header,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = body,
            textAlign = TextAlign.Justify,
        )
    }
}


@Composable
fun Quadrants(header1: Int, header2: Int, body1: Int, body2: Int, color1: Int, color2: Int,
              modifier: Modifier=Modifier){
    Row(modifier.fillMaxSize()) {
        Singleton(stringResource(header1), stringResource(body1), color1, modifier)
        Singleton(stringResource(header2), stringResource(body2), color2, modifier)
    }
}


@Composable
fun ComposeQuadrants(modifier: Modifier = Modifier) {
    Column(
        Modifier.fillMaxWidth()
    ) {

        Quadrants(
            R.string.text_c_head, R.string.image_c_head, R.string.text_c_body,
            R.string.image_c_body, R.color.teal_200, R.color.purple_500, modifier.weight(1F)
        )
        Quadrants(
            R.string.row_c_head, R.string.column_c_head, R.string.row_c_body,
            R.string.column_c_body, R.color.purple_700, R.color.teal_500, modifier.weight(1F)
        )
    }
}


@Preview(showBackground = false)
@Composable
fun ComposeQuadrantsPreview() {
    ComposeQuadrantTheme {
            ComposeQuadrants()
    }
}
