package com.example.gymout.model

import com.google.gson.annotations.SerializedName


class Mensagem(@field:SerializedName("text") val texto: String, val vIEW_TYPE: Int, val email: String, val sessionId: String)