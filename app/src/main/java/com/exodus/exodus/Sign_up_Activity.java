package com.exodus.exodus;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Sign_up_Activity extends DialogFragment {

    EditText name,e_mail,phone,city,password,conf_password;

    @Override
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder((getActivity()),R.style.Theme_AppCompat_Light_Dialog_Alert);

        LayoutInflater inflater = getActivity().getLayoutInflater();
        @SuppressLint("InflateParams") View view = inflater.inflate(R.layout.signup,null);

        name = view.findViewById(R.id.user_name);
        e_mail = view.findViewById(R.id.e_mail);
        phone = view.findViewById(R.id.phone);
        city = view.findViewById(R.id.city);
        password = view.findViewById(R.id.password);
        conf_password = view.findViewById(R.id.re_password);

        Button b = view.findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userSign_up();
            }
        });
        builder.setView(view);
        return builder.create();
    }

    private void userSign_up() {
        String name = this.name.getText().toString().trim();
        String email = this.e_mail.getText().toString().trim();
        String phone = this.phone.getText().toString().trim();
        String city = this.city.getText().toString().trim();
        String password = this.password.getText().toString().trim();
        String confirm_password = this.conf_password.getText().toString().trim();

        if(email.isEmpty()) {
            this.e_mail.setError("Email is required");
            this.e_mail.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            this.e_mail.setError("enter a valid email");
            this.e_mail.requestFocus();
            return;
        }

        if(password.isEmpty()) {
            this.password.setError("password Required");
            this.password.requestFocus();
            return;
        }

        if(name.isEmpty()) {
            this.name.setError("name Required");
            this.name.requestFocus();
            return;
        }

        if(city.isEmpty()) {
            this.city.setError("city Required");
            this.city.requestFocus();
            return;
        }

        if(!confirm_password.equals(password)) {
            this.conf_password.setError("password and confirm password are not equal");
            this.conf_password.requestFocus();
            return;
        }

        if(phone.isEmpty()) {
            this.phone.setError("phone Required");
            this.phone.requestFocus();
            return;
        }

        if(!Patterns.PHONE.matcher(phone).matches()) {
            this.phone.setError("enter a valid phone");
            this.phone.requestFocus();
            return;
        }

        Call<ResponseBody> call = RetrofitClient
                .getInstance().getApi()
                .createUser(name, password, email, phone, city);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {

                String s = null;

                try {
                    if(response.code() == 201) {
                        assert response.body() != null;
                        s = response.body().toString();
                    } else {
                        assert response.errorBody() != null;
                        s = response.errorBody().toString();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {
                    if(s != null) {
                        new JSONObject(s);
                        Intent main = new Intent(getContext() ,MainActivity.class);
                        main.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(main);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
