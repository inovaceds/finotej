package com.inovaceds.finotej.ui.cimbracore.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import com.inovaceds.finotej.R
import com.inovaceds.finotej.net.DataConfiguration
import com.inovaceds.finotej.ui.pdfPreview.PDFPreviewActivity
import kotlinx.android.synthetic.main.activity_cimbracore.*
import org.jetbrains.anko.startActivity

class CimbracoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cimbracore)


        activity_cimbracore_resume.text = HtmlCompat.fromHtml("<b>Resumen</b> Cimbracore",HtmlCompat.FROM_HTML_MODE_LEGACY)
        activity_cimbracore_tech_doc.text = HtmlCompat.fromHtml("<b>Ficha Técnica</b> Cimbracore",HtmlCompat.FROM_HTML_MODE_LEGACY)


        activity_cimbracore_resume.setOnClickListener {
            startActivity<PDFPreviewActivity>(
                PDFPreviewActivity.DOCUMENT_KEY to DataConfiguration.RESUMEN_DOCUMENT,
                PDFPreviewActivity.PRODUCT_KEY to DataConfiguration.CIMBRACORE_PRODUCT
            )
        }

        activity_cimbracore_tech_doc.setOnClickListener {
            startActivity<PDFPreviewActivity>(
                PDFPreviewActivity.DOCUMENT_KEY to DataConfiguration.FICHA_DOCUMENT,
                PDFPreviewActivity.PRODUCT_KEY to DataConfiguration.CIMBRACORE_PRODUCT
            )

        }

    }

}
