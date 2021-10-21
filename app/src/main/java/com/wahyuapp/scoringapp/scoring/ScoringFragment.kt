package com.wahyuapp.scoringapp.scoring

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.wahyuapp.scoringapp.R
import com.wahyuapp.scoringapp.databinding.FragmentScoringBinding

class ScoringFragment : Fragment() {

    private lateinit var viewModel: ScoringViewModel
    private lateinit var binding: FragmentScoringBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_scoring, container, false
        )

        // View Model
        viewModel = ViewModelProvider(this).get(ScoringViewModel::class.java)
        binding.scoringViewModel = viewModel
        binding.lifecycleOwner = this

        val args = ScoringFragmentArgs.fromBundle(requireArguments())

        binding.teamName1.text = args.teamName1
        binding.teamName2.text = args.teamName2

        viewModel.initTeam(args.teamName1, args.teamName2)

        viewModel.eventFinish.observe(this, { hasFinish ->
            if (hasFinish) {
                viewModel.reset()
                requireView().findNavController()
                    .navigate(
                        ScoringFragmentDirections.actionScoringFragmentToFinishFragment(
                            viewModel.winner.value.toString()
                        )
                    )
            }
        })

        return binding.root
    }
}
