package com.example.gymout.classes

class Aluno(
        uid: String,
        nome: String,
        email: String,
        nota: MutableList<Int>? = null,
        idade:Int? = null,
        var endereco:String? = null

) : Usuario(uid, nome, email, nota, idade, false)