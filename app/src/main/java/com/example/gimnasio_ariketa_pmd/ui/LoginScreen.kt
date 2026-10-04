package com.example.gimnasio_ariketa_pmd.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gimnasio_ariketa_pmd.ui.data.GimnasioRepository

/*
 * Pantalla de inicio de sesión.
 */
@androidx.compose.runtime.Composable
fun LoginScreen(
    navController: NavController
) {

    /*
     * Usuario que escribe el usuario.
     *
     * remember permite que Compose recuerde el valor.
     */
    var erabiltzailea by remember {
        mutableStateOf("")
    }

    /*
     * Contraseña.
     */
    var pasahitza by remember {
        mutableStateOf("")
    }

    /*
     * Mensaje de error.
     *
     * Puede ser null cuando no hay ningún error.
     */
    var errorea by remember {
        mutableStateOf<String?>(null)
    }


    /*
     * Column coloca los elementos verticalmente.
     */
    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),

        verticalArrangement = Arrangement.Center

    ) {

        /*
         * Título.
         */
        Text(
            text = "Txurdiko Gimnasioa",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(30.dp)
        )


        /*
         * Campo para escribir el usuario.
         */
        OutlinedTextField(

            value = erabiltzailea,

            onValueChange = {
                erabiltzailea = it
            },

            label = {
                Text("Erabiltzailea")
            },

            modifier = Modifier.fillMaxWidth()
        )


        Spacer(
            modifier = Modifier.height(15.dp)
        )


        /*
         * Campo de contraseña.
         */
        OutlinedTextField(

            value = pasahitza,

            onValueChange = {
                pasahitza = it
            },

            label = {
                Text("Pasahitza")
            },

            modifier = Modifier.fillMaxWidth()
        )


        Spacer(
            modifier = Modifier.height(20.dp)
        )


        /*
         * Botón para iniciar sesión.
         */
        Button(

            onClick = {

                /*
                 * Primero comprobamos que no estén vacíos
                 * los campos.
                 */
                if (
                    erabiltzailea.isBlank() ||
                    pasahitza.isBlank()
                ) {

                    errorea = "Datu guztiak bete behar dira"

                } else {

                    /*
                     * Intentamos hacer login.
                     */
                    val rol = GimnasioRepository.login(
                        erabiltzailea,
                        pasahitza
                    )

                    /*
                     * Si el login es correcto...
                     */
                    if (rol != null) {

                        /*
                         * Vamos a Home.
                         *
                         * Pasamos también el rol.
                         */
                        navController.navigate(
                            "home/$rol"
                        )

                    } else {

                        /*
                         * Si no existe el usuario,
                         * mostramos error.
                         */
                        errorea =
                            "Erabiltzailea edo pasahitza okerra da"
                    }
                }
            },

            modifier = Modifier.fillMaxWidth()

        ) {

            Text("SAIOA HASI")

        }


        /*
         * Mostramos el error solamente si existe.
         */
        if (errorea != null) {

            Spacer(
                modifier = Modifier.height(15.dp)
            )

            Text(
                text = errorea!!,
                color = MaterialTheme.colorScheme.error
            )
        }
    }
}