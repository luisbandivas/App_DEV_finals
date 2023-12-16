package com.example.appdevfinals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int num1 = 5;
    int num2 = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btn_enter);
        btn.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), Landing.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onStart(){
        super.onStart();

        num1 += 2;
        num2 += 2;

        Toast.makeText(MainActivity.this, "Welcome user!", Toast.LENGTH_LONG).show();
    }
}