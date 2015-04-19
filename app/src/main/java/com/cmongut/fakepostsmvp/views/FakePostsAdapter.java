package com.cmongut.fakepostsmvp.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.cmongut.fakepostsmvp.models.FakePost;
import com.cmongut.fakepostsmvp.R;

import java.util.List;

/**
 *
 */
public class FakePostsAdapter extends ArrayAdapter<FakePost> {

    private LayoutInflater mLayoutInflater;
    private List<FakePost> mPosts;

    public FakePostsAdapter(Context context, List<FakePost> posts) {
        super(context, 0, posts);
        mLayoutInflater = LayoutInflater.from(context);
        mPosts = posts;
    }

    public class ViewHolder {
        public TextView number;
        public TextView title;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.list_item_fake_post, parent, false);
            holder = new ViewHolder();
            holder.number = (TextView) convertView.findViewById(R.id.fake_post_item_number);
            holder.title = (TextView) convertView.findViewById(R.id.fake_post_item_title);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();

        FakePost post = this.getItem(position);
        holder.number.setText("#" + post.getId());
        holder.title.setText(post.getTitle());

        return convertView;
    }

    @Override
    public int getCount() {
        return mPosts.size();
    }

    @Override
    public FakePost getItem(int position) {
        return mPosts.get(position);
    }

}

