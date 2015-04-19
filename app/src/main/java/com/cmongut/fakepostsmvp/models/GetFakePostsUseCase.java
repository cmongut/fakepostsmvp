package com.cmongut.fakepostsmvp.models;

import java.util.List;

/**
 *
 */
public interface GetFakePostsUseCase {

    interface Callback {
        void onFakePostsLoaded(List<FakePost> posts);
    }

    public void obtainFakePosts(final Callback callback);
}
