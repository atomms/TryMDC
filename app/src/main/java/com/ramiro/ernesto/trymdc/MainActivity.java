package com.ramiro.ernesto.trymdc;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomappbar.BottomAppBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomAppBar bottomAppBar = findViewById(R.id.bottomAppBar);

        bottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Back clicked!", Toast.LENGTH_SHORT).show();
            }
        });

//        bottomAppBar.setOnMenuItemClickListener() { menuItem ->
//                when (menuItem.itemId) {
//            R.id.search -> {
//                // Handle search icon press
//                true
//            }
//            R.id.more -> {
//                // Handle more item (inside overflow menu) press
//                true
//            }
//        else -> false
//        }
//        }

    }

}