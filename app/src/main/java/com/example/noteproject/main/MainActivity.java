package com.example.noteproject.main;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.MenuItem;

import com.example.noteproject.R;
import com.example.noteproject.fragment.ContactsFragment;
import com.example.noteproject.fragment.NotesFragment;
import com.example.noteproject.fragment.ProfileFragments;
import com.example.noteproject.model.ContactsModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView navigationView;
    RecyclerView rvContacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragment(new NotesFragment());
        initViews();
        initBottomNavigation();


    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(fragment.getTag());
        transaction.commit();
    }

    private void initBottomNavigation() {
        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item_main:
                        loadFragment(new NotesFragment());
                        break;

                    case R.id.item_contacts:
                        loadFragment(new ContactsFragment());
                        break;

                    case R.id.item_profile:
                        loadFragment(new ProfileFragments());
                        break;
                }
                return false;
            }
        });
    }

    private void initViews() {
        navigationView = findViewById(R.id.bottom_navigation);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}