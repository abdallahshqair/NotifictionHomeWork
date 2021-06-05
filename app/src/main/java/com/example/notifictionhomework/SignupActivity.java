package com.example.notifictionhomework;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.notifictionhomework.api.APIInterface;
import com.example.notifictionhomework.api.Api;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {
    EditText first_name, secound_name, email, password;
    Button insertTv;
    TextView login;
    ProgressDialog mProgressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        first_name = findViewById(R.id.first_name);
        secound_name = findViewById(R.id.secound_name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        insertTv = findViewById(R.id.insertTv);
        login = findViewById(R.id.login_user);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        });
        insertTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup(first_name.getText().toString(), secound_name.getText().toString(),
                        email.getText().toString(), password.getText().toString());
            }
        });
    }

    public void signup(String FirstName, String SecoundName, String Email, String Password) {
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage("Loading....");
        mProgressDialog.show();

        Call<Result> call = Api.getINSTANCE(getApplicationContext()).getApiInterface().signup(
                new CreateUser(FirstName, SecoundName, Email, Password));
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                if (response.isSuccessful()) {
                    if (response.body().isStatus() == true) {
                        mProgressDialog.dismiss();

                        Toast.makeText(SignupActivity.this, "تم إنشاء مستخدم جديد",
                                Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SignupActivity.this,HomeActivity.class));
                    } else mProgressDialog.dismiss();
                } else mProgressDialog.dismiss();

                Log.d("abdallah", response.body() + "");
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.d("abdallah", t.getMessage() + "");
                mProgressDialog.dismiss();
            }
        });


    }
}
