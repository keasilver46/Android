package com.cookandroid.afinal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentC extends Fragment {
    EditText edtReceived;
    String str;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_c, container, false);

        edtReceived = (EditText) v.findViewById(R.id.edtReceived);

        Bundle data = getArguments();
        if (data != null) {
            str = data.getString("cnt");
            edtReceived.setText(str);
        }

        return v;
    }
}
