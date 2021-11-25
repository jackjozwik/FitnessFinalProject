package project.st991281499.jack

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.navigation.fragment.findNavController
import project.st991281499.jack.databinding.FragmentStrengthBinding


class StrengthFragment : Fragment() {

    private lateinit var binding: FragmentStrengthBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        //view binding
        binding = FragmentStrengthBinding.inflate(layoutInflater)

        //listview items
        val exercises = listOf<String>("Chest","Back","Arms","Legs")
        //nav argument passed to next list
        var exerciseType = ""

        //binding listview to ui element
        var mListView: ListView = binding.listView

        //adapter for listview
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.list_card, exercises)
        mListView.setAdapter(arrayAdapter)

        //onClick navigation to next list
        mListView.setOnItemClickListener{ parent, view, position, id ->
            val element = (arrayAdapter.getItem(position))
            when (element){
                "Chest" -> exerciseType = "Chest"
                "Back" -> exerciseType = "Back"
                "Arms" -> exerciseType = "Arms"
                "Legs" -> exerciseType = "Legs"
            }
            var action = StrengthFragmentDirections.actionStrengthFragmentToStrengthExercisesFragment(exerciseType)
            findNavController().navigate(action)
        }
        return (binding.root)
    }

}

