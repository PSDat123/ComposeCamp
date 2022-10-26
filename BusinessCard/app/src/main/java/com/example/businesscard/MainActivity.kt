package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.ui.graphics.vector.ImageVector

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCard(
                        stringResource(R.string.business_name),
                        stringResource(R.string.business_title),
                        stringResource(R.string.business_phone),
                        stringResource(R.string.business_social),
                        stringResource(R.string.business_email)
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCard(name: String, title: String, phone: String, social: String, email: String) {
    val image = painterResource(id = R.drawable.qiqi)
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF073042))
            .padding(bottom = 100.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = image,
            contentDescription = "Avatar",
            modifier = Modifier
                .size(150.dp),
            contentScale = ContentScale.Fit)
        Text(
            text = name,
            fontSize = 44.sp,
            fontWeight = FontWeight.Medium,
            color = Color.LightGray,
            modifier = Modifier.padding(top = 10.dp)
        )
        Text(
            text = title,
            fontSize = 22.sp,
            color = Color(0xFF31cc46),
            modifier = Modifier.padding(top = 10.dp),
            fontWeight = FontWeight.Bold
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 50.dp),
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Bottom,
    ) {
        ContactInfo(phone, Icons.Filled.Call)
        ContactInfo(social, Icons.Filled.Share)
        ContactInfo(email, Icons.Filled.Email)
    }
}

@Composable
fun ContactInfo(content: String, icon: ImageVector){
    Divider(color = Color.LightGray, thickness = 2.dp)
    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(top = 10.dp, bottom = 10.dp, end = 40.dp, start = 70.dp)
    ) {
        Icon(icon, contentDescription = null, tint = Color(0xFF31cc46))
        Spacer(Modifier.weight(1f))
        Text(
            text = content,
            color = Color.LightGray,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold
        )
    }

}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard(
            stringResource(R.string.business_name),
            stringResource(R.string.business_title),
            stringResource(R.string.business_phone),
            stringResource(R.string.business_social),
            stringResource(R.string.business_email)
        )
    }
}