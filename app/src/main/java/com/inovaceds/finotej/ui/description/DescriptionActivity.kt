package com.inovaceds.finotej.ui.description

import android.os.Bundle
import android.os.Handler
import android.text.Html
import androidx.appcompat.app.AppCompatActivity
import com.inovaceds.finotej.R
import com.inovaceds.finotej.extensions.show
import com.inovaceds.finotej.ui.home.HomeActivity
import kotlinx.android.synthetic.main.activity_description.*
import org.jetbrains.anko.startActivity

class DescriptionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)

        val firstDescriptionText = getText(R.string.first_description_text)
        val firstDescriptionBoldText = getText(R.string.first_description_bold_text)

        activity_description_main_text.text = Html.fromHtml(
            "$firstDescriptionText <b>$firstDescriptionBoldText</b>"
        )

    }

    override fun onResume() {
        super.onResume()

        val handler = Handler(mainLooper)

        handler.postDelayed(
            {
                activity_description_main_text.show()
            },
            1000
        )

        handler.postDelayed(
            {
                activity_description_secondary_text.show()
            },
            4000
        )

        handler.postDelayed(
            {
                activity_description_first_element.show()
                activity_description_second_element.show()
                activity_description_third_element.show()
            },
            7000
        )

        handler.postDelayed(
            {
                activity_description_third_text.show()
            },
            10000
        )

        handler.postDelayed(
            {
                activity_description_touch_to_next.show()
                activity_description_touch_trigger.apply {
                    setOnClickListener {
                        startActivity<HomeActivity>()
                    }
                }
            },
            12000
        )


    }
}
