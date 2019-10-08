package com.inovaceds.finotej.ui.fynocore.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.inovaceds.finotej.R
import com.inovaceds.finotej.ui.fynocore.view.activities.FynocorePPActivity
import kotlinx.android.synthetic.main.fragment_fynocore_ppmenu.*

class FynocorePPMenuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fynocore_ppmenu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragment_fynocore_pp_option.setOnClickListener {
            (activity as FynocorePPActivity).changeOptionFragment(
                FynocorePPDetailFragment(),
                "FynocorePPDetail"
            )
        }
    }

}
