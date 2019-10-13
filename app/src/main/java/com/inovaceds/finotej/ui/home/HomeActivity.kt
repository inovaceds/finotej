package com.inovaceds.finotej.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import androidx.core.view.isVisible
import com.inovaceds.finotej.R
import com.inovaceds.finotej.extensions.hide
import com.inovaceds.finotej.extensions.show
import com.inovaceds.finotej.net.DataConfiguration
import com.inovaceds.finotej.ui.cimbracore.view.activities.CimbracoreActivity
import com.inovaceds.finotej.ui.fynocore.view.activities.FynocorePPActivity
import com.inovaceds.finotej.ui.fynocore.view.activities.FynocorePPSBActivity
import com.inovaceds.finotej.ui.pdfPreview.PDFPreviewActivity
import kotlinx.android.synthetic.main.activity_home.*
import org.jetbrains.anko.startActivity

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val firstBoldCimbracoreText = getText(R.string.cimbracore_description_first_bold)
        val firstCimbracoreText = getText(R.string.cimbracore_description_text)

        activity_home_cimbracore_description_text.text = HtmlCompat.fromHtml(
            "<b>$firstBoldCimbracoreText</b><br>$firstCimbracoreText",
            HtmlCompat.FROM_HTML_MODE_LEGACY
        )

        val firstDecopanelText = getText(R.string.decopanel_description_first)
        val firstDecopanelBoldText = getText(R.string.decopanel_description_first_bold)
        val secondDecopanelText = getText(R.string.decopanel_description_second)
        val secondDecopanelBoldText = getText(R.string.decopanel_description_second_bold)

        activity_home_decopanel_description_text.text = HtmlCompat.fromHtml(
            "$firstDecopanelText <b>$firstDecopanelBoldText</b> $secondDecopanelText <b>$secondDecopanelBoldText</b>",
            HtmlCompat.FROM_HTML_MODE_LEGACY
        )


        activity_home_fynocore_logo_container.setOnClickListener {

            if (!activity_home_fynocore_items_container.isVisible) {
                activity_home_fynocore_items_container.show()
            } else {
                activity_home_fynocore_items_container.hide()
            }

        }

        activity_home_cimbracore_logo_container.setOnClickListener {

            if (!activity_home_cimbracore_items_container.isVisible) {
                activity_home_cimbracore_items_container.show()
            } else {
                activity_home_cimbracore_items_container.hide()
            }

        }

        activity_home_decopanel_logo_container.setOnClickListener {

            if (!activity_home_decopanel_items_container.isVisible) {
                activity_home_decopanel_items_container.show()
            } else {
                activity_home_decopanel_items_container.hide()
            }

        }

        activity_home_fynocore_pp_container.setOnClickListener {
            startActivity<FynocorePPActivity>()

        }

        activity_home_fynocore_ppsb_container.setOnClickListener {
            startActivity<FynocorePPSBActivity>()
        }

        activity_home_cimbracore_success_cases_container.setOnClickListener {
            startActivity<CimbracoreActivity>()
        }

        activity_home_decopanel_success_cases_container.setOnClickListener {
            startActivity<PDFPreviewActivity>(
                PDFPreviewActivity.DOCUMENT_KEY to DataConfiguration.DECOPANEL_DOCUMENT,
                PDFPreviewActivity.PRODUCT_KEY to DataConfiguration.DECOPANEL_PRODUCT
            )
        }


    }
}
