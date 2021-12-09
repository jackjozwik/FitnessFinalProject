package project.st991281499.jack.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import project.st991281499.jack.databinding.FragmentCardioRecyclerViewBinding


class CardioRecyclerViewFragment : Fragment() {

    private lateinit var binding: FragmentCardioRecyclerViewBinding
    private val navigationArgs: CardioRecyclerViewFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //view binding
        binding = FragmentCardioRecyclerViewBinding.inflate(layoutInflater)

        //button nav to entry page
        val exerciseType = navigationArgs.exerciseType
        binding.cardioAddButton.setOnClickListener{
            var action = CardioRecyclerViewFragmentDirections.actionCardioRecyclerViewFragmentToCardioEntryFragment(exerciseType)
            findNavController().navigate(action)
        }
        return (binding.root)
    }
}