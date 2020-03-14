package com.hamilton.cureall;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Top15NoteViewModel top15NoteViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // MIGHT HAVE TO CHANGE
        top15NoteViewModel = ViewModelProviders.of(this).get(Top15NoteViewModel.class);

        top15NoteViewModel.getTop15AllNotes().observe(this, new Observer<List<Top15Note>>() {
            @Override
            public void onChanged(List<Top15Note> top15Notes) {
                // update RecyclerView
                Toast.makeText(MainActivity.this, "onChanged", Toast.LENGTH_SHORT).show();
            }
        });
        // MIGHT HAVE TO CHANGE

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
