package project.st991281499.jack

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.navigation.fragment.findNavController


class StrengthFragment : Fragment() {

    //private lateinit var binding: FragmentStrengthBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_strength, container, false)
        //binding = FragmentStrengthBinding.inflate(layoutInflater)

        val exercises = listOf<String>("Chest","Back","Arms","Legs")
        var exerciseType = "Test"

        var mListView: ListView = view.findViewById(R.id.list_view) //binding.listView

        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.list_card, exercises)

        mListView.setAdapter(arrayAdapter)



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

        return view
    }

//    override fun onViewCreated() {
//        val listView = binding.listView as ListView
//        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listOf("Arms", "Legs", "Chest", "Back"))
//        listView.adapter = adapter
//    }

}

