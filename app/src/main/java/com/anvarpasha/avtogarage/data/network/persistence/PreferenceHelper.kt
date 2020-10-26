package com.anvarpasha.avtogarage.data.network.persistence

import android.content.Context
import android.content.SharedPreferences
import com.anvarpasha.avtogarage.data.network.model.remote.User

class PreferenceHelper(val context : Context) {
      private val KEY_EMAIL = "email"
      private val KEY_SHOP_ID = "shopId"
      private val OTP_TOKEN = "otp_token"
      private val KEY_BASE_URL = "BASE_URL"
      private val TOKEN = "TOKEN"

      private val PREFS_NAME ="kotlincodes"
      val sharedPref: SharedPreferences=
            context.getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE)

      fun createLoginSession(user: User) {
          val editor : SharedPreferences.Editor = sharedPref.edit()
          editor.putString(KEY_EMAIL,user.email)
          editor.putInt(KEY_SHOP_ID,user.shop_id)
          editor.putString(TOKEN,user.token)
          editor.apply()
      }

      fun getToken(): String {
        return sharedPref.getString(TOKEN, "")!!
      }


      fun setToken(token: String) {
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.putString(TOKEN, token)
        editor.apply()
       }

      fun getShopId(): String {
        return sharedPref.getString(KEY_SHOP_ID, "0")!!
      }


      fun setShopId(shopId: String) {
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.putString(KEY_SHOP_ID, shopId)
        editor.apply()
       }

      fun logOut() {
          val editor: SharedPreferences.Editor = sharedPref.edit()
          editor.remove(TOKEN)
          editor.clear()
          editor.apply()
      }





}