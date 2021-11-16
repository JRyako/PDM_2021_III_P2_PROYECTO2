package hn.edu.ujcv.pdm_2021_iii_p2_proyecto2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hn.edu.ujcv.pdm_2021_iii_p2_proyecto2.Clases.Clientes
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_Clientes.setOnClickListener { clientes() }
        btn_empleados.setOnClickListener { empleados() }
        btn_facturas.setOnClickListener { facturas() }
        btn_pedidos.setOnClickListener { pedidos() }
        btn_menus.setOnClickListener { menus() }
    }
    private fun inicializar(){

    }

    private fun clientes(){
        val intent = Intent(this, ClientesActivity::class.java)
        startActivity(intent)

    }

    private fun empleados(){


    }
    private fun facturas(){


    }
    private fun pedidos(){


    }
    private fun menus(){


    }

}