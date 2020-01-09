package com.mehmet.customad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mehmet.customad.Activities.LoginActivity;
import com.mehmet.customad.Fragments.FeedsFragment;
import com.mehmet.customad.Fragments.ProfileFragment;
import com.mehmet.customad.Utils.ChangeFragment;

public class MainActivity extends AppCompatActivity {

    private ChangeFragment changeFragment;
    SharedPreferences sharedPreferences;
    String token;
    SharedPreferences.Editor editor;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.menu_home:

                    changeFragment.change(new FeedsFragment());
                    return true;

                case R.id.menu_share:

                   // changeFragment.change(new ShareFragment());
                    return true;

                case R.id.menu_profile:

                    changeFragment.change(new ProfileFragment());
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        changeFragment=new ChangeFragment(MainActivity.this);
        changeFragment.change(new FeedsFragment());

        BottomNavigationView navView = findViewById(R.id.nav_bottom);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        sharedPreferences=getApplicationContext().getSharedPreferences("login",0);
        token=sharedPreferences.getString("token",null);

        if(token==null){

            sharedPreferences=getApplicationContext().getSharedPreferences("register",0);
        }



    }
}
