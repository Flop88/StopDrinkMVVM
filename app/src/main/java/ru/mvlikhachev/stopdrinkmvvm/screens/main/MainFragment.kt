package ru.mvlikhachev.stopdrinkmvvm.screens.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import ru.mvlikhachev.stopdrinkmvvm.R
import ru.mvlikhachev.stopdrinkmvvm.databinding.FragmentMainBinding
import ru.mvlikhachev.stopdrinkmvvm.utilits.APP_ACTIVITY

class MainFragment : Fragment() {

    private var _binding : FragmentMainBinding? = null
    private val mBinding get() = _binding!!

    private lateinit var mViewModel: MainFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(layoutInflater, container,false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        mViewModel = ViewModelProvider(this).get(MainFragmentViewModel::class.java)
        mBinding.bottomNavigationView.setOnNavigationItemSelectedListener {item ->
            when(item.itemId) {
                R.id.profile_page -> {
                    APP_ACTIVITY.mNavController.navigate(R.id.action_mainFragment_to_profileFragment)
                }
            }
            return@setOnNavigationItemSelectedListener true
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}