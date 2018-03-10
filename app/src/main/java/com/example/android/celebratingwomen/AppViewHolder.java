package com.example.android.celebratingwomen;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


class AppViewHolder extends RecyclerView.ViewHolder {

    ImageView appImage;
    TextView title;
    TextView description;
    Button button;

    AppViewHolder(final View itemView) {
        super(itemView);
        this.appImage = itemView.findViewById(R.id.image);
        this.title = itemView.findViewById(R.id.title);
        this.description = itemView.findViewById(R.id.description);
        this.button = itemView.findViewById(R.id.button);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LinearLayout expandableView = view.findViewById(R.id.expandable_view);
                expandableView.setVisibility(expandableView.getVisibility() == View.GONE ?
                View.VISIBLE : View.GONE);
            }
        });
    }
}
