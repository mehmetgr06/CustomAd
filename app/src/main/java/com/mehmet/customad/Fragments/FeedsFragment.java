package com.mehmet.customad.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mehmet.customad.R;
import com.mehmet.customad.Utils.ChangeFragment;


public class FeedsFragment extends Fragment {

    View view;
    Button see_ad_button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_feeds, container, false);

        define();

        return view;
    }

    private void define(){

        see_ad_button=view.findViewById(R.id.see_ad_button);

        see_ad_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ChangeFragment changeFragment=new ChangeFragment(getContext());
                changeFragment.change(new AdFragment());
            }
        });
    }


}
