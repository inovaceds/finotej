package com.inovaceds.finotej.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import androidx.core.view.isVisible
import com.inovaceds.finotej.R
import com.inovaceds.finotej.extensions.hide
import com.inovaceds.finotej.extensions.show
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        activity_home_cimbracore_description_text.text = HtmlCompat.fromHtml(
            getString(R.string.cibracore_description_text),
            HtmlCompat.FROM_HTML_MODE_LEGACY
        )
        activity_home_decopanel_description_text.text = HtmlCompat.fromHtml(
            getString(R.string.decopanel_description),
            HtmlCompat.FROM_HTML_MODE_LEGACY
        )


        activity_home_fynocore_logo_container.setOnClickListener {

            if (!activity_home_fynocore_items_container.isVisible) {
                activity_home_fynocore_items_container.show()
            } else {
                activity_home_fynocore_items_container.hide()
            }

        }

    }
}
