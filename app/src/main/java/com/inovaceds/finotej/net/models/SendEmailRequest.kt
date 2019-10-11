package com.inovaceds.finotej.net.models

import com.google.gson.annotations.SerializedName

data class SendEmailRequest(
    @SerializedName("product") val product: String,
    @SerializedName("email") val email: String,
    @SerializedName("document") val document: String,
    @SerializedName("name") val name: String
) {
}