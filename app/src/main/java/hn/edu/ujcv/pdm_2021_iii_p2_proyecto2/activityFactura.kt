package hn.edu.ujcv.pdm_2021_iii_p2_proyecto2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import java.lang.Exception
import kotlinx.android.synthetic.main.activity_realizar_factura.*
import java.util.ArrayList

class activityFactura : AppCompatActivity() {
    var Valoresclientes: HashMap<Int, String> = hashMapOf()
    var Valoresmenus: HashMap<Int, String> = hashMapOf()
    var Valoresempleados: HashMap<Int, String> = hashMapOf()
    var Valoresfactura: HashMap<Int, String> = hashMapOf()
    var Valorespedido: HashMap<Int, String> = hashMapOf()
    var num =0
    var num1 =""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realizar_factura)
        iniciarList1()
        iniciarList2()
        iniciarList3()
        iniciarList4()
        iniciarList5()
        iniciarList6()
        iniciarcontrolers()
        btnEnviarFactura.setOnClickListener { Enviar() }

        button7.setOnClickListener { volver() }

    }


    fun Enviar(){
        num =num+1
        var id=""
        var nombre=""
        var correo=""
        var finalt=""
        var rmenus=""
        var nmesero=""

        for(i in Valorespedido){

            val data = i.toString().split("|").toTypedArray()
            if(data[1].toString().equals(spnSeleccionarPedido.selectedItem.toString())){
                id=data[1].toString()
                rmenus=data[3].toString()
                nmesero=data[4].toString()
                finalt=data[5].toString()

                for(j in Valoresclientes){

                    val data1 = j.toString().split("|").toTypedArray()
                    if (data1[2].toString().equals(data[2].toString())){
                        nombre=data1[2].toString()
                        correo=data1[3].toString()
                        println(correo)

                    }
                }
            }




        }
        var factura = "______FACTURA_______"+"\n.............................."+"" +
                "\n"+"Estimado: "+nombre+ "\n"+
                "Id Pedido: "+id+"\n"+
                "Resumen del Pedido:"+"\n"+
                rmenus+"\n"+
                "total: "+finalt+"\n"+
                "Atendido por: "+nmesero+"\n"+
                ".............................."+"\n"+
                "Tipo de Pago: "+spnSeleccionarPago.selectedItem.toString()+"\n"+
                "Cajero en turno: "+ spnSeleccionarEmpleadoCajero.selectedItem.toString()+"\n"+
                "GRACIAS POR SU COMPRA"


        val parametro = StringBuilder()
        parametro.append("DATOS FACTURA").append("|")
        parametro.append(num.toString().trim()).append("|")
        parametro.append(factura.toString().trim()).append("|")
        Valoresfactura.put(num, parametro.toString())
        Toast.makeText(applicationContext, "Factura Registrado", Toast.LENGTH_SHORT).show()
        var correos = arrayOf<String>(correo)

        val intent = Intent(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_EMAIL,correos)
        intent.putExtra(Intent.EXTRA_SUBJECT, "FACTURA DE PEDIDO")
        intent.putExtra(Intent.EXTRA_TEXT, factura)
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Email"))


    }



    fun iniciarcontrolers(){
        val spinner1 = findViewById<Spinner>(R.id.spnSeleccionarPedido)
        var ncliente=""
        var Lista: ArrayList<String> = ArrayList()
        for(i in Valorespedido){
            val data = i.toString().split("|").toTypedArray()
            ncliente=data[1].toString()
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


        val spinner2 = findViewById<Spinner>(R.id.spnSeleccionarPago)
        var Lista1: ArrayList<String> = ArrayList()
        Lista1.add("Efectivo")
        Lista1.add("Tarjeta")
        Lista1.add("Mixto")

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

        val spinner3 = findViewById<Spinner>(R.id.spnSeleccionarEmpleadoCajero)
        var nempleado=""
        var Lista2: ArrayList<String> = ArrayList()
        for(i in Valoresempleados){
            val data = i.toString().split("|").toTypedArray()
            if(data[3].toString().equals("CAJERO")){
                nempleado=data[2].toString()
                Lista2.add(nempleado)
            }

        }
        val adaptador3 = ArrayAdapter(this, R.layout.row, Lista2)
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
            num1 = getString(R.string.estados, get)
        }catch (e: Exception){
            println(e.message)

        }
    }

    fun volver(){
        val intent = Intent(this, activityListarFacturas::class.java)
        intent.putExtra("c", Valoresclientes)
        intent.putExtra("m", Valoresmenus)
        intent.putExtra("e", Valoresempleados)
        intent.putExtra("f", Valoresfactura)
        intent.putExtra("p", Valorespedido)
        intent.putExtra("cont", num.toString())
        startActivity(intent)
    }





}