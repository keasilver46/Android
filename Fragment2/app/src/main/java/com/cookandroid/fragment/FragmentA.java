package com.cookandroid.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentA extends Fragment {
    EditText editText;
    Button buttonOk;
    FragmentAListener listener;

    public interface FragmentAListener {
        void onInputASent(CharSequence input);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof FragmentAListener) {
            listener = (FragmentAListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement FragmentAListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_a, container, false);

        editText = (EditText) v.findViewById(R.id.edit_text);
        buttonOk = (Button) v.findViewById(R.id.button_ok);
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence input = editText.getText();
                listener.onInputASent(input);
            }
        });

        return v;
    }

    public void updateFragAEditText(CharSequence newText) {
        editText.setText(newText);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}