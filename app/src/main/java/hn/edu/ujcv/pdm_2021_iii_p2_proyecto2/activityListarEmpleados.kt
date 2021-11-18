package hn.edu.ujcv.pdm_2021_iii_p2_proyecto2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hn.edu.ujcv.pdm_2021_iii_p2_proyecto2.Clases.Empleados
import kotlinx.android.synthetic.main.activity_listar_clientes.*
import kotlinx.android.synthetic.main.activity_listar_empleados.*

class activityListarEmpleados : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar_empleados)
        btnRegistrarEmpleado.setOnClickListener { registrarempleado() }
    }
    private fun registrarempleado(){
        val intentRegistrar = Intent(this, activityEmpleado::class.java)
        startActivity(intentRegistrar)

    }
}