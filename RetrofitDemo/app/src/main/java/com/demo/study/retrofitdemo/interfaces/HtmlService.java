package com.demo.study.retrofitdemo.interfaces;

import com.demo.study.retrofitdemo.Bean.BookBean;
import com.demo.study.retrofitdemo.Bean.HistoryBean;
import com.demo.study.retrofitdemo.Bean.UserBean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by byhieg on 16/11/11.
 */

public interface HtmlService {

    @Headers({
            "Cache-Control: max-age=640000",
            "User-Agent: app-name"
    })

    @GET("/")
    Call<String> getHtml();

    @GET("{number}/{page}")
    Call<HistoryBean> getHistoryData(@Header("Content-Range") String contentRange ,@Path("number") String number, @Path("page") String page);

    @GET("book/search")
    Call<BookBean> queryBookInfo(@QueryMap Map<String,String> maps);


    @FormUrlEncoded
    @POST("login")
    Call<ResponseBody> doLogin(@FieldMap Map<String,String> fields);


}
