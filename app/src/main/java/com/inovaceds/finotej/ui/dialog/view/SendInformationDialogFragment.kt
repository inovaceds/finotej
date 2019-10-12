package com.inovaceds.finotej.ui.dialog.view


import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.inovaceds.finotej.R
import com.inovaceds.finotej.extensions.hide
import com.inovaceds.finotej.extensions.show
import kotlinx.android.synthetic.main.fragment_send_information_dialog.*


/**
 * A simple [Fragment] subclass.
 */
class SendInformationDialogFragment : DialogFragment() {

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
            TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1000f, resources.displayMetrics)
        val height =
            TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 500f, resources.displayMetrics)
        dialog?.window?.setLayout(width.toInt(), height.toInt())

    }

    var product = ""
    var document = ""

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
            fragment_send_information_progress_bar.show()
            fragment_send_information_items_container.hide()
            fragment_send_information_close_icon.hide()
        }

        Log.e("Document", document)
        Log.e("Product", product)
    }


}
