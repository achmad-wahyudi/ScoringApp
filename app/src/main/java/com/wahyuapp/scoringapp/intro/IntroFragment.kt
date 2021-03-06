package com.wahyuapp.scoringapp.intro


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.wahyuapp.scoringapp.R
import com.wahyuapp.scoringapp.databinding.FragmentIntroBinding


class IntroFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentIntroBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_intro, container, false
        )

        binding.startBtn.setOnClickListener {
            requireView().findNavController().navigate(
                IntroFragmentDirections.actionIntroFragmentToScoringFragment(
                    binding.teamName1.text.toString(), binding.teamName2.text.toString()
                )
            )
        }

        return binding.root
    }


}
