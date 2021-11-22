package hn.edu.ujcv.pdm_2021_iii_p2_proyecto2.Clases

import android.os.Parcel
import android.os.Parcelable

class Empleados() : Parcelable {
    var Codigo       :Int = 0
    var Nombre       :String = ""
    var Puesto       :String = ""

    constructor(parcel: Parcel) : this() {
        Codigo = parcel.readInt()
        Nombre = parcel.readString().toString()
        Puesto = parcel.readString().toString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(Codigo)
        parcel.writeString(Nombre)
        parcel.writeString(Puesto)
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

    override fun toString(): String {
        return "Nombre del Empleado: $Nombre\nId: $Codigo\nPuesto del Empleado: $Puesto"
    }
}