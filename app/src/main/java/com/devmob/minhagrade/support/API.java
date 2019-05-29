package com.devmob.minhagrade.support;

import com.devmob.minhagrade.Model.Curso;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by georgerappel on 10/04/18.
 */

public interface API {

    String BASE_URL = "https://xa1os24d84.execute-api.us-east-1.amazonaws.com/";

    @GET("/prod/cursos/")
    Call<List<Curso>> getCourses();

    @GET("/prod/cursos/{path}")
    Call<Curso> getCourse(@Path("path") String path);
}
