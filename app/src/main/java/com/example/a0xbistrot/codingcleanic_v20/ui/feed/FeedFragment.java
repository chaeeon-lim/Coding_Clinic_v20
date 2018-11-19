package com.example.a0xbistrot.codingcleanic_v20.ui.feed;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a0xbistrot.codingcleanic_v20.R;
import com.example.a0xbistrot.codingcleanic_v20.data.entity.Feed;
import com.example.a0xbistrot.codingcleanic_v20.data.entity.User;
import com.example.a0xbistrot.codingcleanic_v20.data.source.FeedLocalSource;
import com.example.a0xbistrot.codingcleanic_v20.data.source.UserLocalSource;
import com.example.a0xbistrot.codingcleanic_v20.ui.basement.BaseFragment;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FeedFragment extends BaseFragment {


    private RecyclerView recyclerView;
    private FeedAdapter feedAdapter;
    private FeedLocalSource feedLocalSource = new FeedLocalSource();
    //ArrayList<FeedItem> feedItemsList;

    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragment_feed, container, false);
        findView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRecyclerView();
        //setItems();
    }

    @Override
    public void onStart() {
        super.onStart();
        setItems();
    }



    private void findView(View view){
        recyclerView = view.findViewById(R.id.feed_recycler_view);

    }

    private void setRecyclerView(){
        feedAdapter = new FeedAdapter();
        recyclerView.setAdapter(feedAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
    }


    private void setItems(){
        //setFeedData();
        feedAdapter.refresh(feedLocalSource.getAll());
        /*
        feedItemsList = new ArrayList<>();
        for (int i = 0 ; i < 6 ; i++){
            feedItemsList.add(new FeedItem("2017.12.24", R.drawable.content_pic1));
            feedItemsList.add(new FeedItem("2017.12.28", R.drawable.content_pic2));
            feedItemsList.add(new FeedItem("2018.01.04", R.drawable.content_pic3));
            feedItemsList.add(new FeedItem("2018.01.08", R.drawable.content_pic4));
            feedItemsList.add(new FeedItem("2018.01.15", R.drawable.content_pic5));
            feedItemsList.add(new FeedItem("2018.01.28", R.drawable.content_pic6));
        }
        feedAdapter.addAll(feedItemsList);
        */
    }
/*
    private void setFeedData(){

        String content_txt = getString(R.string.app_name);
        User user = new UserLocalSource().getMaster();
        for (int i = 0 ; i < 6 ; i++){
            feedLocalSource.insert(new Feed(user.getId(),"drawable://" + R.drawable.content_pic1, content_txt));
            feedLocalSource.insert(new Feed(user.getId(),"drawable://" + R.drawable.content_pic2, content_txt));
            feedLocalSource.insert(new Feed(user.getId(),"drawable://" + R.drawable.content_pic3, content_txt));
            feedLocalSource.insert(new Feed(user.getId(),"drawable://" + R.drawable.content_pic4, content_txt));
            feedLocalSource.insert(new Feed(user.getId(),"drawable://" + R.drawable.content_pic5, content_txt));
            feedLocalSource.insert(new Feed(user.getId(),"drawable://" + R.drawable.content_pic6, content_txt));

            feedItemsList.add(new FeedItem("2017.12.24", R.drawable.content_pic1));
            feedItemsList.add(new FeedItem("2017.12.28", R.drawable.content_pic2));
            feedItemsList.add(new FeedItem("2018.01.04", R.drawable.content_pic3));
            feedItemsList.add(new FeedItem("2018.01.08", R.drawable.content_pic4));
            feedItemsList.add(new FeedItem("2018.01.15", R.drawable.content_pic5));
            feedItemsList.add(new FeedItem("2018.01.28", R.drawable.content_pic6));

        }

        //feedAdapter.addAll(feedItemsList);

    }
    */
}
