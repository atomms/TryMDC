package com.ramiro.ernesto.trymdc;

import android.os.Bundle;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.ramiro.ernesto.trymdc.ui.main.PlaceholderFragment;
import com.ramiro.ernesto.trymdc.ui.main.SectionsPagerAdapter;

public class TabbedActivity extends AppCompatActivity {
    private ItemViewModel viewModel;
    private MenuItem prevMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
//        TabLayout tabs = findViewById(R.id.tabs);
//        tabs.setupWithViewPager(viewPager);

        //startFragment
        viewModel = new ViewModelProvider(this).get(ItemViewModel.class);
        viewModel.getSelectedItem().observe(this, item -> {
            // Perform an action with the latest item data

        });




// cast al xml
        BottomNavigationView bottomNavBar = findViewById(R.id.bottom_navigation);

        // crear badges
        BottomNavigationMenuView bottomNavigationMenuView =
                (BottomNavigationMenuView) bottomNavBar.getChildAt(0);
        View v = bottomNavigationMenuView.getChildAt(2);
        BottomNavigationItemView itemView = (BottomNavigationItemView) v;

        LayoutInflater.from(this)
                .inflate(R.layout.layout_badge, itemView, true);


        bottomNavBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.likes:
                        item.setChecked(true);
                        Toast.makeText(TabbedActivity.this, "Likes clicked.", Toast.LENGTH_SHORT).show();
                        removeBadge(bottomNavBar,item.getItemId());
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.add:
                        item.setChecked(true);
                        Toast.makeText(TabbedActivity.this, "Add clicked.", Toast.LENGTH_SHORT).show();
                        removeBadge(bottomNavBar,item.getItemId());
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.profile:
                        item.setChecked(true);
                        Toast.makeText(TabbedActivity.this, "Add clicked.", Toast.LENGTH_SHORT).show();
                        removeBadge(bottomNavBar,item.getItemId());
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.marker:
                        item.setChecked(true);
                        Toast.makeText(TabbedActivity.this, "Add clicked.", Toast.LENGTH_SHORT).show();
                        removeBadge(bottomNavBar,item.getItemId());
                        viewPager.setCurrentItem(3);
                        break;
                }
                return false;
            }
        });


//        here we listen to viewpager moves and set navigations items checked or not

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null)
                    prevMenuItem.setChecked(false);

                else
                    bottomNavBar.getMenu().getItem(0).setChecked(false);

                bottomNavBar.getMenu().getItem(position).setChecked(true);
                removeBadge(bottomNavBar,bottomNavBar.getMenu().getItem(position).getItemId());
                prevMenuItem = bottomNavBar.getMenu().getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    //removong badges
    public static void removeBadge(BottomNavigationView bottomNavigationView, @IdRes int itemId) {
        BottomNavigationItemView itemView = bottomNavigationView.findViewById(itemId);
        if (itemView.getChildCount() == 3) {
            itemView.removeViewAt(2);
        }
    }
}
