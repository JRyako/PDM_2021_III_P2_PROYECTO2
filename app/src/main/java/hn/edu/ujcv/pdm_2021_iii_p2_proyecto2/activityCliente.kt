package hn.edu.ujcv.pdm_2021_iii_p2_proyecto2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import hn.edu.ujcv.pdm_2021_iii_p2_proyecto2.Clases.Clientes
import kotlinx.android.synthetic.main.activity_cliente.*
import java.lang.Exception

class activityCliente : AppCompatActivity() {

    var Valoresclientes: HashMap<Int, String> = hashMapOf()
    var Valoresmenus: HashMap<Int, String> = hashMapOf()
    var Valoresempleados: HashMap<Int, String> = hashMapOf()
    var Valoresfactura: HashMap<Int, String> = hashMapOf()
    var Valorespedido: HashMap<Int, String> = hashMapOf()
    var num =""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cliente)
        fabRegistrarCliente.setOnClickListener { guardar() }
        iniciarList1()
        iniciarList2()
        iniciarList3()
        iniciarList4()
        iniciarList5()

    }

    private fun guardar(){
        if(txtCodigoCliente.text.isEmpty()){
            Toast.makeText(applicationContext, "El Codigo del Cliente no puede estar vacio", Toast.LENGTH_LONG).show()
        }else if(txtNombreCliente.text.isEmpty()) {
            Toast.makeText(applicationContext, "El Nombre del Cliente no puede estar vacio", Toast.LENGTH_LONG).show()
        }else if(txeCorreoCliente.text.isEmpty()){
            Toast.makeText(applicationContext, "El Correo del Cliente no puede estar vacio", Toast.LENGTH_LONG).show()
        }else{
            val dato : Clientes = Clientes()
            dato.Codigo        = txtCodigoCliente.text.toString().toInt()
            dato.Nombre        = txtNombreCliente.text.toString()
            dato.Correo        = txeCorreoCliente.text.toString()
            val parametro = StringBuilder()
            parametro.append("DATOS CLIENTES").append("|")
            parametro.append(dato.Codigo.toString().trim()).append("|")
            parametro.append(dato.Nombre.toString().trim()).append("|")
            parametro.append(dato.Correo.toString().trim()).append("|")

            Valoresclientes.put(dato.Codigo, parametro.toString())
            Toast.makeText(applicationContext, "Cliente Registrado", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, activityListarClientes::class.java)
            intent.putExtra("c", Valoresclientes)
            intent.putExtra("m", Valoresmenus)
            intent.putExtra("e", Valoresempleados)
            intent.putExtra("f", Valoresfactura)
            intent.putExtra("p", Valorespedido)
            intent.putExtra("cont", num)
            startActivity(intent)

        }
    }



    private fun iniciarList1(){
        try {
            val intent = intent
            Valoresclientes= intent.getSerializableExtra("c") as HashMap<Int,String>
            println("Recibi de Registrar cliente: "+ Valoresclientes.toString())
        }catch (e: Exception){
            println(e.message)

        }
    }

    private fun iniciarList2(){
        try {
            val intent = intent
            Valoresmenus= intent.getSerializableExtra("m") as HashMap<Int,String>
            println("Recibi de Registrar cliente: "+ Valoresmenus.toString())
        }catch (e: Exception){
            println(e.message)

        }
    }

    private fun iniciarList3(){
        try {
            val intent = intent
            Valoresempleados= intent.getSerializableExtra("e") as HashMap<Int,String>
            println("Recibi de Registrar cliente: "+ Valoresempleados.toString())
        }catch (e: Exception){
            println(e.message)

        }
    }

    private fun iniciarList4(){
        try {
            val intent = intent
            Valoresfactura= intent.getSerializableExtra("f") as HashMap<Int,String>
            println("Recibi de Registrar cliente: "+ Valoresfactura.toString())
        }catch (e: Exception){
            println(e.message)

        }
    }

    private fun iniciarList5(){
        try {
            val intent = intent
            Valorespedido= intent.getSerializableExtra("p") as HashMap<Int,String>
            println("Recibi de Registrar cliente: "+ Valorespedido.toString())
        }catch (e: Exception){
            println(e.message)

        }
    }
    private fun iniciarList6(){
        try {
            val bundle = intent.extras
            val get = bundle?.get("cont")
            num = getString(R.string.estados, get)
        }catch (e: Exception){
            println(e.message)

        }
    }


}

