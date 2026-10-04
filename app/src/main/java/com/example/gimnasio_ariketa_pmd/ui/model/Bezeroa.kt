package com.example.gimnasio_ariketa_pmd.ui.model
class Bezeroa(

    /*
     * Datos heredados.
     */
    nan: String,
    izenAbizenak: String,
    generoa: String?,
    kontaktua: String,

    /*
     * Fecha en la que el cliente se dio de alta.
     *
     * La dejamos como String de momento para simplificar.
     */
    val altaData: String,

    /*
     * Ingresos/dinero de entrada del cliente.
     */
    val diruSarrera: Double

) : Persona(
    nan,
    izenAbizenak,
    generoa,
    kontaktua
) {

    /*
     * Implementamos bistaratu().
     */
    override fun bistaratu(): String {

        return "$izenAbizenak - Alta: $altaData - $diruSarrera €"
    }
}