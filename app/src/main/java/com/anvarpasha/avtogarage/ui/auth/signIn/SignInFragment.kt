package com.anvarpasha.avtogarage.ui.auth.signIn

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.anvarpasha.avtogarage.ui.dashboard.MainActivity
import com.anvarpasha.avtogarage.R
import com.anvarpasha.avtogarage.databinding.SignInFragmentBinding
import com.anvarpasha.avtogarage.data.network.persistence.prefs
import com.anvarpasha.avtogarage.ui.auth.AuthActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignInFragment : Fragment() {

    private val viewModel: SignInViewModel by viewModel()
    private val binding: SignInFragmentBinding by lazy {
        SignInFragmentBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        (activity as AuthActivity).supportActionBar?.setIcon(R.drawable.avtogarage)

        viewModel.properties.observe(viewLifecycleOwner, {

            prefs.setToken(it.access_token)
            prefs.setShopId(it.shopId)
            startActivity(Intent(activity, MainActivity::class.java))
            Toast.makeText(activity,it.shopId,Toast.LENGTH_SHORT).show()
        })

        viewModel.goToOtpFragment.observe(viewLifecycleOwner, {

            if (it){
                (activity as AuthActivity).supportActionBar?.setIcon(null)

                findNavController().navigate(SignInFragmentDirections.actionSignInFragmentToOtpFragment())
                viewModel.navigationToForgotDone()
            }

        })


        return binding.root
    }

}