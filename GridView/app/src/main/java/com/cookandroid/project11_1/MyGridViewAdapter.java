package com.cookandroid.project11_1;

import android.content.Context;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;

public class MyGridViewAdapter extends BaseAdapter {
    Integer[] posterID = { R.drawable.yk1, R.drawable.yk2,
            R.drawable.yk3, R.drawable.yk4, R.drawable.yk5,
            R.drawable.yk1, R.drawable.yk2, R.drawable.yk3,
            R.drawable.yk4, R.drawable.yk5, R.drawable.yk1,
            R.drawable.yk2, R.drawable.yk3, R.drawable.yk4,
            R.drawable.yk5, R.drawable.yk1, R.drawable.yk2,
            R.drawable.yk3, R.drawable.yk4, R.drawable.yk5 };

    Context context;

    public MyGridViewAdapter(Context c) {
        context = c;
    }

    @Override
    public int getCount() {
        return posterID.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(200, 300));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setPadding(5, 5, 5, 5);
        imageView.setImageResource(posterID[i]);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View dialogView = (View) View.inflate(context,
                        R.layout.dialog, null);
                ImageView ivPoster = (ImageView) dialogView.findViewById(R.id.ivPoster);
                ivPoster.setImageResource(posterID[i]);

                AlertDialog.Builder dlg = new AlertDialog.Builder(context);
                dlg.setTitle("Large Poster");
                dlg.setIcon(R.drawable.icon);
                dlg.setView(dialogView);
                dlg.setNegativeButton("Close", null);
                dlg.show();
            }
        });

        return imageView;
    }
}
