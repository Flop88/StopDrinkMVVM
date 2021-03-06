package ru.mvlikhachev.stopdrinkmvvm.screens.room_login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import ru.mvlikhachev.stopdrinkmvvm.R
import ru.mvlikhachev.stopdrinkmvvm.databinding.FragmentInputDataBinding
import ru.mvlikhachev.stopdrinkmvvm.models.User
import ru.mvlikhachev.stopdrinkmvvm.utilits.APP_ACTIVITY
import ru.mvlikhachev.stopdrinkmvvm.utilits.showToast

class InputDataFragment : Fragment() {

    private var _binding: FragmentInputDataBinding? = null
    private val mBinding get() = _binding!!

    private lateinit var mViewModel: InputDataFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInputDataBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        mViewModel = ViewModelProvider(this).get(InputDataFragmentViewModel::class.java)
        mBinding.registrationRoomButton.setOnClickListener {
            val name = mBinding.textInputNameRoom.editText?.text.toString()
            val date = mBinding.textInputDateRoom.editText?.text.toString()

            if (name.isNotEmpty() && date.isNotEmpty()) {
                mViewModel.insetr(User(name = name, dateWhenStopDrink = date)) {
                    APP_ACTIVITY.mNavController.navigate(R.id.action_inputDataFragment_to_mainFragment)
                }
            } else {
                showToast(getString(R.string.input_name_and_data))
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}