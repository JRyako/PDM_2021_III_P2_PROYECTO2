package hn.edu.ujcv.pdm_2021_iii_p2_proyecto2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import hn.edu.ujcv.pdm_2021_iii_p2_proyecto2.Clases.Clientes
import hn.edu.ujcv.pdm_2021_iii_p2_proyecto2.Clases.Empleados
import kotlinx.android.synthetic.main.activity_empleado.*
import java.lang.Exception

class activityEmpleado : AppCompatActivity() {

    var Valoresclientes: HashMap<Int, String> = hashMapOf()
    var Valoresmenus: HashMap<Int, String> = hashMapOf()
    var Valoresempleados: HashMap<Int, String> = hashMapOf()
    var Valoresfactura: HashMap<Int, String> = hashMapOf()
    var Valorespedido: HashMap<Int, String> = hashMapOf()
    var num =""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empleado)
        fabRegistrarEmpleado.setOnClickListener { guardar() }
        iniciarList1()
        iniciarList2()
        iniciarList3()
        iniciarList4()
        iniciarList5()
    }
    private fun regresar(){
        val intentEmpleados = Intent(this, activityListarEmpleados::class.java)
        startActivity(intentEmpleados)
    }
    private fun guardar(){
        if(txtCodigoEmpleado.text.isEmpty()){
            Toast.makeText(applicationContext, "El Codigo del Empleado no puede estar vacio", Toast.LENGTH_LONG).show()
        }else if(txtNombreEmpleado.text.isEmpty()) {
            Toast.makeText(applicationContext, "El Nombre del Empleado no puede estar vacio", Toast.LENGTH_LONG).show()
        }else if(txtPuestoEmpleado.text.isEmpty()){
            Toast.makeText(applicationContext, "El Puesto del Empleado no puede estar vacio", Toast.LENGTH_LONG).show()
        }else{
            val dato : Empleados = Empleados()
            dato.Codigo        = txtCodigoEmpleado.text.toString().toInt()
            dato.Nombre        = txtNombreEmpleado.text.toString()
            dato.Puesto        = txtPuestoEmpleado.text.toString()
            val parametro = StringBuilder()
            parametro.append("DATOS CLIENTES").append("|")
            parametro.append(dato.Codigo.toString().trim()).append("|")
            parametro.append(dato.Nombre.toString().trim()).append("|")
            parametro.append(dato.Puesto.toString().trim()).append("|")

            Valoresempleados.put(dato.Codigo, parametro.toString())
            Toast.makeText(applicationContext, "Empleado Registrado", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, activityListarEmpleados::class.java)
            intent.putExtra("c", Valoresclientes)
            intent.putExtra("m", Valoresmenus)
            intent.putExtra("e", Valoresempleados)
            intent.putExtra("f", Valoresfactura)
            intent.putExtra("p", Valorespedido)
            intent.putExtra("cont", num.toString())

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


