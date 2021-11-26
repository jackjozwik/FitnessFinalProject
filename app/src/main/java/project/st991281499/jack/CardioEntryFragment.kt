package project.st991281499.jack

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import project.st991281499.jack.databinding.FragmentCardioEntryBinding


class CardioEntryFragment : Fragment() {

    private lateinit var binding: FragmentCardioEntryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //view binding
        binding = FragmentCardioEntryBinding.inflate(layoutInflater)

        return (binding.root)
    }

}