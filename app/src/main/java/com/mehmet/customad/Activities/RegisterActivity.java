package com.mehmet.customad.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mehmet.customad.MainActivity;
import com.mehmet.customad.Models.RegisterPojo;
import com.mehmet.customad.R;
import com.mehmet.customad.RestApi.ApiClient;
import com.mehmet.customad.RestApi.RestApiClass;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    AutoCompleteTextView emailRegisterEdittext;
    EditText passwordRegisterEdittext;
    Button registerButton;
    ProgressBar progress_bar_register;
    String email,userName,password,register_date;
    SharedPreferences sharedPreferences;
    ImageView registerCloseIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        define();
    }

    private void define(){

        emailRegisterEdittext=findViewById(R.id.emailRegisterEdittext);
        passwordRegisterEdittext=findViewById(R.id.passwordRegisterEdittext);
        registerButton=findViewById(R.id.registerButton);
        progress_bar_register=findViewById(R.id.progress_bar_register);
        registerCloseIcon=findViewById(R.id.registerCloseIcon);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                email=emailRegisterEdittext.getText().toString();
                password=passwordRegisterEdittext.getText().toString();
                progress_bar_register.setVisibility(View.VISIBLE);

                if(registerControls()){

                    register();
                    progress_bar_register.setVisibility(View.GONE);
                }
                else{

                    progress_bar_register.setVisibility(View.GONE);
                }

            }
        });

        registerCloseIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               /* Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);*/

               finish();

            }
        });

    }

    private void register(){

        Time today = new Time(Time.getCurrentTimezone());
        today.setToNow();
        register_date=today.monthDay+"/"+(today.month+1)+"/"+today.year;

        RestApiClass restApiClass= ApiClient.getClient().create(RestApiClass.class);

        Call<RegisterPojo> call=restApiClass.register(email,password);
        call.enqueue(new Callback<RegisterPojo>() {
            @Override
            public void onResponse(Call<RegisterPojo> call, Response<RegisterPojo> response) {

                if(response.isSuccessful()){

                    if(response.body().isResult()){

                        sharedPreferences=getApplicationContext().getSharedPreferences("register",0);
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.putString("email",email);
                        editor.putString("token",response.body().getToken().toString());
                        editor.commit();

                        Intent intent=new Intent(RegisterActivity.this, MainActivity.class);
                        startActivity(intent);
                        Toast.makeText(RegisterActivity.this, "Tebrikler. Kayıt Başarılı", Toast.LENGTH_SHORT).show();


                    }
                    else {

                        Toast.makeText(RegisterActivity.this, "Böyle bir kayıt bulunmaktadır.", Toast.LENGTH_SHORT).show();
                    }
                }
                else {

                    Toast.makeText(RegisterActivity.this, "Sunucuya İstek Atılamadı", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<RegisterPojo> call, Throwable t) {

                Toast.makeText(RegisterActivity.this, "Bağlantı Hatası", Toast.LENGTH_SHORT).show();
            }
        });

    }


    private boolean registerControls() {

        if (email.equals("")) {

            Toast.makeText(RegisterActivity.this, "Email kısmı boş girilemez", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!email.contains("@")) {

            Toast.makeText(RegisterActivity.this, "Geçersiz bir mail adresi girdiniz!", Toast.LENGTH_SHORT).show();
            return false;
        } else if (password.equals("")) {

            Toast.makeText(RegisterActivity.this, "Parola kısmı boş girilemez", Toast.LENGTH_SHORT).show();
            return false;
        } else if (password.length() < 4) {

            Toast.makeText(RegisterActivity.this, "Parola en az 4 haneli olmalıdır", Toast.LENGTH_SHORT).show();
            return false;
        }
        else {

            return true;
        }
    }

    @Override
    public void onBackPressed() {

    }

}
