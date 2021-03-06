package com.example.android.navigation

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentTitleBinding>(inflater,
        R.layout.fragment_title, container, false)

        // play button
        binding.playButton.setOnClickListener{
            view: View -> view.findNavController().navigate(R.id.action_titleFragmentN_to_gameFragment)
        }

        // rules button
        binding.rulesButton.setOnClickListener{
            view: View -> view.findNavController().navigate(R.id.action_titleFragmentN_to_rulesFragment)
        }

        // about button
        binding.aboutButton.setOnClickListener{
            view: View -> view.findNavController().navigate(R.id.action_titleFragmentN_to_aboutFragment)
        }

        // set the options menu (the three dots)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.
                onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

}