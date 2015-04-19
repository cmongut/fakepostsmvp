package com.cmongut.fakepostsmvp.presenters;

import com.cmongut.fakepostsmvp.models.FakePost;
import com.cmongut.fakepostsmvp.models.GetFakePostsUseCase;
import com.cmongut.fakepostsmvp.models.GetFakePostsUseCaseImpl;
import com.cmongut.fakepostsmvp.views.FakePostsView;

import java.util.List;

/**
 *
 */
public class FakePostsPresenterImpl implements FakePostsPresenter {

    private FakePostsView view;
    private List<FakePost> mPosts;
    private GetFakePostsUseCase getFakePostsUseCase;

    public FakePostsPresenterImpl(FakePostsView view) {
        this.view = view;
        getFakePostsUseCase = new GetFakePostsUseCaseImpl();
    }

    @Override
    public void onResume() {
        view.showProgress();
        getFakePostsUseCase.obtainFakePosts(new GetFakePostsUseCase.Callback() {
            @Override
            public void onFakePostsLoaded(List<FakePost> posts) {
                mPosts = posts;
                view.showPosts(posts);
                view.hideProgress();
            }
        });
    }

    @Override
    public void onFakePostClicked(int position) {
        view.showPostBody(mPosts.get(position).getBody());
    }
}
