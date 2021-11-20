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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cliente)
        btn_RegresarClientes.setOnClickListener { regresar() }
        fabRegistrarCliente.setOnClickListener { guardar() }
        iniciarList()
    }
    private fun regresar(){
        val intentClientes = Intent(this,activityListarClientes::class.java)
        startActivity(intentClientes)
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
            intent.putExtra("cliente", Valoresclientes)
            intent.putExtra("estado-g", "true")
            startActivity(intent)

        }
        }

    private fun iniciarList(){
        try {
            val intent = intent
            Valoresclientes= intent.getSerializableExtra("Menu") as HashMap<Int,String>
            println("Recibi de Registrar cliente: "+ Valoresclientes.toString())
        }catch (e:Exception){
            println(e.message)

        }
    }
    }

