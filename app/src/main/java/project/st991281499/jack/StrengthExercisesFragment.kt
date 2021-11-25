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

        //view binding
        binding = FragmentStrengthExercisesBinding.inflate(layoutInflater)

        //empty list to be populated based on selection from previous listview
        var exercises = arrayListOf<String>()
        //nav argument passed to next list
        var exerciseType = ""

        when(navigationArgs.exerciseType){
            "Chest"-> exercises = arrayListOf("Bench Press", "Pec Deck")
            "Back"->exercises = arrayListOf("Dead Lift", "Rows")
            "Arms"->exercises = arrayListOf("Dumbbell Curls", "Tricep Extensions")
            "Legs"->exercises = arrayListOf("Squats", "Leg Press")
        }

        //binding listview to ui element
        var mListView: ListView = binding.strExListView

        //adapter for listview
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.list_card, exercises)
        mListView.setAdapter(arrayAdapter)

        //onclick events for each list item
        mListView.setOnItemClickListener{ parent, view, position, id ->
            val element = (arrayAdapter.getItem(position))
            when (element){
                "Bench Press" -> exerciseType = "Bench Press"
                "Pec Deck" -> exerciseType = "Pec Deck"
                "Dead Lift" -> exerciseType = "Dead Lift"
                "Rows" -> exerciseType = "Rows"
                "Dumbbell Curls" -> exerciseType = "Dumbbell Curls"
                "Tricep Extensions" -> exerciseType = "Tricep Extensions"
                "Squats" -> exerciseType = "Squats"
                "Leg Press" -> exerciseType = "Leg Press"
            }
            var action = StrengthExercisesFragmentDirections.actionStrengthExercisesFragmentToStrengthRecyclerViewFragment(exerciseType)
            findNavController().navigate(action)
        }
        return (binding.root)
    }

}