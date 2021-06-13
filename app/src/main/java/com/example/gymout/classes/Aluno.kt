package com.example.gymout.classes

class Aluno(
        uid: String,
        nome: String,
        email: String,
        sexo: String? = null,
        nota: MutableList<Int>? = null,
        dataNascimento:Int? = null
) : Usuario(uid, nome, email, sexo, nota, dataNascimento)