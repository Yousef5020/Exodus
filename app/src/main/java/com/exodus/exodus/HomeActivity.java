package com.exodus.exodus;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView bnv;

    Fragment fragment = null;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bnv = findViewById(R.id.nav);
        bnv.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nav_home:
                        fragment = new home();
                        switchFragment(fragment);
                        System.out.println("*********************************");
                        System.out.println("Home");
                        System.out.println("*********************************");
                        break;
                    case R.id.nav_agency:
                        System.out.println("*********************************");
                        System.out.println("Agencies");
                        System.out.println("*********************************");
                        break;
                    case R.id.nav_trips:
                        System.out.println("*********************************");
                        System.out.println("Trips");
                        System.out.println("*********************************");
                        break;
                    case R.id.nav_user:
                        System.out.println("*********************************");
                        System.out.println("User");
                        System.out.println("*********************************");
                        break;
                }
            }
        });
    }
    private void switchFragment(Fragment fragment) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_frame, fragment);
        fragmentTransaction.commit();
    }
}
