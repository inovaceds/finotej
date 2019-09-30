package com.inovaceds.finotej.ui.description

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import androidx.core.text.HtmlCompat
import com.inovaceds.finotej.R
import kotlinx.android.synthetic.main.activity_description.*

class DescriptionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)


        activity_description_main_text.text = HtmlCompat.fromHtml(getString(R.string.first_description_text),HtmlCompat.FROM_HTML_MODE_LEGACY)


    }
}
