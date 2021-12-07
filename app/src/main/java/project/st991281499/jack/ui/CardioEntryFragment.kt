package project.st991281499.jack.ui

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.activityViewModels
import project.st991281499.jack.data.Cardio
import project.st991281499.jack.databinding.FragmentCardioEntryBinding
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import project.st991281499.jack.CardioViewModel
import project.st991281499.jack.CardioViewModelFactory
import project.st991281499.jack.FitnessApplication
import java.time.LocalDateTime


class CardioEntryFragment : Fragment() {

    lateinit var cardio: Cardio
    private val navigationArgs: CardioEntryFragmentArgs by navArgs()


    private val viewModel: CardioViewModel by activityViewModels {
        CardioViewModelFactory(
            (activity?.application as FitnessApplication).database
                .cardioDao()
        )
    }

    private var _binding: FragmentCardioEntryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCardioEntryBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun isEntryValid(exerciseType: String, datetime: String, duration: String): Boolean {
        return viewModel.isEntryValid(
            exerciseType,
            datetime,
            duration
        )
    }

    @SuppressLint("NewApi")
    private fun addNewCardio() {
        val day = binding.cardioDatepicker.dayOfMonth
        val month = binding.cardioDatepicker.month
        val year = binding.cardioDatepicker.year
        val hour = binding.cardioTimepicker.hour
        val minute = binding.cardioTimepicker.minute
        val dt = LocalDateTime.of(year, month, day, hour, minute).toString()

        val exerciseType = navigationArgs.exerciseType

        val duration = binding.durationEt.text.toString()

        if (isEntryValid(exerciseType, dt, duration)) {
            viewModel.addNewCardio(
                exerciseType,
                dt,
                duration
            )
            val action = CardioEntryFragmentDirections.actionCardioEntryFragmentToCardioFragment()
            findNavController().navigate(action)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cardioDoneBtn.setOnClickListener {
            addNewCardio()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        val inputMethodManager = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as
                InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(requireActivity().currentFocus?.windowToken, 0)
        _binding = null
    }

}