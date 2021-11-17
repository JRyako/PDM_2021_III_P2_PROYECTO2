package hn.edu.ujcv.pdm_2021_iii_p2_proyecto2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hn.edu.ujcv.pdm_2021_iii_p2_proyecto2.Clases.Clientes
import kotlinx.android.synthetic.main.activity_listar_clientes.*

class activityListarClientes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar_clientes)
        btnRegistrarCliente.setOnClickListener { registrarcliente() }
    }
    private fun registrarcliente(){
        val intentRegistrar = Intent(this, activityCliente::class.java)
        startActivity(intentRegistrar)

    }
}