package com.cookandroid.afinal;

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

public class FragmentB extends Fragment {
    EditText edtCounter;
    Button btnSend;
    String str;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_b, container, false);

        edtCounter = (EditText) v.findViewById(R.id.edtCounter);

        Bundle bundle = getArguments();
        if (bundle != null) {
            str = bundle.getString("counter");
            edtCounter.setText(str);
        }

        btnSend = (Button) v.findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle data = new Bundle();
                data.putString("cnt", edtCounter.getText().toString());

                FragmentC fragmentC = new FragmentC();
                fragmentC.setArguments(data);

                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container_c, fragmentC);
                fragmentTransaction.addToBackStack("frgC");
                fragmentTransaction.commit();
            }
        });

        return v;
    }
}
