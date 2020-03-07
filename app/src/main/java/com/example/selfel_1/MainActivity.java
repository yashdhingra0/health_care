package com.example.selfel_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout mdrawerLayout;
    ActionBarDrawerToggle mtoggle;
    NavigationView nag;
    Button facial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       facial = findViewById(R.id.face_detect);
       facial.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent inten= new Intent(MainActivity.this,ChooserActivity.class);
               startActivity(inten);
           }
       });





        mdrawerLayout = findViewById(R.id.drawer_layout);
        mtoggle = new ActionBarDrawerToggle(this, mdrawerLayout, R.string.open, R.string.close);
        mdrawerLayout.addDrawerListener(mtoggle);
        mtoggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nag = findViewById(R.id.nav_view);
        nag.setNavigationItemSelectedListener(this);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (mtoggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.ttestt: {
                Intent intent=new Intent(this,Fragment_Activity.class);
                startActivity(intent);

                break;
            }
            case R.id.whhyy: {
                Intent i = new Intent(MainActivity.this, why_ptsd.class);
                startActivity(i);
                break;
            }
            case R.id.aboutt: {
                Intent i = new Intent(MainActivity.this, selfel_why.class);
                startActivity(i);
                break;
            }

            case R.id.visit_web :
            {
                Intent i = new Intent(MainActivity.this, Website_visit.class);
                startActivity(i);
                break;
            }
            default:
                Toast.makeText(this, "ab", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
    public void startTest(View view) {
        Intent intent = new Intent(this, Ques_1.class);
        startActivity(intent);
    }
}