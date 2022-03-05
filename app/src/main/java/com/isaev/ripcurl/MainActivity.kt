package com.isaev.ripcurl

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
                window.statusBarColor = MaterialTheme.colors.primary.toArgb()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ConstraintLayout {

                        val appBarTitle = createRef()
                        val backButton = createRef()
                        val corpLogo = createRef()
                        val underLogoText = createRef()
                        val bottomText = createRef()

                        Text(
                            text = getString(R.string.about_app),
                            textAlign = TextAlign.Center,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            modifier = Modifier.constrainAs(appBarTitle) {
                                top.linkTo(parent.top, margin = 60.dp)
                                centerHorizontallyTo(parent)
                            }
                        )

                        IconButton(
                            onClick = { },
                            modifier = Modifier.constrainAs(backButton) {
                                start.linkTo(parent.start, margin = 16.dp)
                                top.linkTo(parent.top, margin = 56.dp)
                            }
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.ic_back),
                                contentDescription = null,
                                tint = Color.Unspecified,
                            )
                        }

                        Image(
                            painter = painterResource(R.drawable.logo_corp),
                            contentDescription = null,
                            modifier = Modifier.constrainAs(corpLogo) {
                                top.linkTo(appBarTitle.bottom, margin = 192.dp)
                                centerHorizontallyTo(parent)
                            }
                        )

                        Text(
                            text = stringResource(R.string.under_logo_text),
                            textAlign = TextAlign.Center,
                            fontSize = 16.sp,
                            color = Color.Black,
                            modifier = Modifier.constrainAs(underLogoText) {
                                top.linkTo(corpLogo.bottom, margin = 36.dp)
                                centerHorizontallyTo(parent)
                            }
                        )

                        Text(
                            text = stringResource(R.string.bottom_text),
                            textAlign = TextAlign.Center,
                            fontSize = 16.sp,
                            color = Color.LightGray,
                            modifier = Modifier.constrainAs(bottomText) {
                                bottom.linkTo(parent.bottom, margin = 60.dp)
                                centerHorizontallyTo(parent)
                            }
                        )
                    }
                }
            }
        }
    }
}
