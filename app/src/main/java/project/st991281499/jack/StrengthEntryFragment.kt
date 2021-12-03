package project.st991281499.jack

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import project.st991281499.jack.data.Strength
import project.st991281499.jack.databinding.FragmentStrengthEntryBinding
import java.time.LocalDateTime


class StrengthEntryFragment : Fragment() {

    private var _binding: FragmentStrengthEntryBinding? = null
    private val binding get() = _binding!!

    lateinit var strength: Strength
    private val navigationArgs: StrengthEntryFragmentArgs by navArgs()

    private val viewModel: StrengthViewModel by activityViewModels {
        StrengthViewModelFactory(
            (activity?.application as FitnessApplication).database.strengthDao()
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentStrengthEntryBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun isEntryValid(exerciseType: String, datetime: String, sets: String, reps: String): Boolean {
        return viewModel.isEntryValid(
            exerciseType,
            datetime,
            sets,
            reps
        )
    }

    @SuppressLint("NewApi")
    private fun addNewStrength() {
        val day = binding.strDatepicker.dayOfMonth
        val month = binding.strDatepicker.month
        val year = binding.strDatepicker.year
        val hour = binding.strTimepicker.hour
        val minute = binding.strTimepicker.minute
        val datetime = LocalDateTime.of(year, month, day, hour, minute).toString()

        val exerciseType = navigationArgs.exerciseType

        val sets = binding.setsEt.text.toString()
        val reps = binding.repsEt.text.toString()

        if (isEntryValid(exerciseType, datetime, sets, reps)) {
            viewModel.addNewStrength(
                exerciseType,
                datetime,
                sets,
                reps
            )

            val action = StrengthEntryFragmentDirections.actionStrengthEntryFragmentToStrengthFragment()
            findNavController().navigate(action)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.strDoneBtn.setOnClickListener{
            addNewStrength()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        val inputMethodManager = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(requireActivity().currentFocus?.windowToken, 0)
        _binding = null
    }
}