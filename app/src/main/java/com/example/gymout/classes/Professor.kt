package com.example.gymout.classes

class Professor(
        nome: String,
        email: String,
        sexo: String? = null,
        nota: MutableList<Int>? = null,
        dataNascimento:Int? = null,
        var bio:String? = null,
        var certificadoEducacao:String? = null,
        var CEP:String? = null
) : Usuario(nome, email, sexo, nota, dataNascimento)