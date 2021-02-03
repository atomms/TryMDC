package com.ramiro.ernesto.trymdc;

import android.app.assist.AssistStructure;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        this.getSupportActionBar().setDisplayShowCustomEnabled(true);
//
//        LayoutInflater inflater = LayoutInflater.from(this);
//        View v = inflater.inflate(R.layout.custom_action_bar, null);
//
//        TextView titleTextView = (TextView) v.findViewById(R.id.custom_action_bar_title);
//        titleTextView.setText(this.getTitle());
//        titleTextView.setTypeface(App.getInstance().getActionBarTypeFace());
//
//        this.getSupportActionBar().setCustomView(v);


// cast al xml
        BottomNavigationView bottomNavBar = findViewById(R.id.bottom_navigation);

        // crear badges
        BottomNavigationMenuView bottomNavigationMenuView =
                (BottomNavigationMenuView) bottomNavBar.getChildAt(0);
        View v = bottomNavigationMenuView.getChildAt(0);
        BottomNavigationItemView itemView = (BottomNavigationItemView) v;

        View badge = LayoutInflater.from(this)
                .inflate(R.layout.layout_badge, itemView, true);

        //eventos de los items
        bottomNavBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.likes:
                        item.setChecked(true);
                        Toast.makeText(MainActivity.this, "Likes clicked.", Toast.LENGTH_SHORT).show();
                        removeBadge(bottomNavBar,item.getItemId());
                        break;
                    case R.id.add:
                        item.setChecked(true);
                        Toast.makeText(MainActivity.this, "Add clicked.", Toast.LENGTH_SHORT).show();
                        removeBadge(bottomNavBar,item.getItemId());
                        break;
                    case R.id.profile:
                        item.setChecked(true);
                        Toast.makeText(MainActivity.this, "Profile clicked.", Toast.LENGTH_SHORT).show();
                        removeBadge(bottomNavBar,item.getItemId());
                        break;
                    case R.id.marker:
                        item.setChecked(true);
                        Toast.makeText(MainActivity.this, "Marker clicked.", Toast.LENGTH_SHORT).show();
                        removeBadge(bottomNavBar,item.getItemId());
                        break;
                }
                return false;
            }
        });

    }

//    public static void showBadge(BottomNavigationView.OnNavigationItemSelectedListener context, BottomNavigationView
//            bottomNavigationView, @IdRes int itemId, String value) {
//        removeBadge(bottomNavigationView, itemId);
//
//        BottomNavigationItemView itemView = bottomNavigationView.findViewById(itemId);
//        View badge = LayoutInflater.from((Context) context).inflate(R.layout.layout_badge, bottomNavigationView, false);
//
//        TextView text = badge.findViewById(R.id.badge_text_view);
//        text.setText(value);
//        itemView.addView(badge);
//    }
//
    public static void removeBadge(BottomNavigationView bottomNavigationView, @IdRes int itemId) {
        BottomNavigationItemView itemView = bottomNavigationView.findViewById(itemId);
        if (itemView.getChildCount() == 3) {
            itemView.removeViewAt(2);
        }
    }
}
