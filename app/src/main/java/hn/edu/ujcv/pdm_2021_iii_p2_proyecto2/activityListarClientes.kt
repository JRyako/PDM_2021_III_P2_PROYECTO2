package hn.edu.ujcv.pdm_2021_iii_p2_proyecto2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import hn.edu.ujcv.pdm_2021_iii_p2_proyecto2.Clases.Clientes
import kotlinx.android.synthetic.main.activity_listar_clientes.*

class activityListarClientes : AppCompatActivity() {

    var Valoresclientes: HashMap<Int, String> = hashMapOf()
    var estadogeneral="false"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar_clientes)
        btnRegistrarCliente.setOnClickListener { registrarcliente() }
        estado_cliente()
        println(estadogeneral)
        if(estadogeneral.equals("true")){
            iniciarList()
            LISTAR()
        }

    }
    private fun registrarcliente(){
        val intent = Intent(this, activityCliente::class.java)
        intent.putExtra("Menu", Valoresclientes)
        startActivity(intent)

    }

    /*OBTENER LA LISTA*/
    private fun iniciarList(){
        val intent = intent
        Valoresclientes= intent.getSerializableExtra("cliente") as HashMap<Int,String>
        println("Recibi de Registrar cliente: "+ Valoresclientes)
    }

    /*OBTENER EL ESTADO DE LA LISTA*/
    private fun estado_cliente(){
        val bundle = intent.extras
        val get = bundle?.get("estado-g")
        this.estadogeneral = getString(R.string.estados, get)

    }

    /*LLENAR EL LISTVIW CON LA LISTA OBTENIDA*/
    fun LISTAR(){
        val list = findViewById<ListView>(R.id.lstViewClientes)

        var id:String
        var nombre:String
        var correo:String
        var final=""

        var A: java.util.ArrayList<String> = java.util.ArrayList()

        for(i in Valoresclientes){
            val data = i.toString().split("|").toTypedArray()
            id=data[1].toString()
            nombre=data[2].toString()
            correo=data[3].toString()
            final= id +" "+ nombre + " "+correo
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