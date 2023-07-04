package com.example.hw

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.hw.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {
    private var binding: FragmentMainBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)


        binding?.run {
            button.setOnClickListener{
                findNavController().navigate(R.id.action_mainFragment_to_asanFragment)
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}