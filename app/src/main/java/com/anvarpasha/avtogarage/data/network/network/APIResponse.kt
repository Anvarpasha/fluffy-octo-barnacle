package com.anvarpasha.avtogarage.data.network.network

sealed class APIResponse<T> {
    data class Success<T>(val body: T) : APIResponse<T>()
    data class Error<T>(val message: String, val code: Int) : APIResponse<T>()

}