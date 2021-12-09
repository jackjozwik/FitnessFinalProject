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
import project.st991281499.jack.R
import project.st991281499.jack.data.Strength
import project.st991281499.jack.databinding.FragmentStrengthRecyclerViewBinding
import project.st991281499.jack.databinding.FragmentUpdateStrengthBinding
import project.st991281499.jack.viewmodel.StrengthViewModel
import java.time.LocalDateTime


class UpdateStrengthFragment : Fragment() {

    private lateinit var _binding: FragmentUpdateStrengthBinding
    private val binding get() = _binding!!
    private val navigationArgs: UpdateStrengthFragmentArgs by navArgs()

    private val viewModel: StrengthViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentUpdateStrengthBinding.inflate(layoutInflater)
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

        binding.setsEt.setText(navigationArgs.sets)
        binding.repsEt.setText(navigationArgs.reps)
        binding.strDatepicker.updateDate(year, month, day)

        binding.strTimepicker.hour = hour
        binding.strTimepicker.minute = minute

        binding.strUpdateBtn.setOnClickListener {
            val newDay = binding.strDatepicker.dayOfMonth
            val newMonth = binding.strDatepicker.month + 1
            val newYear = binding.strDatepicker.year
            val newHour = binding.strTimepicker.hour
            val newMinute = binding.strTimepicker.minute
            val newDatetime = LocalDateTime.of(newYear, newMonth, newDay, newHour, newMinute).toString()

            val strengthEntry = Strength(navigationArgs.exerciseId, navigationArgs.exerciseType, newDatetime, binding.setsEt.text.toString(), binding.repsEt.text.toString())
            viewModel.updateStrengthEntry(strengthEntry)

            val action = UpdateStrengthFragmentDirections.actionUpdateStrengthToStrengthRecyclerViewFragment(navigationArgs.exerciseType)
            findNavController().navigate(action)
        }

        binding.strDeleteBtn.setOnClickListener {
            val strengthEntry = Strength(navigationArgs.exerciseId, navigationArgs.exerciseType, navigationArgs.datetime, navigationArgs.sets, navigationArgs.reps)

            viewModel.deleteStrengthEntry(strengthEntry)
            val action = UpdateStrengthFragmentDirections.actionUpdateStrengthToStrengthRecyclerViewFragment(navigationArgs.exerciseType)
            findNavController().navigate(action)
        }

    }

}