package com.anvarpasha.avtogarage.utils

import android.util.Log
import android.util.Patterns

fun isEmailAndPasswordValid (email : String,password : String) : Boolean{

    Log.e("data","$email //  $password")
    if (email.isEmpty()) return false

    if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) return false

    if (password.isEmpty()) return false

    if (password.length < 6) return false

    return true
}

fun isEmailValid(email: String) :  Boolean {

    Log.e("data","$email //")
    if (email.isEmpty()) return false

    if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) return false

    return true
}