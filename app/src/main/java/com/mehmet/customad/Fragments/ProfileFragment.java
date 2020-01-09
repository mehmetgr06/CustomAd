package com.mehmet.customad.Fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.mehmet.customad.Activities.LoginActivity;
import com.mehmet.customad.R;
import com.mehmet.customad.Utils.ChangeFragment;

import java.util.ResourceBundle;


public class ProfileFragment extends Fragment {

    View view;
    private SharedPreferences sharedPreferences,sharedPreferences2;
    SharedPreferences.Editor editor,editor2;
    String token,email;
    TextView profile_mail_textview;
    Button set_ad_button,log_out_button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_profile, container, false);

        define();

        return view;
    }

    private void define(){

        profile_mail_textview=view.findViewById(R.id.profile_mail_textview);
        set_ad_button=view.findViewById(R.id.set_ad_button);
        log_out_button=view.findViewById(R.id.log_out_button);


        sharedPreferences=getContext().getSharedPreferences("login",0);

        sharedPreferences2=getContext().getSharedPreferences("radio",0);

        token=sharedPreferences.getString("token",null);
        email=sharedPreferences.getString("email",null);

        if(token==null){

            sharedPreferences=getContext().getSharedPreferences("register",0);

            token=sharedPreferences.getString("token",null);
            email=sharedPreferences.getString("email",null);
        }




        profile_mail_textview.setText(email);

        set_ad_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ChangeFragment changeFragment=new ChangeFragment(getContext());
                changeFragment.change(new SetAdsFragment());
            }
        });

        log_out_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editor=sharedPreferences.edit();
                editor.clear();
                editor.commit();


                editor2 = sharedPreferences2.edit();
                editor2.clear();
                editor2.commit();

                Intent intent=new Intent(getContext(), LoginActivity.class);
                startActivity(intent);

            }
        });

    }

}
