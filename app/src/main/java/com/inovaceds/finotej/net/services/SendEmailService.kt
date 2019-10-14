package com.inovaceds.finotej.net.services

import com.inovaceds.finotej.net.DataConfiguration
import com.inovaceds.finotej.net.models.SendEmailRequest
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface SendEmailService {

    @POST(DataConfiguration.SEND_MESSAGE_ENDPOINT)
    @Headers("Content-type: application/json")
    fun sendEmailAsync(@Body sendEmailRequest: SendEmailRequest): Deferred<Response<Void>>

}