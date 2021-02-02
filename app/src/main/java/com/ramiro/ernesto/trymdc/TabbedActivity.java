package com.ramiro.ernesto.trymdc;

import android.os.Bundle;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.ramiro.ernesto.trymdc.ui.main.SectionsPagerAdapter;

public class TabbedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

// cast al xml
        BottomNavigationView bottomNavBar = findViewById(R.id.bottom_navigation);


//        //click event en el  FAB
//        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(TabbedActivity.this, "FAB Clicked.", Toast.LENGTH_SHORT).show();
//            }
//        });

//        //click event en el Hamburguer menu
//        bottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(TabbedActivity.this, "Ham clicked!", Toast.LENGTH_SHORT).show();
////                sheetBehavior = BottomSheetBehavior.from(sheet);
//            }
//
//
//        });

//        //click event en el Bottom bar menu item
//        bottomNavBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//
//            public boolean onMenuItemClick(MenuItem item) {
//                switch (item.getItemId()) {
//                    case R.id.more:
//                        Toast.makeText(TabbedActivity.this, "About clicked.", Toast.LENGTH_SHORT).show();
//                        break;
//                    case R.id.search:
//                        Toast.makeText(TabbedActivity.this, "Settings clicked.", Toast.LENGTH_SHORT).show();
//                        break;
//                }
//                return false;
//            }
//        });

bottomNavBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.likes:
                item.setChecked(true);
                Toast.makeText(TabbedActivity.this, "Likes clicked.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.add:
                item.setChecked(true);
                Toast.makeText(TabbedActivity.this, "Add clicked.", Toast.LENGTH_SHORT).show();
                break;
        }
        return false;
    }
});

    }
}
