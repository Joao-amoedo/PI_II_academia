package com.example.gymout.classes

class Aluno(
        uid: String,
        nome: String,
        email: String,
        sexo: String? = null,
        peso: String? = null,
        altura: String?= null,
        nota: MutableList<Int>? = null,
        dataNascimento:Int? = null
) : Usuario(uid, nome, email, sexo, peso, altura, nota, dataNascimento, false)