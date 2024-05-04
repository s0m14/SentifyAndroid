package ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import data.AppealData

class AppealScreen : Screen {

    private lateinit var navigator: Navigator

    @Composable
    override fun Content() {
        HomeScreen().Content()
        AppealScreen()
    }

    @Composable
    fun AppealScreen() {

        navigator = LocalNavigator.currentOrThrow

        var subjectOfAppeal by remember { mutableStateOf("") }
        var detailedExpalanation by remember { mutableStateOf("") }
        var desiredOutcomes by remember { mutableStateOf("") }
        var yourName by remember { mutableStateOf("") }
        var urgency by remember{ mutableStateOf("") }

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()
        ) {

            OutlinedTextField(
                value = subjectOfAppeal,
                onValueChange = { subjectOfAppeal = it },
                label = { Text(text = "Subject of appeal", fontSize = 20.sp) },
                modifier = Modifier.width(1200.dp).padding(top = 120.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = detailedExpalanation,
                onValueChange = { detailedExpalanation = it },
                label = { Text(text = "Details", fontSize = 20.sp) },
                modifier = Modifier.width(1200.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = desiredOutcomes,
                onValueChange = { desiredOutcomes = it },
                label = { Text(text = "What outcome are you hoping for", fontSize = 20.sp) },
                modifier = Modifier.width(1200.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = yourName,
                onValueChange = { yourName = it },
                label = { Text(text = "Your name", fontSize = 20.sp) },
                modifier = Modifier.width(1200.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = urgency,
                onValueChange = { urgency = it },
                label = { Text(text = "How urgent is your appeal?", fontSize = 20.sp) },
                modifier = Modifier.width(1200.dp)
            )
            Button(
                onClick = {
                    navigator.push(
                        AppealResultScreen(
                            AppealData(subjectOfAppeal,detailedExpalanation,desiredOutcomes,yourName, urgency)
                        )
                    )
                },
                modifier = Modifier.width(200.dp).height(100.dp).padding(top = 60.dp).background(
                    Color.Transparent
                )
            ) {
                Text(
                    text = "Submit"
                )
            }
        }
    }
}