package com.inovaceds.finotej.ui.dialog.view


import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.google.android.material.snackbar.Snackbar
import com.inovaceds.finotej.R
import com.inovaceds.finotej.extensions.hide
import com.inovaceds.finotej.extensions.hideKeyboard
import com.inovaceds.finotej.extensions.show
import com.inovaceds.finotej.ui.dialog.presentation.SendInformationPresenter
import com.inovaceds.finotej.ui.dialog.viewModel.SendInformationViewModel
import kotlinx.android.synthetic.main.fragment_send_information_dialog.*

class SendInformationDialogFragment : DialogFragment(), SendInformationViewModel {

    companion object {

        fun getInstance(product: String, document: String): DialogFragment {
            val dialogFragment = SendInformationDialogFragment()

            dialogFragment.product = product
            dialogFragment.document = document

            return dialogFragment
        }

    }

    override fun onStart() {
        super.onStart()

        val width =
            TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                resources.getInteger(R.integer.send_information_dialog_title_width).toFloat(),
                resources.displayMetrics
            )
        val height =
            TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                resources.getInteger(R.integer.send_information_dialog_title_height).toFloat(),
                resources.displayMetrics
            )
        dialog?.window?.setLayout(width.toInt(), height.toInt())

    }

    private var product = ""
    private var document = ""

    private val sendInformationPresenter: SendInformationPresenter by lazy {
        SendInformationPresenter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_send_information_dialog, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        fragment_send_information_close_icon.setOnClickListener {
            dismiss()
        }

        fragment_send_information_send.setOnClickListener {

            context?.hideKeyboard(it)

            if (fragment_send_information_name_field.text.isEmpty()) {
                fragment_send_information_name_field.error = "Debes ingresar un nombre"
                return@setOnClickListener
            }

            if (fragment_send_information_email_field.text.isEmpty()) {
                fragment_send_information_email_field.error = "Debes ingresar un correo"
                return@setOnClickListener
            }

            val email = fragment_send_information_email_field.text.toString()

            if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {

                fragment_send_information_progress_bar.show()
                fragment_send_information_items_container.hide()
                fragment_send_information_close_icon.hide()

                val name = fragment_send_information_name_field.text.toString()

                sendInformationPresenter.sendInformation(name, email, product, document)
            } else {
                fragment_send_information_email_field.error = "El email debe ser valido"
                return@setOnClickListener
            }
        }

        Log.e("Document", document)
        Log.e("Product", product)
    }

    override fun onInformationSend() {
        fragment_send_information_progress_bar.hide()
        fragment_send_information_close_icon.show()
        fragment_send_information_items_container_sended.show()
    }

    override fun onDismiss(dialog: DialogInterface) {
        sendInformationPresenter.destroy()
        super.onDismiss(dialog)
    }

    override fun onError() {
        Snackbar.make(
            fragment_send_information_main_container,
            "Ha ocurrido un error intenta nuevamente",
            Snackbar.LENGTH_LONG
        ).show()
        fragment_send_information_progress_bar.hide()
        fragment_send_information_items_container.show()
        fragment_send_information_close_icon.show()
    }
}
