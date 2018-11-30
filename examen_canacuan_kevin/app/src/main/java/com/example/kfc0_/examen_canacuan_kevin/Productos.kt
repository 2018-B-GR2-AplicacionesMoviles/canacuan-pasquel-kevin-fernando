package com.example.kfc0_.examen_canacuan_kevin

import android.os.Parcel
import android.os.Parcelable

//Primer constructor
class Productos (
    var nombre: String,
    var precio: Int,
    var cantidad: Int,
    var tipo: String?
    ):Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeInt(precio)
        parcel.writeInt(cantidad)
        parcel.writeString(tipo)
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun toString():String {
        return "${nombre}"
    }

    companion object CREATOR : Parcelable.Creator<Productos> {
        override fun createFromParcel(parcel: Parcel): Productos {
            return Productos(parcel)
        }

        override fun newArray(size: Int): Array<Productos?> {
            return arrayOfNulls(size)
        }
    }

}