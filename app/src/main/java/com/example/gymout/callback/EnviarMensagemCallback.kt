package com.example.gymout.callback

import android.widget.Toast
import com.example.gymout.Chatbot
import com.example.gymout.model.Mensagem
import com.example.gymout.model.RespostaServidor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class EnviarMensagemCallback(activity: Chatbot) :
    Callback<RespostaServidor?> {
    private val VIEW_MY_MESSAGE = 1
    private val VIEW_BOT_MESSAGE = 2
    var activity: Chatbot
    override fun onResponse(call: Call<RespostaServidor?>, response: Response<RespostaServidor?>) {
        if (response.isSuccessful) {
//            Toast.makeText(activity.getApplicationContext(),"SUCESSO", Toast.LENGTH_SHORT).show();
            val respostaServidor = response.body()
            activity.colocaNaLista(Mensagem(respostaServidor!!.texto!!, VIEW_BOT_MESSAGE))
        } else {
            Toast.makeText(activity.getApplicationContext(), "Resposta ERRO", Toast.LENGTH_SHORT)
                .show()
        }
    }

    override fun onFailure(call: Call<RespostaServidor?>, t: Throwable) {}

    init {
        this.activity = activity
    }
}