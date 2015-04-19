package com.cmongut.fakepostsmvp.models;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 *
 */
public interface FakePostsApi {

    @GET("/posts")
    void getPosts(Callback<List<FakePost>> posts);

}

