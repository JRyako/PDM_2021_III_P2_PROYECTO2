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

class activityMenu : AppCompatActivity() {

    var Valoresmenus: HashMap<Int, Menus> = hashMapOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        btn_RegresarMenus.setOnClickListener { regresar() }
        fabRegistrarMenu.setOnClickListener { guardar() }
    }

    private fun regresar() {
        val intentMenus = Intent(this, activityListarMenus::class.java)
        startActivity(intentMenus)
    }

    private fun guardar() {
        if(txtCodigoMenu.text.isEmpty()){
            Toast.makeText(applicationContext, "El Codigo del Menu no puede estar vacio", Toast.LENGTH_LONG).show()
        }else if(txtNombreMenu.text.isEmpty()) {
            Toast.makeText(applicationContext, "El Nombre del Menu no puede estar vacio", Toast.LENGTH_LONG).show()
        }else if(txtPrecioMenu.text.isEmpty()){
            Toast.makeText(applicationContext, "El Precio del Menu no puede estar vacio", Toast.LENGTH_LONG).show()
        }else if(mtxtDescripcionMenu.text.isEmpty()){
            Toast.makeText(applicationContext, "La Descripcion del Menu no puede estar vacio", Toast.LENGTH_LONG).show()
        }else{
            val dato: Menus = Menus()
            dato.Codigo = txtCodigoMenu.text.toString().toInt()
            dato.Nombre = txtNombreMenu.text.toString()
            dato.Precio = txtPrecioMenu.text.toString().toInt()
            dato.Descripcion = mtxtDescripcionMenu.text.toString()

            Menus.Menus.put(dato.Codigo, dato)
            Toast.makeText(applicationContext, "Menu Registrado", Toast.LENGTH_SHORT).show()

            txtCodigoMenu.text = null
            txtNombreMenu.text = null
            txtPrecioMenu.text = null
            mtxtDescripcionMenu.text = null
        }
    }
}