package com.anvarpasha.avtogarage.data.network.repository

import com.anvarpasha.avtogarage.data.network.model.request.ForgotModel
import com.anvarpasha.avtogarage.data.network.model.request.LoginModel
import com.anvarpasha.avtogarage.data.network.model.request.OtpModel
import com.anvarpasha.avtogarage.data.network.model.request.ReportStatusRequestModel
import com.anvarpasha.avtogarage.data.network.model.response.*
import com.anvarpasha.avtogarage.data.network.network.APIResponse
import com.anvarpasha.avtogarage.data.network.network.ProjectApi

class ProjectRepository(private val apiService: ProjectApi) {

    suspend fun loginUser(loginModel: LoginModel): APIResponse<LoginResponse?> {
        val apiResponse = apiService.loginAsync(loginModel).await()
        return if (apiResponse.isSuccessful)
            APIResponse.Success(apiResponse.body())
        else {
            APIResponse.Error(apiResponse.message(), apiResponse.code())
        }
    }


    suspend fun sendOtp(model: OtpModel): APIResponse<OtpMainResponse?> {
        val apiResponse = apiService.sendOtp(model).await()
        return if (apiResponse.isSuccessful)
            APIResponse.Success(apiResponse.body())
        else {
            APIResponse.Error(apiResponse.message(), apiResponse.code())
        }
    }


    suspend fun recoverPassword(model: ForgotModel): APIResponse<ForgotResponse?> {
        val apiResponse = apiService.recoverPassword(model).await()
        return if (apiResponse.isSuccessful)
            APIResponse.Success(apiResponse.body())
        else {
            APIResponse.Error(apiResponse.message(), apiResponse.code())
        }
    }


    suspend fun getOrders(shopId: String): APIResponse<OrderResponse?> {
        val apiResponse = apiService.getOrders(shopId).await()
        return if (apiResponse.isSuccessful)
            APIResponse.Success(apiResponse.body())
        else {
            APIResponse.Error(apiResponse.message(), apiResponse.code())
        }
    }


    suspend fun getSingleOrder(shopId: String, orderId: String): APIResponse<SingleOrderResponse?> {
        val apiResponse = apiService.getSingleOrder(shopId, orderId).await()
        return if (apiResponse.isSuccessful)
            APIResponse.Success(apiResponse.body())
        else {
            APIResponse.Error(apiResponse.message(), apiResponse.code())
        }
    }


    suspend fun getProfile(): APIResponse<ProfileResponse?> {
        val apiResponse = apiService.getProfile().await()
        return if (apiResponse.isSuccessful)
            APIResponse.Success(apiResponse.body())
        else {
            APIResponse.Error(apiResponse.message(), apiResponse.code())
        }
    }


    suspend fun getSearchScreen(
        shopId: String,
        query: HashMap<String, String>
    ): APIResponse<SearchResponse?> {
        val apiResponse = apiService.getSearchScreenAsync(shopId,query).await()
        return if (apiResponse.isSuccessful)
            APIResponse.Success(apiResponse.body())
        else {
            APIResponse.Error(apiResponse.message(), apiResponse.code())
        }
    }


    suspend fun logOut(): APIResponse<LogOutResponse?> {
        val apiResponse = apiService.logout().await()
        return if (apiResponse.isSuccessful)
            APIResponse.Success(apiResponse.body())
        else {
            APIResponse.Error(apiResponse.message(), apiResponse.code())
        }
    }


    suspend fun putChange(): APIResponse<ChangeResponse?> {
        val apiResponse = apiService.putChange().await()
        return if (apiResponse.isSuccessful)
            APIResponse.Success(apiResponse.body())
        else {
            APIResponse.Error(apiResponse.message(), apiResponse.code())
        }
    }

    suspend fun changeReportStatus(id:String,model:ReportStatusRequestModel): APIResponse<ChangeResponse?> {
        val apiResponse = apiService.changeReportStatus(id,model).await()
        return if (apiResponse.isSuccessful)
            APIResponse.Success(apiResponse.body())
        else {
            APIResponse.Error(apiResponse.message(), apiResponse.code())
        }
    }

    suspend fun getAcceptMessages(): APIResponse<ReportStatusResponse?> {
        val apiResponse = apiService.getAcceptMessages().await()
        return if (apiResponse.isSuccessful)
            APIResponse.Success(apiResponse.body())
        else {
            APIResponse.Error(apiResponse.message(), apiResponse.code())
        }
    }


    suspend fun getCancel(): APIResponse<ReportStatusResponse?> {
        val apiResponse = apiService.getCancelMessages().await()
        return if (apiResponse.isSuccessful)
            APIResponse.Success(apiResponse.body())
        else {
            APIResponse.Error(apiResponse.message(), apiResponse.code())
        }
    }


}