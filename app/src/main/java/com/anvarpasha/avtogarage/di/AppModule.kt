package com.anvarpasha.avtogarage.di

import com.anvarpasha.avtogarage.data.network.network.RetrofitClient
import com.anvarpasha.avtogarage.data.network.repository.ProjectRepository
import com.anvarpasha.avtogarage.ui.profile.ProfileVM
import com.anvarpasha.avtogarage.ui.auth.forgotPass.ForgotVM
import com.anvarpasha.avtogarage.ui.auth.otp.OtpVM
import com.anvarpasha.avtogarage.ui.auth.signIn.SignInViewModel
import com.anvarpasha.avtogarage.ui.orderDetail.OrderDetailVM
import com.anvarpasha.avtogarage.ui.orders.OrderVM
import com.anvarpasha.avtogarage.ui.searchList.SearchVM
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module


val appModule = module {
    single { RetrofitClient.provideApi() }
    factory { ProjectRepository(get())}
    viewModel { SignInViewModel(get())}
    viewModel { OrderVM(get())}
    viewModel { OtpVM(get())}
    viewModel { ForgotVM(get())}
    viewModel { OrderDetailVM(get())}
    viewModel { ProfileVM (get()) }
    viewModel { SearchVM (get()) }


}