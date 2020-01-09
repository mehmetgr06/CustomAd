package com.mehmet.customad.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.mehmet.customad.Models.AdImagePojo;
import com.mehmet.customad.R;
import com.mehmet.customad.RestApi.ApiClient;
import com.mehmet.customad.RestApi.RestApiClass;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AdFragment extends Fragment {

    View view;
    SharedPreferences sharedPreferences;
    String category,age,gender;
    ImageView add_image_view;
    TextView ad_title_text;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_ad, container, false);

        define();
        getAd();

        return view;
    }

    private void define(){

        add_image_view=view.findViewById(R.id.add_image_view);
        ad_title_text=view.findViewById(R.id.ad_title_text);

        sharedPreferences = getContext().getSharedPreferences("category", Context.MODE_PRIVATE);

        gender=sharedPreferences.getString("gender","");
        age=sharedPreferences.getString("age","");
        category=sharedPreferences.getString("category_name","");

    }

    private void getAd(){

        RestApiClass restApiClass= ApiClient.getClient().create(RestApiClass.class);
        Call<AdImagePojo> call=restApiClass.get_ad_image(gender,age,category);
        call.enqueue(new Callback<AdImagePojo>() {
            @Override
            public void onResponse(Call<AdImagePojo> call, Response<AdImagePojo> response) {

                if(response.isSuccessful()){

                    if(response.body().isFull()){

                        Glide.with(getContext())
                                .load("*Server Link*"+response.body().getImage())
                                .centerCrop()
                                .into(add_image_view);

                        ad_title_text.setText(response.body().getTitle());

                        Log.i("ressucc",response.body()+"");

                    }
                    else {
                        Toast.makeText(getContext(), "Henüz rofilinize uygun bir reklam bulunamadı", Toast.LENGTH_SHORT).show();
                        Log.i("ressfail",response.body()+"");
                        Log.i("gennns",gender+" "+age+" "+category);

                    }

                }
            }

            @Override
            public void onFailure(Call<AdImagePojo> call, Throwable t) {

                Toast.makeText(getContext(), "Bağlantı Hatası", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
