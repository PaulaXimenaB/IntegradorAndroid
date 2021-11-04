package com.example.integradorandroid

import com.google.gson.annotations.SerializedName

data class PasTime(
    @SerializedName("activity")  var activity : String,
    @SerializedName("type")    var type : String,
    @SerializedName("participants")    var participants : Int,
    @SerializedName("price")    var price: Float
)