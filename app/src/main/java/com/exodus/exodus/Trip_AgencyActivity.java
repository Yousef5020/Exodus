package com.exodus.exodus;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class Trip_AgencyActivity extends AppCompatActivity {

    BottomNavigationView bnv;

    Fragment fragment = null;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip__agency);

        bnv = findViewById(R.id.de_nav);
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nav_home:
                        fragment = new home();
                        switchFragment(fragment);
                        break;
                    case R.id.nav_agency:
                        break;
                    case R.id.nav_trips:
                        fragment = new TripsFragment();
                        switchFragment(fragment);
                        break;
                    case R.id.nav_user:
                        break;
                }
                return true;
            }
        });
    }

    private void switchFragment(Fragment fragment) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_frame, fragment);
        fragmentTransaction.commit();
    }
}
