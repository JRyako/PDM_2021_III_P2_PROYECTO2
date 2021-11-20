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
import kotlinx.android.synthetic.main.activity_listar_menus.*
import java.lang.Exception

class activityListarMenus : AppCompatActivity() {


    var Valoresmenus: HashMap<Int, String> = hashMapOf()
    var estadogeneral="false"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar_menus)
        btnRegistrarMenus.setOnClickListener { registrarmenu() }
        estado_menu()
        println(estadogeneral)
        if(estadogeneral.equals("true")){
            iniciarList()
            LISTAR()
        }

    }
    private fun registrarmenu(){
        val intent = Intent(this, activityMenu::class.java)
        intent.putExtra("Menu", Valoresmenus)
        startActivity(intent)

    }

    /*OBTENER LA LISTA*/
    private fun iniciarList(){
        val intent = intent
        Valoresmenus= intent.getSerializableExtra("menus") as HashMap<Int,String>
        println("Recibi de Registrar cliente: "+ Valoresmenus)
    }

    /*OBTENER EL ESTADO DE LA LISTA*/
    private fun estado_menu(){
        val bundle = intent.extras
        val get = bundle?.get("estado-g")
        this.estadogeneral = getString(R.string.estados, get)

    }

    /*LLENAR EL LISTVIW CON LA LISTA OBTENIDA*/
    fun LISTAR(){
        val list = findViewById<ListView>(R.id.lstViewMenus)

        var id:String
        var nombre:String
        var Precio:String
        var Descripcion:String
        var final=""

        var A: java.util.ArrayList<String> = java.util.ArrayList()

        for(i in Valoresmenus){
            val data = i.toString().split("|").toTypedArray()
            id=data[1].toString()
            nombre=data[2].toString()
            Precio=data[3].toString()
            Descripcion=data[4].toString()
            final= id +" "+ nombre + " "+Precio+" "+Descripcion
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