package project.st991281499.jack

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import project.st991281499.jack.data.Cardio
import project.st991281499.jack.databinding.FragmentCardioEntryBinding


class CardioEntryFragment : Fragment() {

    private val viewModel: CardioViewModel by activityViewModels {
        CardioViewModelFactory(
            (activity?.application as FitnessApplication).database
                .cardioDao()
        )
    }

    lateinit var cardio: Cardio

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

}