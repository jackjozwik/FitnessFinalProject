package project.st991281499.jack

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import project.st991281499.jack.databinding.FragmentCardioRecyclerViewBinding


class CardioRecyclerViewFragment : Fragment() {

    private lateinit var binding: FragmentCardioRecyclerViewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //view binding
        binding = FragmentCardioRecyclerViewBinding.inflate(layoutInflater)

        //button nav to entry page
        binding.cardioAddButton.setOnClickListener{
            var action = CardioRecyclerViewFragmentDirections.actionCardioRecyclerViewFragmentToCardioEntryFragment()
            findNavController().navigate(action)
        }
        return (binding.root)
    }
}