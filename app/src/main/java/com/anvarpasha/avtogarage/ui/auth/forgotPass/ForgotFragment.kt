package com.anvarpasha.avtogarage.ui.auth.forgotPass

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.anvarpasha.avtogarage.databinding.ForgotFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ForgotFragment : Fragment() {


    private val viewModel: ForgotVM by viewModel()
    private val binding: ForgotFragmentBinding by lazy {
        ForgotFragmentBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)


        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        val otpToken = arguments?.getString("data")!!
        viewModel.otpToken = otpToken

        Log.e("Data",otpToken)

        viewModel.properties.observe(viewLifecycleOwner, {
          findNavController().navigate(ForgotFragmentDirections.actionForgotFragmentToSignInFragment())

        })


        return binding.root
    }

}