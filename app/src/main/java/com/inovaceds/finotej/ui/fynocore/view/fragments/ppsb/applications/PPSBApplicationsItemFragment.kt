package com.inovaceds.finotej.ui.fynocore.view.fragments.ppsb.applications


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.api.load

import com.inovaceds.finotej.R
import kotlinx.android.synthetic.main.fragment_ppsbapplications_item.*

/**
 * A simple [Fragment] subclass.
 */
class PPSBApplicationsItemFragment : Fragment() {

    companion object{
        fun getInstance(title : String, imageId:Int) : Fragment{
            val fragment = PPSBApplicationsItemFragment()

            fragment.title =title
            fragment.imageId = imageId

            return fragment
        }

    }


    var title = ""
    var imageId = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ppsbapplications_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        fragment_ppsb_applications_title.text = title

        fragment_ppsb_applications_image.load(imageId){
            crossfade(true)
        }
    }

}
