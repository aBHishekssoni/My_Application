package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android", modifier = Modifier.padding(innerPadding)
//                    )
                    newCarList()
//                    RatingCard()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!", modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}

@Composable
fun cardone(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(Color.White)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome to jetpack compose",
            style = MaterialTheme.typography.headlineLarge,
            textAlign = TextAlign.Center
        )
        Text(text = " july 2024")
        Text(text = " Abhishek Soni")
    }

}

@Preview
@Composable
private fun cardonePreview() {
    cardone()
}

@Composable
fun RatingCard(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
            Icon(imageVector = Icons.Default.Info, contentDescription = null,
                modifier = Modifier
                    .size(34.dp)
                    .padding(8.dp))
            Text(text = "Do you like this recommendation",
                fontWeight = FontWeight.Bold)
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "🤬", fontSize = 32.sp)
            Text(text = "😔",fontSize = 32.sp)
            Text(text = "😐",fontSize = 32.sp)
            Text(text = "😊",fontSize = 32.sp)
            Text(text = "😀",fontSize = 32.sp)
        }
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),horizontalArrangement = Arrangement.SpaceBetween){
            Text(text = "Very bad", fontWeight = FontWeight.Bold)
            Text(text = "Very good", fontWeight = FontWeight.Bold)

        }
    }
}
@Composable
fun Infocard(modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ){
        Row {
            Column (
                verticalArrangement =  Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .weight(1f)
                    .height(200.dp)
            ){
                Column {
                    Text(
                        text = "Superman",
                        style = MaterialTheme.typography.displaySmall,
                        fontWeight = FontWeight.ExtraBold
                    )
                    Text(
                        text ="Form kripton",
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.secondary
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    Text(
                        text ="Super strength with lesar power ",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.ExtraBold
                    )
                }
            }
            Image(painter = painterResource(id = R.drawable.superman), contentDescription = null,
                modifier = Modifier
                    .weight(1f)
                    .height(200.dp)
                    .drawBehind {
                        drawCircle(
                            color = Color.Black.copy(alpha = 0.4f),
                            radius = 400f
                        )
                        drawCircle(
                            color = Color.Black.copy(alpha = 0.2f),
                            radius = 300f
                        )
                    })
        }
    }
}
@Preview
@Composable
private fun InfocardPreview() {
    Infocard()
}

@Preview(showBackground = true)
@Composable
private fun RatingCardPreview() {
    RatingCard()
}
@Composable
fun TaskList(modifier: Modifier = Modifier) {
val myTask = listOf("DO laundry","wash dishes","wash dishes","wash dishes","DO laundry","wash dishes","wash dishes","wash dishes",
    "DO laundry","wash dishes","wash dishes","wash dishes",
    "DO laundry","wash dishes","wash dishes","wash dishes")
    LazyColumn {
        items(myTask){
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)

                ){
                Icon(imageVector = Icons.Default.Add, contentDescription = null )
                Text(text = it, style = MaterialTheme.typography.headlineSmall)
            }
        }
    }
}
@Preview(showSystemUi = true)
@Composable
private fun TaskListPreview() {
    TaskList()
}
@Composable
fun NewCar(modifier: Modifier=Modifier.fillMaxHeight()){
val myCar = listOf("supercar1","supercar2","supercar3","supercar4","supercar5","supercar6")
    LazyColumn {
        items(myCar){
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ){
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
                Text(text = it, style = MaterialTheme.typography.headlineSmall)
                Image(painter = painterResource(id = R.drawable.supercar1), contentDescription = null)

            }
        }
    }
}
@Composable
fun newCarList(modifier: Modifier = Modifier) {
    val myCar = listOf("supercar1","supercar2","supercar3","supercar4","supercar5","supercar6")
    val myImage = listOf(R.drawable.supercar1,R.drawable.supercar2,
        R.drawable.supercar3,R.drawable.supercar4,
        R.drawable.supercar5,R.drawable.supercar6)
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        itemsIndexed(myCar){
            index, item ->
    val imgScle = 1f
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.background
                ),
                modifier = Modifier
                    .padding(8.dp)
                    .width(300.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp
                ),
            ){
                Row (
                    verticalAlignment = Alignment.CenterVertically,

                ){
                    Image(painter = painterResource(id = myImage[index]), contentDescription = null,
                        modifier = Modifier
                            .size(300.dp)
                            .weight(1f)
                            .drawBehind {
                                drawCircle(
                                    color = Color.Blue.copy(alpha = 0.1f),
                                    radius = 400f
                                )
                                drawContext.transform.scale(
                                    scaleX = imgScle,
                                    scaleY = imgScle
                                )
                                drawContext.transform.translate(
                                    left = 0f,
                                    top = 100f
                                )
                                drawCircle(
                                    color = Color.Red.copy(alpha = 0.2f),
                                    radius = 300f
                                )
                                drawCircle(
                                        color = Color.Yellow.copy(alpha = 0.2f),
                                radius = 200f
                                )
                            }
                    )
                    Text(text = item, style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onBackground,
                        )
                }
            }
        }
    }

}
@Preview
@Composable
private fun newCarListPreview() {
    newCarList()
}
@Preview(showBackground = true)
@Composable
private fun NewCardPreview() {
    NewCar()
}