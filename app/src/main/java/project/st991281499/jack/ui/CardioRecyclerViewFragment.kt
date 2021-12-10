package project.st991281499.jack.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import project.st991281499.jack.CardioViewModel
import project.st991281499.jack.adapter.CardioListAdapter
import project.st991281499.jack.adapter.StrengthListAdapter
import project.st991281499.jack.databinding.FragmentCardioRecyclerViewBinding
import project.st991281499.jack.databinding.FragmentStrengthRecyclerViewBinding
import project.st991281499.jack.viewmodel.StrengthViewModel


class CardioRecyclerViewFragment : Fragment() {



    private val navigationArgs: CardioRecyclerViewFragmentArgs by navArgs()
    private val viewModel: CardioViewModel by activityViewModels()

    private var _binding: FragmentCardioRecyclerViewBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //view binding
        _binding = FragmentCardioRecyclerViewBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = CardioListAdapter(arrayListOf()) {
            val action =
                CardioRecyclerViewFragmentDirections.actionCardioRecyclerViewFragmentToUpdateCardio(it.id, it.duration, it.datetime, it.exerciseType)
            this.findNavController().navigate(action)
        }

        binding.cardioRecyclerView.adapter = adapter

        val recyclerView = binding.cardioRecyclerView

        val exerciseType = navigationArgs.exerciseType

        recyclerView.layoutManager = LinearLayoutManager(this.context)

        viewModel.readCardio(exerciseType).observe(this.viewLifecycleOwner) { cardio ->
            cardio.let {
                adapter.setData(it)
            }
        }


        binding.cardioAddButton.setOnClickListener {
            var action =
                CardioRecyclerViewFragmentDirections.actionCardioRecyclerViewFragmentToCardioEntryFragment(
                    exerciseType
                )
            findNavController().navigate(action)
        }

    }

}