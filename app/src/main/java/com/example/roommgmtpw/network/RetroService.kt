package com.example.roommgmtpw.network

import com.example.roommgmtpw.model.Facility
import retrofit2.http.GET

interface RetroService {

    @GET("ricky1550/pariksha/db")
    suspend fun getFacilities(): Facility

}