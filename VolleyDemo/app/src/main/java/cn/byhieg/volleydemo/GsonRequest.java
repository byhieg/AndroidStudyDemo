package cn.byhieg.volleydemo;

import android.net.wifi.WifiConfiguration;
import android.support.annotation.NonNull;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpClientStack;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;

/**
 * Created by byhieg on 17/5/9.
 * Contact with byhieg@gmail.com
 */

public class GsonRequest<T> extends Request<T> {

    private Response.Listener<T> mlistener;
    private Gson gson;
    private Class<T> clz;

    public GsonRequest(int method, String url,Class<T> clz, Response.Listener<T> mlistener,
                       Response.ErrorListener listener) {
        super(method,url, listener);
        this.mlistener = mlistener;
        gson = new Gson();
        this.clz = clz;
    }

    @Override
    protected Response parseNetworkResponse(NetworkResponse response) {
        try {
            String jsonString = new String(response.data,
                    HttpHeaderParser.parseCharset(response.headers));
            return Response.success(gson.fromJson(jsonString, clz),HttpHeaderParser.parseCacheHeaders(
                    response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        }
    }

    @Override
    protected void deliverResponse(T response) {
        mlistener.onResponse(response);
    }


}
