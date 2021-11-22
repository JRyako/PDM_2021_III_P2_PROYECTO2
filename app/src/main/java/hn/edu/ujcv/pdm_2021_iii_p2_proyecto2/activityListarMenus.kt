package hn.edu.ujcv.pdm_2021_iii_p2_proyecto2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import hn.edu.ujcv.pdm_2021_iii_p2_proyecto2.Clases.Clientes
import hn.edu.ujcv.pdm_2021_iii_p2_proyecto2.Clases.Menus
import kotlinx.android.synthetic.main.activity_listar_clientes.*
import kotlinx.android.synthetic.main.activity_listar_menus.*
import java.lang.Exception

class activityListarMenus : AppCompatActivity() {



    var Valoresclientes: HashMap<Int, String> = hashMapOf()
    var Valoresmenus: HashMap<Int, String> = hashMapOf()
    var Valoresempleados: HashMap<Int, String> = hashMapOf()
    var Valoresfactura: HashMap<Int, String> = hashMapOf()
    var Valorespedido: HashMap<Int, String> = hashMapOf()
    var num =""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar_menus)
        btnRegistrarMenus.setOnClickListener { registrarmenu() }
        iniciarList1()
        iniciarList2()
        iniciarList3()
        iniciarList4()
        iniciarList5()
        LISTAR()
        iniciarList6()
        button4.setOnClickListener { volver() }
    }
    private fun registrarmenu(){
        val intent = Intent(this, activityMenu::class.java)
        intent.putExtra("c", Valoresclientes)
        intent.putExtra("m", Valoresmenus)
        intent.putExtra("e", Valoresempleados)
        intent.putExtra("f", Valoresfactura)
        intent.putExtra("p", Valorespedido)
        intent.putExtra("cont", num.toString())
        startActivity(intent)

    }

    fun volver(){
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("c", Valoresclientes)
        intent.putExtra("m", Valoresmenus)
        intent.putExtra("e", Valoresempleados)
        intent.putExtra("f", Valoresfactura)
        intent.putExtra("p", Valorespedido)
        intent.putExtra("cont", num.toString())
        startActivity(intent)
    }



    /*LLENAR EL LISTVIW CON LA LISTA OBTENIDA*/
    fun LISTAR(){
        try {
            val list = findViewById<ListView>(R.id.lstViewMenus)

            var id:String
            var nombre:String
            var correo:String
            var final=""

            var A: java.util.ArrayList<String> = java.util.ArrayList()

            for(i in Valoresmenus){
                val data = i.toString().split("|").toTypedArray()
                id=data[1].toString()
                nombre=data[2].toString()
                correo=data[3].toString()
                final= id +" "+ nombre + " "+correo
                A.add(final)

            }

            val adaptador = ArrayAdapter(this,R.layout.row,A)

            list.adapter =adaptador
            list.onItemSelectedListener = object:
                AdapterView.OnItemSelectedListener { override fun onNothingSelected(parent: AdapterView<*>?) {
            }
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long)
                {
                }
            }
        }catch (e: Exception){
            println(e.message)

        }

    }
    private fun iniciarList1(){
        try {
            val intent = intent
            Valoresclientes= intent.getSerializableExtra("c") as HashMap<Int,String>
            println("Recibi de Registrar cliente: "+ Valoresclientes.toString())
        }catch (e:Exception){
            println(e.message)

        }
    }

    private fun iniciarList2(){
        try {
            val intent = intent
            Valoresmenus= intent.getSerializableExtra("m") as HashMap<Int,String>
            println("Recibi de Registrar cliente: "+ Valoresmenus.toString())
        }catch (e:Exception){
            println(e.message)

        }
    }

    private fun iniciarList3(){
        try {
            val intent = intent
            Valoresempleados= intent.getSerializableExtra("e") as HashMap<Int,String>
            println("Recibi de Registrar cliente: "+ Valoresempleados.toString())
        }catch (e:Exception){
            println(e.message)

        }
    }

    private fun iniciarList4(){
        try {
            val intent = intent
            Valoresfactura= intent.getSerializableExtra("f") as HashMap<Int,String>
            println("Recibi de Registrar cliente: "+ Valoresfactura.toString())
        }catch (e:Exception){
            println(e.message)

        }
    }

    private fun iniciarList5(){
        try {
            val intent = intent
            Valorespedido= intent.getSerializableExtra("p") as HashMap<Int,String>
            println("Recibi de Registrar cliente: "+ Valorespedido.toString())
        }catch (e:Exception){
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