package project.st991281499.jack.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import project.st991281499.jack.CardioViewModel
import project.st991281499.jack.data.Cardio
import project.st991281499.jack.data.Strength
import project.st991281499.jack.databinding.FragmentUpdateCardioBinding
import java.time.LocalDateTime


class UpdateCardioFragment : Fragment() {

    private lateinit var _binding: FragmentUpdateCardioBinding
    private val binding get() = _binding!!
    private val navigationArgs: UpdateCardioFragmentArgs by navArgs()

    private val viewModel: CardioViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentUpdateCardioBinding.inflate(layoutInflater)
        return binding.root
    }

    @SuppressLint("NewApi")
    @RequiresApi(23)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val year = navigationArgs.datetime.substring(0, 4).toInt()
        val month = (navigationArgs.datetime.substring(5, 7).toInt() -1)
        val day = navigationArgs.datetime.substring(8, 10).toInt()
        val hour = navigationArgs.datetime.substring(11, 13).toInt()
        val minute = navigationArgs.datetime.substring(14, 16).toInt()

        binding.durationEt.setText(navigationArgs.duration)
        binding.carDatepicker.updateDate(year, month, day)

        binding.carTimepicker.hour = hour
        binding.carTimepicker.minute = minute

        binding.carUpdateBtn.setOnClickListener {
            val newDay = binding.carDatepicker.dayOfMonth
            val newMonth = binding.carDatepicker.month + 1
            val newYear = binding.carDatepicker.year
            val newHour = binding.carTimepicker.hour
            val newMinute = binding.carTimepicker.minute
            val newDatetime = LocalDateTime.of(newYear, newMonth, newDay, newHour, newMinute).toString()

            val cardioEntry = Cardio(navigationArgs.exerciseId, navigationArgs.exerciseType, newDatetime, binding.durationEt.text.toString())
            viewModel.updateCardioEntry(cardioEntry)

            val action = UpdateCardioFragmentDirections.actionUpdateCardioToCardioRecyclerViewFragment(navigationArgs.exerciseType)
            findNavController().navigate(action)
        }

        binding.carDeleteBtn.setOnClickListener {
            val cardioEntry = Cardio(navigationArgs.exerciseId, navigationArgs.exerciseType, navigationArgs.datetime, navigationArgs.duration)

            viewModel.deleteCardioEntry(cardioEntry)
            val action = UpdateCardioFragmentDirections.actionUpdateCardioToCardioRecyclerViewFragment(navigationArgs.exerciseType)
            findNavController().navigate(action)
        }

    }

}