package project.st991281499.jack

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import project.st991281499.jack.databinding.FragmentStrengthExercisesBinding


class StrengthExercisesFragment : Fragment() {

    private lateinit var binding: FragmentStrengthExercisesBinding
    private val navigationArgs: StrengthExercisesFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentStrengthExercisesBinding.inflate(layoutInflater)
        var exercises = arrayListOf<String>()

        var exerciseType = ""

        when(navigationArgs.exerciseType){
            "Chest"-> exercises = arrayListOf("Bench Press", "Pec Deck")
            "Back"->exercises = arrayListOf("Dead Lift", "Rows")
            "Arms"->exercises = arrayListOf("Dumbbell Curls", "Tricep Extensions")
            "Legs"->exercises = arrayListOf("Squats", "Leg Press")
        }

        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.list_card, exercises)

        var mListView: ListView = binding.exListView

        mListView.setAdapter(arrayAdapter)

        mListView.setOnItemClickListener{ parent, view, position, id ->
            val element = (arrayAdapter.getItem(position))
            when (element){
                "Bench Press" -> exerciseType = "Chest"
                "Back" -> exerciseType = "Back"
                "Arms" -> exerciseType = "Arms"
                "Legs" -> exerciseType = "Legs"
            }
            var action = StrengthExercisesFragmentDirections.actionStrengthExercisesFragmentToStrengthEntryFragment()
            findNavController().navigate(action)
        }

        return (binding.root)
    }

}