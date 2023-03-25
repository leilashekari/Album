package com.example.login.network
import com.google.gson.annotations.SerializedName
import retrofit2.http.GET

interface ImageListEndpoint {

    @GET("/v2/list")
    suspend fun getImageList() : List<PictureDto>
}

data class PictureDto(@SerializedName("download_url") val url : String ,@SerializedName("author") val author: String)