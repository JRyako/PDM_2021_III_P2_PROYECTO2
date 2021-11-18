package hn.edu.ujcv.pdm_2021_iii_p2_proyecto2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hn.edu.ujcv.pdm_2021_iii_p2_proyecto2.Clases.Menus
import kotlinx.android.synthetic.main.activity_listar_menus.*

class activityListarMenus : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar_menus)
        btnRegistrarMenus.setOnClickListener { registrarmenu() }
    }
    private fun registrarmenu(){
        val intentRegistrar = Intent(this, activityMenu::class.java)
        startActivity(intentRegistrar)

    }
}