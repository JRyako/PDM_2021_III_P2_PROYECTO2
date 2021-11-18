package hn.edu.ujcv.pdm_2021_iii_p2_proyecto2.Clases

import android.os.Parcel
import android.os.Parcelable

class Clientes() : Parcelable {
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

    companion object CREATOR : Parcelable.Creator<Clientes> {
        override fun createFromParcel(parcel: Parcel): Clientes {
            return Clientes(parcel)
        }
        var Clientes: HashMap<Int, Clientes> = hashMapOf()
        var pedidos: HashMap<Clientes,ArrayList<Empleados>> = hashMapOf()

        override fun newArray(size: Int): Array<Clientes?> {
            return arrayOfNulls(size)
        }
    }

    override fun toString(): String {
        return "Nombre del Cliente: $Nombre\nId: $Codigo\nCorreo del Cliente: $Correo"
    }

}