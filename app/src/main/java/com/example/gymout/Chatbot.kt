package com.example.gymout

//import EnviarMensagemCallback
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.gymout.config.ChatService
import com.example.gymout.model.Mensagem
import com.example.gymout.model.RespostaServidor
import com.example.gymout.ui.MensagemAdapter
import com.example.gymout.callback.EnviarMensagemCallback
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*


class Chatbot : AppCompatActivity() {
    private val VIEW_MY_MESSAGE = 1
    private val VIEW_BOT_MESSAGE = 2
    private var button: Button? = null
    private val idClient = 1
    private var editText: EditText? = null
    private var listaDeMensagens: ListView? = null
    private var mensagens: MutableList<Mensagem>? = null
    private var chatService: ChatService? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chatbot)

        supportActionBar!!.title = "ChatBot"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)


        listaDeMensagens = findViewById(R.id.lv_mensagens)
        mensagens = ArrayList()

        val adapter = MensagemAdapter(1, this.mensagens as ArrayList<Mensagem>, this)
        listaDeMensagens.setAdapter(adapter as ListAdapter)

        val retrofit = Retrofit.Builder()
                .baseUrl("https://dialogflow-gymout.herokuapp.com//api/")
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .build()

        chatService = retrofit.create(ChatService::class.java)
        button = findViewById(R.id.btn_enviar)
        editText = findViewById(R.id.et_texto)

        button.setOnClickListener(View.OnClickListener { //coloquei a my_message uma variavel antes de enviar invez de criar a my_message direto sem atribuir direto
            val textoCompo = editText.getText().toString()
            if (!textoCompo.isEmpty()) {
                val mensagem = Mensagem(textoCompo, VIEW_MY_MESSAGE)
                val call: Call<RespostaServidor> = chatService!!.enviar(mensagem)
                call.enqueue(EnviarMensagemCallback(this@Chatbot))
                colocaNaLista(mensagem)
                editText.setText(null)
            } else {
                Toast.makeText(this@Chatbot, "Digite a mensagem", Toast.LENGTH_SHORT).show()
            }
        })
    }

    fun colocaNaLista(mensagem: Mensagem) {
        mensagens.add(mensagem)
        val adapter = MensagemAdapter(idClient, mensagens, this)
        listaDeMensagens!!.adapter = adapter
    }
}