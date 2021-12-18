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

public class FragmentC extends Fragment {
    EditText editText;
    Button btnBack;
    String str;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_c, container, false);

        editText = (EditText) v.findViewById(R.id.edit_text);

        Bundle data = getArguments();
        if (data != null) {
            str = data.getString("message");
            editText.setText(str);
        }

        btnBack = (Button) v.findViewById(R.id.btnback);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainFragment mainFragment = new MainFragment();

                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container, mainFragment);
                fragmentTransaction.addToBackStack("frgMain");
                fragmentTransaction.commit();
            }
        });

        return v;
    }
}

