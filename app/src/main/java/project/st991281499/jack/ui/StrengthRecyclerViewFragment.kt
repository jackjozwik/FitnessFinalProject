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
import project.st991281499.jack.viewmodel.StrengthViewModel
import project.st991281499.jack.adapter.StrengthListAdapter
import project.st991281499.jack.databinding.FragmentStrengthRecyclerViewBinding

class StrengthRecyclerViewFragment : Fragment() {

    private val navigationArgs: StrengthRecyclerViewFragmentArgs by navArgs()
    private val viewModel: StrengthViewModel by activityViewModels()

    private var _binding: FragmentStrengthRecyclerViewBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //view binding
        _binding = FragmentStrengthRecyclerViewBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = StrengthListAdapter(arrayListOf()) {
            val action =
                StrengthRecyclerViewFragmentDirections.actionStrengthRecyclerViewFragmentToUpdateStrength(it.id, it.sets, it.reps, it.datetime, it.exerciseType)
            this.findNavController().navigate(action)
        }

        binding.strengthRecyclerView.adapter = adapter

        val recyclerView = binding.strengthRecyclerView

        val exerciseType = navigationArgs.exerciseName

        recyclerView.layoutManager = LinearLayoutManager(this.context)

        viewModel.readStrength(exerciseType).observe(this.viewLifecycleOwner) { strengths ->
            strengths.let {
                adapter.setData(it)
            }
        }

        binding.strAddButton.setOnClickListener {
            var action =
                StrengthRecyclerViewFragmentDirections.actionStrengthRecyclerViewFragmentToStrengthEntryFragment(
                    exerciseType
                )
            findNavController().navigate(action)
        }

    }


}