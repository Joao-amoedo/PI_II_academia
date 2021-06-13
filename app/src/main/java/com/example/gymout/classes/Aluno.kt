package com.example.gymout.classes

class Aluno(
        nome: String,
        email: String,
        sexo: String? = null,
        nota: MutableList<Int>? = null,
        dataNascimento:Int? = null
) : Usuario(nome, email, sexo, nota, dataNascimento)