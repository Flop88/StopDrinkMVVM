package ru.mvlikhachev.stopdrinkmvvm.screens.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import ru.mvlikhachev.stopdrinkmvvm.R
import ru.mvlikhachev.stopdrinkmvvm.databinding.FragmentMainBinding
import ru.mvlikhachev.stopdrinkmvvm.databinding.FragmentProfileBinding
import ru.mvlikhachev.stopdrinkmvvm.screens.main.MainFragmentViewModel
import ru.mvlikhachev.stopdrinkmvvm.utilits.APP_ACTIVITY

class ProfileFragment : Fragment() {

    private var _binding : FragmentProfileBinding ? = null
    private val mBinding get() = _binding!!

    private lateinit var mViewModel: ProfileFragmentViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(layoutInflater, container,false)
        return mBinding.root
    }

    private fun initialization() {
        mViewModel = ViewModelProvider(this).get(ProfileFragmentViewModel::class.java)
        mBinding.bottomNavigationView.setOnNavigationItemSelectedListener {item ->
            when(item.itemId) {
                R.id.main_page -> {
                    APP_ACTIVITY.mNavController.navigate(R.id.action_profileFragment_to_mainFragment)
                }
            }
            return@setOnNavigationItemSelectedListener true
        }
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}