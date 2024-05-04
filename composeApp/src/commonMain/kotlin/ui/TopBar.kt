package ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import sentifyandroid.composeapp.generated.resources.Res
import sentifyandroid.composeapp.generated.resources.logo

@Composable
fun TopBar(){
    Row(modifier = Modifier.fillMaxWidth().height(120.dp)){
        Image(
            painter = org.jetbrains.compose.resources.painterResource(resource = Res.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier.width(120.dp).height(120.dp)
        )

        Text(
            text = "Let's express your feelings!",
            fontSize = 80.sp,
            modifier = Modifier.padding(top = 10.dp)
        )
    }
}