package project.st991281499.jack

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import project.st991281499.jack.databinding.FragmentStrengthRecyclerViewBinding

class StrengthRecyclerViewFragment : Fragment() {

    private lateinit var binding: FragmentStrengthRecyclerViewBinding
    private val navigationArgs: StrengthRecyclerViewFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //view binding
        binding = FragmentStrengthRecyclerViewBinding.inflate(layoutInflater)

        val exerciseType = navigationArgs.exerciseName
        //button nav to entry page
        binding.strAddButton.setOnClickListener{
            var action = StrengthRecyclerViewFragmentDirections.actionStrengthRecyclerViewFragmentToStrengthEntryFragment(exerciseType)
            findNavController().navigate(action)
        }

        return (binding.root)
    }

}