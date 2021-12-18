package com.cookandroid.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyColorFragment extends Fragment {
    String color;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle data = getArguments();
        if (data != null) {
            color = data.getString("ColorSelected");
        } else {
            color = "none";
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i("프래그먼트예제", "MyColorFragment: onCreateView " + color);
        return inflater.inflate(R.layout.color_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        switch (color) {
            case "red":
                view.setBackgroundColor(Color.RED);
                break;
            case "green":
                view.setBackgroundColor(Color.GREEN);
                break;
            case "blue":
                view.setBackgroundColor(Color.BLUE);
                break;
            default:
                break;
        }
    }
}
