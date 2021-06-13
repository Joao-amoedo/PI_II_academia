package com.example.gymout.classes

class Aluno(
        uid: String,
        nome: String,
        email: String,
        altura: String?= null,
        nota: MutableList<Int>? = null,
        dataNascimento:Int? = null
) : Usuario(uid, nome, email, altura, nota, dataNascimento, false)