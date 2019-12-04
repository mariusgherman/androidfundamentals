package com.example.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class HelloFragment extends Fragment {

    private String message = "No initial state";
    private Listener listener;
    private View button;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listener = (Listener) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.hello_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null) {
            message = getArguments().getString("message");
        }

        button = view.findViewById(R.id.hello_fragment_button);
        view.findViewById(R.id.hello_fragment_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), message, Toast.LENGTH_LONG)
                        .show();
                if (listener != null) {
                    listener.onButtonPressed();
                }
            }
        });

    }

    public void hideYourButton() {
        if (button != null) {
            button.setVisibility(View.INVISIBLE);
        }
    }
}
