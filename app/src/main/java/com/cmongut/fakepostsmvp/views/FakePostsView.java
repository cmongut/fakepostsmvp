package com.cmongut.fakepostsmvp.views;

import com.cmongut.fakepostsmvp.models.FakePost;

import java.util.List;

/**
 *
 */
public interface FakePostsView {

    public void showPosts(List<FakePost> posts);
    public void showPostBody(String postBody);
    public void showProgress();
    public void hideProgress();
}
