package com.wahyuapp.scoringapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.wahyuapp.scoringapp.databinding.FragmentFinishBinding


class FinishFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentFinishBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_finish, container, false
        )

        var args = FinishFragmentArgs.fromBundle(requireArguments())

         binding.resultText.text = args.result + " menang!! "

        return binding.root
    }

}
