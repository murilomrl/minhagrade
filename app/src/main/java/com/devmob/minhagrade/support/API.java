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

    String BASE_URL = "http://minhagradeufrj.herokuapp.com";

    @GET("/cursos")
    Call<List<Curso>> getCourses();

    @GET("/cursos/{id}")
    Call<Curso> getCourse(@Path("id") String id);
}
