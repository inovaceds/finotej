package com.inovaceds.finotej.ui.dialog.presentation

import android.util.Log
import com.inovaceds.finotej.core.coroutineScopes.NetworkCallCoroutineScope
import com.inovaceds.finotej.net.models.SendEmailRequest
import com.inovaceds.finotej.net.retrofit.RetrofitClient
import com.inovaceds.finotej.net.services.SendEmailService
import com.inovaceds.finotej.ui.dialog.viewModel.SendInformationViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SendInformationPresenter(private val sendInformationViewModel: SendInformationViewModel) :
    NetworkCallCoroutineScope() {

    private val sendEmailService: SendEmailService by lazy {
        RetrofitClient.create<SendEmailService>()
    }

    init {
        init()
    }


    fun sendInformation(name: String, email: String, product: String, document: String) {

        this.launch {
            try {
                val response = sendEmailService.sendEmailAsync(
                    SendEmailRequest(
                        product,
                        email,
                        document,
                        name
                    )
                )
                    .await()

                if (response.isSuccessful) {
                    withContext(Dispatchers.Main) {
                        sendInformationViewModel.onInformationSend()
                    }
                } else {

                    withContext(Dispatchers.Main) {
                        sendInformationViewModel.onError()
                    }
                }
            } catch (e: Exception) {
                Log.e("Error", e.message ?: "")
                withContext(Dispatchers.Main) {
                    sendInformationViewModel.onError()
                }
            }
        }

    }

}