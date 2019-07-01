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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Log_In_Activity extends DialogFragment {

    EditText e_mail;
    EditText password;

    @Override
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(),R.style.Theme_AppCompat_Light_Dialog_Alert);

        LayoutInflater inflater = getActivity().getLayoutInflater();
        @SuppressLint("InflateParams") View view = inflater.inflate(R.layout.activity_log__in_,null);

        e_mail = view.findViewById(R.id.etmail);
        password = view.findViewById(R.id.etpassword);

        Button b = view.findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                log_in();
            }
        });
        builder.setView(view);
        return builder.create();
    }

    void log_in(){
        String e_mail = this.e_mail.getText().toString().trim();
        String password = this.password.getText().toString().trim();

        if (e_mail.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(e_mail).matches()){
            this.e_mail.setError("E-Mail is not valid");
            this.e_mail.requestFocus();
            return;
        }

        if (password.isEmpty()){
            this.password.setError("Password is required");
            this.password.requestFocus();
            return;
        }

        Call<LoginResponse> call = RetrofitClient.getInstance().getApi().UserLogin(e_mail ,password);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(@NonNull Call<LoginResponse> call, @NonNull Response<LoginResponse> response) {
                LoginResponse respon = response.body();

                if (respon != null){
                    if (respon.isValid()){
                        SharedPreferenceManager.getInstance(getContext()).saveUser(respon.getUser());

                        Intent home = new Intent(getContext() ,HomeActivity.class);
                        home.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(home);
                    }
                    else
                        Toast.makeText(getContext(),respon.getMessage(),Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(getContext(),"User not found",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(@NonNull Call<LoginResponse> call, @NonNull Throwable t) {
                Toast.makeText(getContext(),"User not found",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
