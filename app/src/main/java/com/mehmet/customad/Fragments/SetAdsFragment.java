package com.mehmet.customad.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.mehmet.customad.R;
import com.mehmet.customad.Utils.ChangeFragment;

import java.util.ArrayList;
import java.util.List;


public class SetAdsFragment extends Fragment {

   private View view;
   Spinner spinnerGender,spinnerAge;
   List<String> genderList,ageList;
   ArrayAdapter genderAdapter,ageAdapter;
   RadioButton radioButton;
   RadioGroup radioGroup;
   Button ad_save_button;
   SharedPreferences sharedPreferences,sharedPreferences2;
   SharedPreferences.Editor editor,editor2;
    int radioId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_set_ads, container, false);

        define();
        setSpinners();

        return view;
    }

    private void define(){

        spinnerGender=view.findViewById(R.id.spinnerGender);
        spinnerAge=view.findViewById(R.id.spinnerAge);
        radioGroup=view.findViewById(R.id.radioGroup);
        ad_save_button=view.findViewById(R.id.ad_save_button);

        sharedPreferences2=getContext().getSharedPreferences("radio",Context.MODE_PRIVATE);
        if(sharedPreferences2!=null)
        radioGroup.check(sharedPreferences2.getInt("radio_id",0));

        ad_save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(radioGroup.getCheckedRadioButtonId()!=-1) {

                    radioId = radioGroup.getCheckedRadioButtonId();

                    radioButton = view.findViewById(radioId);

                    sharedPreferences = getContext().getSharedPreferences("category", Context.MODE_PRIVATE);
                    editor = sharedPreferences.edit();
                    editor.putString("category_name", radioButton.getText() + "");
                    editor.putString("gender", spinnerGender.getSelectedItem().toString()+ "");
                    editor.putString("age", spinnerAge.getSelectedItem().toString() + "");
                    editor.apply();

                    sharedPreferences2 = getContext().getSharedPreferences("radio", Context.MODE_PRIVATE);
                    editor2 = sharedPreferences2.edit();
                    editor2.putInt("radio_id", radioId);
                    editor2.apply();

                    ChangeFragment changeFragment = new ChangeFragment(getContext());
                    changeFragment.change(new ProfileFragment());

                }

                else{
                    Toast.makeText(getContext(), "Lütfen Bir Kategori Seçiniz!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void setSpinners(){

        genderList=new ArrayList<>();
        ageList=new ArrayList<>();

        genderList.add("Erkek");
        genderList.add("Kadın");

        ageList.add("18-24");
        ageList.add("25-32");
        ageList.add("33-49");
        ageList.add("50+");

        genderAdapter=new ArrayAdapter<>(getContext(),android.R.layout.simple_dropdown_item_1line,genderList);
        spinnerGender.setAdapter( genderAdapter);

        ageAdapter=new ArrayAdapter<>(getContext(),android.R.layout.simple_dropdown_item_1line,ageList);
        spinnerAge.setAdapter(ageAdapter);

    }



}
