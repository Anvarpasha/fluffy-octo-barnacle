package com.anvarpasha.avtogarage.data.network.interceptor

import com.anvarpasha.avtogarage.data.network.persistence.prefs
import okhttp3.Interceptor
import okhttp3.Response

class UnAuthorizedInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)
        if (response.code == 401) {
            prefs.logOut()
        }
        return response
    }
}