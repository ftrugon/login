import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState




@Composable
@Preview
fun App() {

    var text by remember { mutableStateOf("Login") }


    MaterialTheme{
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {


            OutlinedTextField(
                value = "",
                label = { Text("Usuario") },
                onValueChange = {}
            )

            OutlinedTextField(
                value = "",
                label = { Text("Contraseña") },
                onValueChange = {}
            )

            Button(onClick = {
                text = "Logeando!"
            }) {
                Text(text)
            }
        }
    }
}


fun main() = application {

    val windowState = rememberWindowState(size = DpSize(500.dp,500.dp))

    Window(
        onCloseRequest = ::exitApplication,
        title = "Achili pum",
        state = windowState

    ) {
        App()
    }
}
