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

    var Valoresempleados: HashMap<Int, String> = hashMapOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empleado)
        btn_RegresarEmpleados.setOnClickListener { regresar() }
        fabRegistrarEmpleado.setOnClickListener { guardar() }
        iniciarList()
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
            intent.putExtra("empleado", Valoresempleados)
            intent.putExtra("estado-g", "true")
            startActivity(intent)

        }
    }

    private fun iniciarList(){
        try {
            val intent = intent
            Valoresempleados= intent.getSerializableExtra("Menu") as HashMap<Int,String>
            println("Recibi de Registrar Empleados: "+ Valoresempleados.toString())
        }catch (e:Exception){
            println(e.message)

        }
    }
}

