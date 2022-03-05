package com.isaev.ripcurl

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.isaev.ripcurl.ui.theme.RipCurlTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RipCurlTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    ConstraintLayout {

                        val appBar = createRef()
                        val corpLogo = createRef()

                        TopAppBar(
                            title = {
                                Text(
                                    text = getString(R.string.about_app),
                                    textAlign = TextAlign.Center,
                                    fontSize = 24.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black
                                )
                            },
                            navigationIcon = {
                                IconButton(onClick = { }) {
                                    Icon(painter = painterResource(R.drawable.ic_back), contentDescription = null)
                                }
                            },
                            modifier = Modifier.constrainAs(appBar) {
                                top.linkTo(parent.top)
                            }
                        )

                        Image(
                            painter = painterResource(R.drawable.logo_corp),
                            contentDescription = null,
                            modifier = Modifier.constrainAs(corpLogo) {
                                top.linkTo(appBar.bottom, margin = 192.dp)
                                centerHorizontallyTo(parent)
                            }
                        )


                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RipCurlTheme {
        Greeting("Android")
    }
}
