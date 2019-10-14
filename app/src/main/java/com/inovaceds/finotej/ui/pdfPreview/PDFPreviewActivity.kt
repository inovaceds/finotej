package com.inovaceds.finotej.ui.pdfPreview

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.inovaceds.finotej.R
import com.inovaceds.finotej.extensions.hide
import com.inovaceds.finotej.extensions.show
import com.inovaceds.finotej.net.DataConfiguration
import com.inovaceds.finotej.ui.dialog.view.SendInformationDialogFragment
import kotlinx.android.synthetic.main.activity_pdf_preview.*

class PDFPreviewActivity : AppCompatActivity() {

    companion object {
        const val PRODUCT_KEY = "product"
        const val DOCUMENT_KEY = "document"
    }

    private var resourceId = 0
    private var product = ""
    private var document = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf_preview)

        setSupportActionBar(toolbar_web_view)

        product = intent.extras?.getString(PRODUCT_KEY, "") ?: ""
        document = intent.extras?.getString(DOCUMENT_KEY, "") ?: ""

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.left_arrow)

        pdf_view_send_information_title?.text = when (product) {
            DataConfiguration.FYNOCORE_PRODUCT -> "FYNOCORE"
            DataConfiguration.CIMBRACORE_PRODUCT -> "CIMBRACORE"
            DataConfiguration.DECOPANEL_PRODUCT -> "DECOPANEL"
            else -> ""
        }

        resourceId = when (product) {
            DataConfiguration.FYNOCORE_PRODUCT -> {
                if (document == DataConfiguration.PP_DOCUMENT) {
                    R.raw.fynocore
                } else {
                    R.raw.fynocore
                }
            }
            DataConfiguration.CIMBRACORE_PRODUCT -> {
                if (document == DataConfiguration.RESUMEN_DOCUMENT) {
                    R.raw.cimbracore
                } else {
                    R.raw.cibracore_ficha
                }
            }
            DataConfiguration.DECOPANEL_PRODUCT -> {
                if (document == DataConfiguration.DECOPANEL_DOCUMENT) {
                    R.raw.decopanel
                } else {
                    0
                }
            }
            else -> 0
        }

        pdf_view_send_information.setOnClickListener {
            openInformationDialog()
        }


        init()
    }


    private fun init() {

        pdf_view.fromStream(resources.openRawResource(resourceId))
            .enableDoubletap(true)
            .defaultPage(0)
            .spacing(5)
            .onRender { _, _, _ ->
                progress_bar_web_view.hide()
                pdf_view_send_information.show()
            }
            .enableAntialiasing(true)
            .load()


    }

    private fun openInformationDialog() {
        val dialog = SendInformationDialogFragment.getInstance(
            product,
            document
        )

        dialog.isCancelable = false
        dialog.show(supportFragmentManager, "SendInformationDialog")
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
