package com.example.gimnasio_ariketa_pmd

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.gimnasio_ariketa_pmd.ui.AppNavigation

/*
 * MainActivity es la actividad principal de Android.
 */
class MainActivity : ComponentActivity() {

    override fun onCreate(
        savedInstanceState: Bundle?
    ) {

        /*
         * Llamamos al constructor de la clase padre.
         */
        super.onCreate(savedInstanceState)


        /*
         * setContent permite utilizar Jetpack Compose
         * para construir la interfaz.
         */
        setContent {

            /*
             * MaterialTheme proporciona los estilos
             * básicos de Material Design.
             */
            MaterialTheme {

                /*
                 * Surface es el contenedor principal.
                 */
                Surface {

                    /*
                     * Aquí arrancamos nuestro sistema
                     * de navegación.
                     */
                    AppNavigation()
                }
            }
        }
    }
}