package com.devmob.minhagrade.Model;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by murilo on 14/11/17.
 */

public interface Service {

    public static final String BASE_URL = "http://104.131.95.40/";

    @GET("MMQ")
    Call<ResponseBody> listBody();
}
