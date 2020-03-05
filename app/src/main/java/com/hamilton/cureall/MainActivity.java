package com.hamilton.cureall;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomTabs = findViewById(R.id.bottom_tabs);
        bottomTabs.setOnNavigationItemSelectedListener(tabListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new AllFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener tabListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.All_Tab:
                            selectedFragment = new AllFragment();
                            break;
                        case R.id.Top15_Tab:
                            selectedFragment = new Top15Fragment();
                            break;
                        case R.id.Search_Tab:
                            selectedFragment = new SearchFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };
}
