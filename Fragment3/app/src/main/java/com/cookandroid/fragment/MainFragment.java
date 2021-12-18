package com.cookandroid.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainFragment extends Fragment {
    EditText editText;
    Button btnfrgA, btnfrgB, btnfrgC;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        editText = (EditText) v.findViewById(R.id.edit_text);
        btnfrgA = (Button) v.findViewById(R.id.btnfrgA);
        btnfrgB = (Button) v.findViewById(R.id.btnfrgB);
        btnfrgC = (Button) v.findViewById(R.id.btnfrgC);

        btnfrgA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle data = new Bundle();
                data.putString("message", editText.getText().toString());

                FragmentA fragmentA = new FragmentA();
                fragmentA.setArguments(data);

                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container, fragmentA);
                fragmentTransaction.addToBackStack("frgA");
                fragmentTransaction.commit();
            }
        });

        btnfrgB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle data = new Bundle();
                data.putString("message", editText.getText().toString());

                FragmentB fragmentB = new FragmentB();
                fragmentB.setArguments(data);

                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container, fragmentB);
                fragmentTransaction.addToBackStack("frgB");
                fragmentTransaction.commit();
            }
        });

        btnfrgC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle data = new Bundle();
                data.putString("message", editText.getText().toString());

                FragmentC fragmentC = new FragmentC();
                fragmentC.setArguments(data);

                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container, fragmentC);
                fragmentTransaction.addToBackStack("frgC");
                fragmentTransaction.commit();
            }
        });

        return v;
    }
}
