package com.example.roommgmtpw.network

import com.example.roommgmtpw.model.Facilities
import retrofit2.http.GET

interface RetroService {

    @GET("ricky1550/pariksha/db")
    suspend fun getFacilities(): Facilities
}