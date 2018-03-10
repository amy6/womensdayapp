package com.example.android.celebratingwomen;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<AppItem> appItemList = getAppItemList();

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        AppRecyclerViewAdapter adapter = new AppRecyclerViewAdapter(appItemList, this);
        recyclerView.setAdapter(adapter);

    }


    private ArrayList<AppItem> getAppItemList() {

        ArrayList<AppItem> list = new ArrayList<>();

        list.add(new AppItem(R.drawable.wcc, getString(R.string.wcc2_title), getString(R.string.wcc2_description), getString(R.string.wcc2)));
        list.add(new AppItem(R.drawable.zenkoi, getString(R.string.zenkoi_title), getString(R.string.zenkoi_description), getString(R.string.zenkoi)));
        list.add(new AppItem(R.drawable.junes_journey, getString(R.string.june_title), getString(R.string.june_description), getString(R.string.june)));
        list.add(new AppItem(R.drawable.kami_puzzles, getString(R.string.kami_title), getString(R.string.kami_description), getString(R.string.kami)));
        list.add(new AppItem(R.drawable.eightydays, getString(R.string.eightydays_title), getString(R.string.eightydays_description), getString(R.string.eightydays)));
        return list;
    }

}
