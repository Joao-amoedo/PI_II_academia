package com.example.gymout.classes

open class Usuario(
    var nome: String,
    var email: String,
    var sexo: String? = null,
    var peso: String? = null,
    var altura: String?= null,
    var nota: MutableList<Int>? = null,
    var dataNascimento: Int? = null



)