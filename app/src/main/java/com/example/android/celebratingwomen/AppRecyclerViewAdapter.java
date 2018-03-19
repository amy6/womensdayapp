package com.example.android.celebratingwomen;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class AppRecyclerViewAdapter extends RecyclerView.Adapter<AppViewHolder> {

    private ArrayList<AppItem> appItemList;
    private Context context;
    private RecyclerView recyclerView;

    AppRecyclerViewAdapter(Context context, ArrayList<AppItem> appItemList, RecyclerView recyclerView) {
        this.appItemList = appItemList;
        this.context = context;
        this.recyclerView = recyclerView;
    }

    @Override
    public AppViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_list_item, parent, false);
        return new AppViewHolder(context, layoutView, recyclerView);
    }

    @Override
    public void onBindViewHolder(AppViewHolder holder, int position) {
        final AppItem item = appItemList.get(position);
        holder.description.setText(item.getDescription());
        holder.title.setText(item.getTitle());
        holder.appImage.setBackgroundResource(item.getImageID());

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("market://details?id=" + item.getPlayStoreID()));
                if(intent.resolveActivity(context.getPackageManager()) != null) {
                    context.startActivity(intent);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.appItemList.size();
    }
}
