package hn.edu.ujcv.pdm_2021_iii_p2_proyecto2.Clases

import android.os.Parcel
import android.os.Parcelable

class Empleados() : Parcelable {
    var Codigo       :Int = 0
    var Nombre       :String = ""
    var Correo       :String = ""

    constructor(parcel: Parcel) : this() {
        Codigo = parcel.readInt()
        Nombre = parcel.readString().toString()
        Correo = parcel.readString().toString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(Codigo)
        parcel.writeString(Nombre)
        parcel.writeString(Correo)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Empleados> {
        override fun createFromParcel(parcel: Parcel): Empleados {
            return Empleados(parcel)
        }

        override fun newArray(size: Int): Array<Empleados?> {
            return arrayOfNulls(size)
        }

        var Empleados: HashMap<Int, Empleados> = hashMapOf()

    }

    /*fun imprimirNotas(): String{
        return "Clase: $nombre\nNota Primer Parcial: $n1\nNota Segundo Parcial: $n2\nNota Tercer Parcial: $n3\n"
    }*/

    // este era el imprimir notas del laboratorio 2 no se como implimentarlo en este proyecto

    override fun toString(): String {
        return "Nombre del Empleado: $Nombre\nCodigo del Empleado: $Codigo"
    }
}