package com.exodus.exodus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button login_dialog = findViewById(R.id.btn_login);

        login_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log_In_Activity log_in = new Log_In_Activity();
                log_in.show(getSupportFragmentManager() ,"login");
            }
        });

        Button signup_dialog = findViewById(R.id.btn_signup);

        signup_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sign_up_Activity sign_up = new Sign_up_Activity();
                sign_up.show(getSupportFragmentManager() ,"sign up");
            }
        });
    }
}
