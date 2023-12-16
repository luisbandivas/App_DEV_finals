package com.example.appdevfinals;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Landing extends AppCompatActivity {

    Button btnM, btmV;

    private boolean isDarkTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        btnM = findViewById(R.id.btn_mission);
        btmV = findViewById(R.id.btn_vision);

        if(savedInstanceState == null){
            frag_mission fm = new frag_mission();
            changFrag(fm);
        }
        btnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changFrag(new frag_mission());

                Toast.makeText(Landing.this, "Mission", Toast.LENGTH_LONG).show();
            }
        });

        btmV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changFrag(new frag_vision());

                Toast.makeText(Landing.this, "Vision", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void changFrag(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framefrag,fragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //MenuInflater menuInflater = getMenuInflater();
        getMenuInflater().inflate(R.menu.option_menubar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.opt_guess){
            Intent intent = new Intent(this, word_guess.class);
            startActivity(intent);
        }
        else if(item.getItemId() == R.id.opt_abtme){
            Intent intent = new Intent(this, AboutMe.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}