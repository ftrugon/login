import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState




@Composable
@Preview
fun App() {
    var user by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val buttonEnabled = user.isNotBlank() && password.isNotBlank()

    MaterialTheme{
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp, alignment = Alignment.CenterVertically)
        ) {


            usuario(user){
                user = it
            }

            contrasenia(password){
                password = it
            }

            botoncito(buttonEnabled){
                user = ""
                password = ""
            }
        }
    }
}

@Composable
fun usuario(
    user:String,
    onTeclearUsuario: (String) -> Unit
){
    OutlinedTextField(
        value = user,
        label = { Text("Usuario") },
        onValueChange = onTeclearUsuario
    )
}

@Composable
fun contrasenia(
    password:String,
    onTeclearContrasenia: (String) -> Unit
){
    var pasVisible by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = password,
        label = { Text("Contraseña") },
        onValueChange = onTeclearContrasenia,
        visualTransformation = if (pasVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = { iconito(pasVisible){pasVisible = it} }
    )
}

@Composable
fun iconito(pasVisible:Boolean,tal: (Boolean) -> Unit){
    IconToggleButton(
        checked = pasVisible,
        onCheckedChange = tal
    ){
        Icon(
            imageVector = if (pasVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility,
            contentDescription = null
        )
    }
}

@Composable
fun botoncito(
    buttonEnabled:Boolean,
    onCambio: () -> Unit,
    ){

    Button(
        onClick = onCambio,
        enabled = buttonEnabled
    ) {
        Text("Login")
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
