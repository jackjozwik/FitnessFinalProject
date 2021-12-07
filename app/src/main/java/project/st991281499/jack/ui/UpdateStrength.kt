package project.st991281499.jack.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import project.st991281499.jack.R
import project.st991281499.jack.databinding.FragmentUpdateStrengthBinding


class UpdateStrength : Fragment() {

    private lateinit var binding: FragmentUpdateStrengthBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_update_strength, container, false)
    }


}