package com.cmongut.fakepostsmvp.views;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.cmongut.fakepostsmvp.models.FakePost;
import com.cmongut.fakepostsmvp.R;
import com.cmongut.fakepostsmvp.presenters.FakePostsPresenter;
import com.cmongut.fakepostsmvp.presenters.FakePostsPresenterImpl;

import java.util.List;


public class FakePostsActivity extends ActionBarActivity implements FakePostsView {

    private ListView mFakePostsListView;
    private ProgressBar mProgressBar;
    private FakePostsPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fake_posts);

        mPresenter = new FakePostsPresenterImpl(this);

        mProgressBar = (ProgressBar) findViewById(R.id.progress);
        mFakePostsListView = (ListView) findViewById(R.id.list);
        mFakePostsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                mPresenter.onFakePostClicked(position);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onResume();
    }

    @Override
    public void showPosts(List<FakePost> posts) {
        mFakePostsListView.setAdapter(new FakePostsAdapter(this, posts));
    }

    @Override
    public void showPostBody(String postBody) {
        Toast.makeText(this, postBody, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
        mFakePostsListView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.INVISIBLE);
        mFakePostsListView.setVisibility(View.VISIBLE);
    }
}
