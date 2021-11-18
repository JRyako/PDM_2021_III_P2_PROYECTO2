package hn.edu.ujcv.pdm_2021_iii_p2_proyecto2.Clases

import android.os.Parcel
import android.os.Parcelable

class Menus() : Parcelable {
    var Codigo        :Int = 0
    var Nombre        :String = ""
    var Precio        :Int = 0
    var Descripcion   :String = ""

    constructor(parcel: Parcel) : this() {
        Codigo = parcel.readInt()
        Nombre = parcel.readString().toString()
        Precio = parcel.readInt()
        Descripcion = parcel.readString().toString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(Codigo)
        parcel.writeString(Nombre)
        parcel.writeInt(Precio)
        parcel.writeString(Descripcion)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Menus> {
        override fun createFromParcel(parcel: Parcel): Menus {
            return Menus(parcel)
        }

        override fun newArray(size: Int): Array<Menus?> {
            return arrayOfNulls(size)
        }

        var Menus: HashMap<Int, Menus> = hashMapOf()
    }

    override fun toString(): String {
        return "Nombre del Menu: $Nombre\nId: $Codigo\nPrecio: $Precio\nDescripcion: $Descripcion"
    }
}