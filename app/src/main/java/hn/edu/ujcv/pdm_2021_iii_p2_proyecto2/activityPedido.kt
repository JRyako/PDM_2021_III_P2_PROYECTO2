package hn.edu.ujcv.pdm_2021_iii_p2_proyecto2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_realizar_factura.*
import kotlinx.android.synthetic.main.activity_realizar_pedido.*
import java.lang.Exception
import java.util.ArrayList

class activityPedido: AppCompatActivity() {
    var Valoresclientes: HashMap<Int, String> = hashMapOf()
    var Valoresmenus: HashMap<Int, String> = hashMapOf()
    var Valoresempleados: HashMap<Int, String> = hashMapOf()
    var Valoresfactura: HashMap<Int, String> = hashMapOf()
    var Valorespedido: HashMap<Int, String> = hashMapOf()
    var listItem = ArrayList<String>()
    var adapter: ArrayAdapter<String>? = null
    var total=0
    var num=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realizar_pedido)
        iniciarList1()
        iniciarList2()
        iniciarList3()
        iniciarList4()
        iniciarList5()
        iniciarcontrolers()
        iniciarList6()
        btnIngresarMenuAList.setOnClickListener { addListItem() }
        btnCompletarPedido.setOnClickListener { guardar() }

    }



    fun iniciarcontrolers(){
        val spinner1 = findViewById<Spinner>(R.id.spnSeleccionarCliente)
        var ncliente=""
        var Lista:ArrayList<String> = ArrayList()
        for(i in Valoresclientes){
            val data = i.toString().split("|").toTypedArray()
            ncliente=data[2].toString()
            Lista.add(ncliente)
        }
        val adaptador = ArrayAdapter(this, R.layout.row, Lista)
        spinner1.adapter =adaptador
        spinner1.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long){
            }

        }


        val spinner2 = findViewById<Spinner>(R.id.spnSeleccionarVariosMenus)
        var nmenu=""
        var Lista1:ArrayList<String> = ArrayList()
        for(i in Valoresmenus){
            val data = i.toString().split("|").toTypedArray()
            nmenu=data[2].toString()
            Lista1.add(nmenu)
        }
        val adaptador2 = ArrayAdapter(this, R.layout.row, Lista1)
        spinner2.adapter =adaptador2
        spinner2.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long){
            }

        }

        val spinner3 = findViewById<Spinner>(R.id.spnSeleccionarEmpleadoMesero)
        var nempleado=""
        var Lista2:ArrayList<String> = ArrayList()
        for(i in Valoresempleados){
            val data = i.toString().split("|").toTypedArray()
            if(data[3].toString().equals("MESERO")){
                nempleado=data[2].toString()
                Lista2.add(nempleado)
            }

        }
        val adaptador3 = ArrayAdapter(this,  R.layout.row, Lista2)
        spinner3.adapter =adaptador3
        spinner3.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long){
            }

        }



    }

    private fun addListItem() {
        var nombre: String
        var precio: Int
        var cantidad = 0

        var subtot = 0
        for (i in Valoresmenus) {
            val data = i.toString().split("|").toTypedArray()
            if (data[2].equals(spnSeleccionarVariosMenus.selectedItem.toString())) {
                nombre = data[2].toString()
                precio = data[3].toString().toInt()
                cantidad = txtCantidad.text.toString().toInt()
                subtot = precio * cantidad
                listItem.add(nombre + " " + cantidad + " " + precio + " " + subtot.toString())
                adapter?.notifyDataSetChanged()
                total = total + subtot
                textView2.text = total.toString()
            }
        }

    }

    override fun onStart() {
        super.onStart()
        adapter = ArrayAdapter(this, R.layout.row, listItem)
        lstViewMenusdelPedido.adapter = adapter
    }


    private fun iniciarList1() {
        try {
            val intent = intent
            Valoresclientes = intent.getSerializableExtra("c") as HashMap<Int, String>
            println("Recibi de Registrar cliente: " + Valoresclientes.toString())
        } catch (e: Exception) {
            println(e.message)

        }
    }

    private fun iniciarList2() {
        try {
            val intent = intent
            Valoresmenus = intent.getSerializableExtra("m") as HashMap<Int, String>
            println("Recibi de Registrar cliente: " + Valoresmenus.toString())
        } catch (e: Exception) {
            println(e.message)

        }
    }

    private fun iniciarList3() {
        try {
            val intent = intent
            Valoresempleados = intent.getSerializableExtra("e") as HashMap<Int, String>
            println("Recibi de Registrar cliente: " + Valoresempleados.toString())
        } catch (e: Exception) {
            println(e.message)

        }
    }

    private fun iniciarList4() {
        try {
            val intent = intent
            Valoresfactura = intent.getSerializableExtra("f") as HashMap<Int, String>
            println("Recibi de Registrar cliente: " + Valoresfactura.toString())
        } catch (e: Exception) {
            println(e.message)

        }
    }

    private fun iniciarList5() {
        try {
            val intent = intent
            Valorespedido = intent.getSerializableExtra("p") as HashMap<Int, String>
            println("Recibi de Listar Pedido: " + Valorespedido.toString())
        } catch (e: Exception) {
            println(e.message)

        }
    }



    fun guardar(){
        num = num+1
        val parametro = StringBuilder()
        parametro.append("DATOS PEDIDO").append("|")
        parametro.append(num.toString().trim()).append("|")
        parametro.append(spnSeleccionarCliente.selectedItem.toString().trim()).append("|")
        parametro.append(listItem.toString().trim()).append("|")
        parametro.append(spnSeleccionarEmpleadoMesero.selectedItem.toString().trim()).append("|")
        parametro.append(textView2.text.toString().trim()).append("|")

        Valorespedido.put(num, parametro.toString())

        Toast.makeText(applicationContext, "Pedido Registrado", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, activityListarPedidos::class.java)
        intent.putExtra("c", Valoresclientes)
        intent.putExtra("m", Valoresmenus)
        intent.putExtra("e", Valoresempleados)
        intent.putExtra("f", Valoresfactura)
        intent.putExtra("p", Valorespedido)
        intent.putExtra("cont", num.toString())
        startActivity(intent)
    }

    private fun iniciarList6(){
        var g=""
        try {
            val bundle = intent.extras
            val get = bundle?.get("cont")
            g = getString(R.string.estados, get)
            num = g.toInt()
            println("El numero de pedido anterior es: "+num.toString())
        }catch (e: Exception){
            println(e.message)

        }
    }
}
