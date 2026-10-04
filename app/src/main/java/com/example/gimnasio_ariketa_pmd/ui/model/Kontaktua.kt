package com.example.gimnasio_ariketa_pmd.ui.model

class Kontaktua(

    nan: String,
    izenAbizenak: String,
    generoa: String?,

    /*
     * Contacto de la persona.
     */
    kontaktua: String

) : Persona(
    nan,
    izenAbizenak,
    generoa,
    kontaktua
) {

    /*
     * Implementamos el método obligatorio de Persona.
     */
    override fun bistaratu(): String {

        return "$izenAbizenak - $kontaktua"
    }

    /*
     * Comprobamos si el contacto tiene formato de email.
     *
     * Ejemplo válido:
     *
     * persona@gmail.com
     *
     * Ejemplo inválido:
     *
     * persona@gmail
     */
    fun kontaktuaBaliozkoa(): Boolean {

        return kontaktua.contains("@") &&
                kontaktua.contains(".")
    }
}