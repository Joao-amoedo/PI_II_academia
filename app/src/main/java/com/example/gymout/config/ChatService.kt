package com.example.gymout.config

import com.example.gymout.model.Mensagem
import com.example.gymout.model.RespostaServidor
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


interface ChatService {
    @POST("message/text/send")
    fun enviar(@Body mensagem: Mensagem?): Call<RespostaServidor?>?
}