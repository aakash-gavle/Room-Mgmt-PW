package com.example.roommgmtpw.model


import com.google.gson.annotations.SerializedName

data class Facilities(
    val facility: ArrayList<Facility>,
    val exclusion: ArrayList<Exclusion>
)

data class Facility(
    @SerializedName("facility_id")
    val facilityId: String,
    val name: String,
    val options: ArrayList<Option>
)

data class Option(
    val icon: String,
    val id: String,
    val name: String
)

data class Exclusion(
    @SerializedName("facility_id")
    val facilityId: String,
    @SerializedName("options_id")
    val optionsId: String
)