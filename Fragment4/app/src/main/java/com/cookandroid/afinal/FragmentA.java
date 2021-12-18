package com.cookandroid.afinal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class FragmentA extends Fragment {
    Button btnUp, btnDown;
    int counter = 0;
    String str;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_a, container, false);

        btnUp = (Button) v.findViewById(R.id.btnUp);
        btnDown = (Button) v.findViewById(R.id.btnDown);

        Bundle bundle = new Bundle();

        btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                str = Integer.toString(counter);
                bundle.putString("counter", str);

                FragmentB fragmentB = new FragmentB();
                fragmentB.setArguments(bundle);

                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container_b, fragmentB);
                fragmentTransaction.commit();
            }
        });

        btnDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter--;
                str = Integer.toString(counter);
                bundle.putString("counter", str);

                FragmentB fragmentB = new FragmentB();
                fragmentB.setArguments(bundle);

                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container_b, fragmentB);
                fragmentTransaction.commit();
            }
        });

        return v;
    }
}
