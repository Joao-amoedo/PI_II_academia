package com.example.gymout.classes

class Professor(
        nome: String,
        email: String,
        sexo: String? = null,
        peso: String? = null,
        altura: String?= null,
        nota: MutableList<Int>? = null,
        dataNascimento:Int? = null,
        var certificadoEducacao:String? = null,
        var CEP:String? = null
) : Usuario(nome, email, sexo, peso, altura, nota, dataNascimento)