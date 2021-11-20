package hn.edu.ujcv.pdm_2021_iii_p2_proyecto2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import hn.edu.ujcv.pdm_2021_iii_p2_proyecto2.Clases.Empleados
import kotlinx.android.synthetic.main.activity_listar_clientes.*
import kotlinx.android.synthetic.main.activity_listar_empleados.*

class activityListarEmpleados : AppCompatActivity() {
    var Valoresempleados: HashMap<Int, String> = hashMapOf()
    var estadogeneral="false"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar_empleados)
        btnRegistrarEmpleado.setOnClickListener { registrarempleado() }
        estado_cliente()
        println(estadogeneral)
        if(estadogeneral.equals("true")){
            iniciarList()
            LISTAR()
        }

    }
    private fun registrarempleado(){
        val intent = Intent(this, activityEmpleado::class.java)
        intent.putExtra("Menu", Valoresempleados)
        startActivity(intent)

    }

    /*OBTENER LA LISTA*/
    private fun iniciarList(){
        val intent = intent
        Valoresempleados= intent.getSerializableExtra("empleado") as HashMap<Int,String>
        println("Recibi de Registrar cliente: "+ Valoresempleados)
    }

    /*OBTENER EL ESTADO DE LA LISTA*/
    private fun estado_cliente(){
        val bundle = intent.extras
        val get = bundle?.get("estado-g")
        this.estadogeneral = getString(R.string.estados, get)

    }

    /*LLENAR EL LISTVIW CON LA LISTA OBTENIDA*/
    fun LISTAR(){
        val list = findViewById<ListView>(R.id.lstViewEmpleados)

        var id:String
        var nombre:String
        var puesto:String
        var final=""

        var A: java.util.ArrayList<String> = java.util.ArrayList()

        for(i in Valoresempleados){
            val data = i.toString().split("|").toTypedArray()
            id=data[1].toString()
            nombre=data[2].toString()
            puesto=data[3].toString()
            final= id +" "+ nombre + " "+puesto
            A.add(final)

        }

        val adaptador = ArrayAdapter(this,android.R.layout.simple_list_item_1,A)

        list.adapter =adaptador
        list.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener { override fun onNothingSelected(parent: AdapterView<*>?) {
        }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long)
            {
            }
        }
    }
}