package com.wahyuapp.scoringapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.wahyuapp.scoringapp.databinding.FragmentScoringBinding

class ScoringFragment : Fragment() {

    var team1_score = 0
    var team2_score = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentScoringBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_scoring, container, false
        )

        var args = ScoringFragmentArgs.fromBundle(requireArguments())

        binding.teamName1.text = args.teamName1
        binding.teamName2.text = args.teamName2

        binding.scoreBtn1.setOnClickListener {
            team1_score++
            binding.scoreNum1.text = team1_score.toString()
            checkIfDone(team1_score, args.teamName1)
        }

        binding.scoreBtn2.setOnClickListener {
            team2_score++
            binding.scoreNum2.text = team2_score.toString()
            checkIfDone(team2_score, args.teamName2)
        }


        return binding.root
    }

    fun checkIfDone(score: Int, name: String) {
        if (score >= 3) {
            requireView().findNavController()
                .navigate(ScoringFragmentDirections.actionScoringFragmentToFinishFragment(name))
        }
    }


}
