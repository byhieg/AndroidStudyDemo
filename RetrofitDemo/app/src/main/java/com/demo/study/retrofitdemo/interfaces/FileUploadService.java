package com.demo.study.retrofitdemo.interfaces;

import com.demo.study.retrofitdemo.Bean.HistoryBean;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by byhieg on 16/11/13.
 */

public interface FileUploadService {

    @Multipart
    @POST("upload")
    Call<ResponseBody> uploadFile(@Part("description") RequestBody description,
                                  @Part MultipartBody.Part file);
}
