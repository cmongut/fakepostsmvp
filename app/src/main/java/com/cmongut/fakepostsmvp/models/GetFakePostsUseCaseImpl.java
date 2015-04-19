package com.cmongut.fakepostsmvp.models;

import java.util.List;

import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 *
 */
public class GetFakePostsUseCaseImpl implements GetFakePostsUseCase {

    private final static String ENDPOINT = "http://jsonplaceholder.typicode.com";
    private FakePostsApi api;

    public GetFakePostsUseCaseImpl() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(ENDPOINT).build();
        api = restAdapter.create(FakePostsApi.class);
    }

    @Override
    public void obtainFakePosts(final Callback callback) {
        api.getPosts(new retrofit.Callback<List<FakePost>>() {
            @Override
            public void success(List<FakePost> posts, Response response) {
                callback.onFakePostsLoaded(posts);
            }

            @Override
            public void failure(RetrofitError error) {
                // do nothing for now
            }
        });
    }
}
