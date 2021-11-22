package hn.edu.ujcv.pdm_2021_iii_p2_proyecto2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import hn.edu.ujcv.pdm_2021_iii_p2_proyecto2.Clases.Clientes
import hn.edu.ujcv.pdm_2021_iii_p2_proyecto2.Clases.Menus
import kotlinx.android.synthetic.main.activity_cliente.*
import kotlinx.android.synthetic.main.activity_empleado.*
import kotlinx.android.synthetic.main.activity_listar_clientes.*
import kotlinx.android.synthetic.main.activity_menu.*
import java.lang.Exception

class activityMenu : AppCompatActivity() {
    var Valoresclientes: HashMap<Int, String> = hashMapOf()
    var Valoresmenus: HashMap<Int, String> = hashMapOf()
    var Valoresempleados: HashMap<Int, String> = hashMapOf()
    var Valoresfactura: HashMap<Int, String> = hashMapOf()
    var Valorespedido: HashMap<Int, String> = hashMapOf()
    var num =""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        fabRegistrarMenu.setOnClickListener { guardar() }
        iniciarList1()
        iniciarList2()
        iniciarList3()
        iniciarList4()
        iniciarList5()
        iniciarList6()
        button6.setOnClickListener { volver() }
    }
    private fun volver(){
        val intentMenu = Intent(this,activityListarMenus::class.java)
        intent.putExtra("c", Valoresclientes)
        intent.putExtra("m", Valoresmenus)
        intent.putExtra("e", Valoresempleados)
        intent.putExtra("f", Valoresfactura)
        intent.putExtra("p", Valorespedido)
        startActivity(intentMenu)
    }
    private fun guardar(){
        if(txtCodigoMenu.text.isEmpty()){
            Toast.makeText(applicationContext, "El Codigo del Menu no puede estar vacio", Toast.LENGTH_LONG).show()
        }else if(txtNombreMenu.text.isEmpty()) {
            Toast.makeText(applicationContext, "El Nombre del Menu no puede estar vacio", Toast.LENGTH_LONG).show()
        }else if(txtPrecioMenu.text.isEmpty()){
            Toast.makeText(applicationContext, "El precio del Menu no puede estar vacio", Toast.LENGTH_LONG).show()
        }else if(mtxtDescripcionMenu.text.isEmpty()){
            Toast.makeText(applicationContext, "La descripción del Menu no puede estar vacio", Toast.LENGTH_LONG).show()
        }
        else{
            val dato : Menus = Menus()
            dato.Codigo        = txtCodigoMenu.text.toString().toInt()
            dato.Nombre        = txtNombreMenu.text.toString()
            dato.Precio        = txtPrecioMenu.text.toString().toInt()
            dato.Descripcion   = mtxtDescripcionMenu.text.toString()
            val parametro = StringBuilder()
            parametro.append("DATOS MENU").append("|")
            parametro.append(dato.Codigo.toString().trim()).append("|")
            parametro.append(dato.Nombre.toString().trim()).append("|")
            parametro.append(dato.Precio.toString().trim()).append("|")
            parametro.append(dato.Descripcion.toString().trim()).append("|")

            Valoresmenus.put(dato.Codigo, parametro.toString())
            Toast.makeText(applicationContext, "Menu Registrado", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, activityListarMenus::class.java)
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