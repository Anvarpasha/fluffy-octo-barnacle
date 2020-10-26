package com.anvarpasha.avtogarage.ui.auth.otp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.anvarpasha.avtogarage.R
import com.anvarpasha.avtogarage.databinding.OtpFragmentBinding
import com.anvarpasha.avtogarage.ui.auth.AuthActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class OtpFragment : Fragment() {

    //TODO fragment and activity lifecycle

    private val viewModel: OtpVM by viewModel()
    private val binding: OtpFragmentBinding by lazy {
        OtpFragmentBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.properties.observe(viewLifecycleOwner, {

            findNavController().navigate(OtpFragmentDirections.actionOtpFragmentToForgotFragment(it.data.token))
            Log.e("data","${it.data.token}   ///  ${it.message}")
        })


        return binding.root
    }

}