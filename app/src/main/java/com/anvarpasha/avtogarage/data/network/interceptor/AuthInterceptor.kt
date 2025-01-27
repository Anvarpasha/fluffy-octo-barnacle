package com.anvarpasha.avtogarage.data.network.interceptor

import com.anvarpasha.avtogarage.data.network.persistence.prefs
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request =
            chain.request().newBuilder()
                .addHeader("Authorization", "Bearer ${prefs.getToken()}")
                .build()
        return chain.proceed(request)
    }
}