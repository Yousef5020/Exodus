package com.exodus.exodus;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

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
                        break;
                    case R.id.nav_agency:
                        break;
                    case R.id.nav_trips:
                        break;
                    case R.id.nav_user:
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

    public void show_filter(View view) {
        fragment = new FilterFragment();
        switchFragment(fragment);
    }

    public void nav_fragment(View view) {
    }
}
