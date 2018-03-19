package com.example.android.celebratingwomen;

import android.content.Context;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


class AppViewHolder extends RecyclerView.ViewHolder {

    private final int screenHeigthInPx;

    ImageView appImage;
    TextView title;
    TextView description;
    Button button;
    private Context context;

    AppViewHolder(Context context, final View itemView, final RecyclerView recyclerView) {
        super(itemView);
        this.context = context;
        this.appImage = itemView.findViewById(R.id.image);
        this.title = itemView.findViewById(R.id.title);
        this.description = itemView.findViewById(R.id.description);
        this.button = itemView.findViewById(R.id.button);


        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(metrics);
        }
        screenHeigthInPx = metrics.heightPixels;
        Log.v("AppViewHolder", "Screen Height is: " + screenHeigthInPx);


        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final LinearLayout expandableView = view.findViewById(R.id.expandable_view);
                expandableView.setVisibility(expandableView.getVisibility() == View.GONE ?
                View.VISIBLE : View.GONE);

                if(expandableView.getVisibility() == View.VISIBLE) {
                    final ViewTreeObserver treeObserver = itemView.getViewTreeObserver();
                    treeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                        @Override
                        public void onGlobalLayout() {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                                itemView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            } else {
                                itemView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                            }
                            int height = itemView.getMeasuredHeight();
                            Log.v("AppViewHolder", "Card's Y position: " + itemView.getY());
                            Log.v("AppViewHolder", "Card Height is:  " + height);

                            Log.v("AppViewHolder", "How much space available above the card? :  " + (screenHeigthInPx - itemView.getY()));

                            Log.v("AppViewHolder", "Enough space to scroll the card up? :  " + ((screenHeigthInPx - itemView.getY()) < height ? "yes!" : "No"));

                            if((screenHeigthInPx - itemView.getY()) < height) {
                                Log.v("AppViewHolder", "Scrolling the card!");
                                recyclerView.scrollBy(0, (int) (screenHeigthInPx - itemView.getY()));
                            }
                        }
                    });
                }


            }
        });
    }
}
