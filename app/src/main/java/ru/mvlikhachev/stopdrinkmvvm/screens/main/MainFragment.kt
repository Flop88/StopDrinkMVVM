package ru.mvlikhachev.stopdrinkmvvm.screens.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.navArgument
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import ru.mvlikhachev.stopdrinkmvvm.R
import ru.mvlikhachev.stopdrinkmvvm.databinding.FragmentMainBinding
import ru.mvlikhachev.stopdrinkmvvm.models.User
import ru.mvlikhachev.stopdrinkmvvm.utilits.APP_ACTIVITY
import ru.mvlikhachev.stopdrinkmvvm.utilits.calculateTimeWithoutDrink

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
        _binding = FragmentMainBinding.inflate(layoutInflater, container,false)
        return mBinding.root
    }

    private fun initialization() {

        GlobalScope.launch(Dispatchers.IO) {
            currentUser = mViewModel.getCurrentUser(1)
            userName = currentUser.name
            userDate = currentUser.dateWhenStopDrink

            daysWithoudDrink = calculateTimeWithoutDrink(userDate)!!

            mBinding.helloUsernameTextView.text = "Здраствуйте, $userName"

            //set date
            mBinding.daysTextView.text = "${daysWithoudDrink[0]} дней"
            mBinding.timeTextView.text = "${daysWithoudDrink[1]}:${daysWithoudDrink[2]}"
            Log.d("testDate", "date: $userDate")
            Log.d("testDate", "days: ${daysWithoudDrink[0]}")
            Log.d("testDate", "hour: ${daysWithoudDrink[1]}")
            Log.d("testDate", "minute: ${daysWithoudDrink[1]}")
        }

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

    override fun onStart() {
        super.onStart()
        initialization()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}