package com.example.kfc0_.a2018movilesgr2

import android.os.Parcel
import android.os.Parcelable
import java.util.*

//Primer constructor
class Usuario ( public var nombre:String,
                var edad:Int,
                var fechaNacimiento: Date,
                var sueldo: Double):Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readInt(),
            parcel.readSerializable() as Date,
            parcel.readDouble()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeInt(edad)
        parcel.writeSerializable(fechaNacimiento)
        parcel.writeDouble(sueldo)
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun toString():String {
        return "${nombre}"
    }

    companion object CREATOR : Parcelable.Creator<Usuario> {
        override fun createFromParcel(parcel: Parcel): Usuario {
            return Usuario(parcel)
        }

        override fun newArray(size: Int): Array<Usuario?> {
            return arrayOfNulls(size)
        }
    }

}

val kevin = Usuario("asdqwezxc",10, Date(1994,12,29),50.00)
