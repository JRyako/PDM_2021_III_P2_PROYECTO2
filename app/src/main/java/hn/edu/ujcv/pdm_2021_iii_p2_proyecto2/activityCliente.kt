package hn.edu.ujcv.pdm_2021_iii_p2_proyecto2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import hn.edu.ujcv.pdm_2021_iii_p2_proyecto2.Clases.Clientes
import kotlinx.android.synthetic.main.activity_cliente.*

class activityCliente : AppCompatActivity() {

    var Valoresclientes: HashMap<Int, Clientes> = hashMapOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cliente)
        btn_RegresarClientes.setOnClickListener { regresar() }
        fabRegistrarCliente.setOnClickListener {guardar()}

    }
    private fun regresar(){
        val intentClientes = Intent(this,activityListarClientes::class.java)
        startActivity(intentClientes)
    }
    private fun guardar(){
        if(txtCodigoCliente.text.isEmpty()){
            Toast.makeText(applicationContext, "El numero de cuenta no puede estar vacio", Toast.LENGTH_LONG).show()
        }else if(txtCorreoCliente.text.isEmpty()) {
            Toast.makeText(applicationContext, "El nombre del alumno no puede estar vacio", Toast.LENGTH_LONG).show()
        }else if(txtNombreCliente.text.isEmpty()){
            Toast.makeText(applicationContext, "El correo no puede estar vacio", Toast.LENGTH_LONG).show()
        }else{
            val dato : Clientes = Clientes()
            dato.Codigo  = txtCodigoCliente.text.toString().toInt()
            dato.Nombre        = txtNombreCliente.text.toString()
            dato.Correo        = txtCorreoCliente.text.toString()

            Clientes.Clientes.put(dato.Codigo, dato)
            Toast.makeText(applicationContext, "Alumno Registrado", Toast.LENGTH_SHORT).show()

            txtCodigoCliente.text = null
            txtCorreoCliente.text = null
            txtNombreCliente.text = null
        }
    }

}