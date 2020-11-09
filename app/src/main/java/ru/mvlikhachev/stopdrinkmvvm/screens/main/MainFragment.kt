package ru.mvlikhachev.stopdrinkmvvm.screens.main

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import ru.mvlikhachev.stopdrinkmvvm.R
import ru.mvlikhachev.stopdrinkmvvm.databinding.FragmentMainBinding
import ru.mvlikhachev.stopdrinkmvvm.models.User
import ru.mvlikhachev.stopdrinkmvvm.utilits.APP_ACTIVITY
import ru.mvlikhachev.stopdrinkmvvm.utilits.calculateTimeWithoutDrink
import ru.mvlikhachev.stopdrinkmvvm.utilits.showToast

class MainFragment : Fragment() {

    private var _binding : FragmentMainBinding? = null
    private val mBinding get() = _binding!!

    private lateinit var mViewModel: MainFragmentViewModel

    private lateinit var currentUser: User
    private lateinit var userName: String
    private lateinit var userDate: String
    private lateinit var daysWithoudDrink: Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    private fun initialization() {

        GlobalScope.launch(Dispatchers.IO) {
            currentUser = mViewModel.getCurrentUser(1)
            userName = currentUser.name
            userDate = currentUser.dateWhenStopDrink

            mBinding.helloUsernameTextView.text = "Здраствуйте, $userName"

            val mainHandler = Handler(Looper.getMainLooper())

            mainHandler.post(object : Runnable {
                override fun run() {
                    //set date
                    daysWithoudDrink = calculateTimeWithoutDrink(userDate)!!
                    mBinding.daysTextView.text = "${daysWithoudDrink[0]} дней"
                    mBinding.timeTextView.text = "${daysWithoudDrink[1]}:${daysWithoudDrink[2]}"
                    mainHandler.postDelayed(this, 30000)
                }
            })
        }

        mViewModel = ViewModelProvider(this).get(MainFragmentViewModel::class.java)

        mBinding.bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.profile_page -> {
                    APP_ACTIVITY.mNavController.navigate(R.id.action_mainFragment_to_profileFragment)
                }
            }
            return@setOnNavigationItemSelectedListener true
        }
    }

    private fun setTime() {

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