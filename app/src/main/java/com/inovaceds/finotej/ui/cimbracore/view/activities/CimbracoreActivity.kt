package com.inovaceds.finotej.ui.cimbracore.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import androidx.core.text.HtmlCompat
import com.inovaceds.finotej.R
import com.inovaceds.finotej.net.DataConfiguration
import com.inovaceds.finotej.ui.dialog.view.SendInformationDialogFragment
import kotlinx.android.synthetic.main.activity_cimbracore.*

class CimbracoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cimbracore)


        activity_cimbracore_resume.text = HtmlCompat.fromHtml("<b>Resumen</b> Cimbracore",HtmlCompat.FROM_HTML_MODE_LEGACY)
        activity_cimbracore_tech_doc.text = HtmlCompat.fromHtml("<b>Ficha Técnica</b> Cimbracore",HtmlCompat.FROM_HTML_MODE_LEGACY)


        activity_cimbracore_resume.setOnClickListener {
            val dialog = SendInformationDialogFragment.getInstance(DataConfiguration.CIMBRACORE_PRODUCT,DataConfiguration.RESUMEN_DOCUMENT)

            dialog.isCancelable = false
            dialog.show(supportFragmentManager,"SendInformationDialog")
        }

        activity_cimbracore_tech_doc.setOnClickListener {
            val dialog = SendInformationDialogFragment.getInstance(DataConfiguration.CIMBRACORE_PRODUCT,DataConfiguration.FICHA_DOCUMENT)

            dialog.isCancelable = false
            dialog.show(supportFragmentManager,"SendInformationDialog")
        }

    }

}
