package com.example.gymout.ui
import android.R
import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.gymout.model.Mensagem

class MensagemAdapter(
    private val idDoCliente: Int,
    private val mensagens: List<Mensagem>,
    private val activity: Activity
) :
    BaseAdapter() {
    private var linha: View? = null
    private var texto: TextView? = null
    override fun getCount(): Int {
        return mensagens.size
    }

    override fun getItem(i: Int): Mensagem {
        return mensagens[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getView(i: Int, view: View, viewGroup: ViewGroup): View {
        val mensagem = getItem(i)
        linha = activity.layoutInflater.inflate(R.layout.my_message, viewGroup, false)
        texto = linha!!.findViewById(R.id.bot_message)
        if (idDoCliente != mensagem.vIEW_TYPE) {
            linha = activity.layoutInflater.inflate(R.layout.bot_message, viewGroup, false)
            texto = linha!!.findViewById(R.id.bot_message)
        }
        texto.setText(mensagem.texto)
        return linha!!
    }
}