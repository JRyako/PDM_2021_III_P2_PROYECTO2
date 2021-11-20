package hn.edu.ujcv.pdm_2021_iii_p2_proyecto2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import hn.edu.ujcv.pdm_2021_iii_p2_proyecto2.Clases.Clientes
import hn.edu.ujcv.pdm_2021_iii_p2_proyecto2.Clases.Menus
import kotlinx.android.synthetic.main.activity_cliente.*
import kotlinx.android.synthetic.main.activity_empleado.*
import kotlinx.android.synthetic.main.activity_menu.*
import java.lang.Exception

class activityMenu : AppCompatActivity() {
    var Valoresmenus: HashMap<Int, String> = hashMapOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        btn_RegresarMenus.setOnClickListener { regresar() }
        fabRegistrarMenu.setOnClickListener { guardar() }
        iniciarList()
    }
    private fun regresar(){
        val intentMenu = Intent(this,activityListarMenus::class.java)
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
            intent.putExtra("menus", Valoresmenus)
            intent.putExtra("estado-g", "true")
            startActivity(intent)

        }
    }

    private fun iniciarList(){
        try {
            val intent = intent
            Valoresmenus= intent.getSerializableExtra("Menu") as HashMap<Int,String>
            println("Recibi de Registrar menus: "+ Valoresmenus.toString())
        }catch (e: Exception){
            println(e.message)

        }
    }
}