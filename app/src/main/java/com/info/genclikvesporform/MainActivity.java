package com.info.genclikvesporform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerFormlar;
    private Button buttonDevam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerFormlar = findViewById(R.id.spinnerFormlar);
        buttonDevam = findViewById(R.id.buttonDevam);

        buttonDevam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, FormBilgileriActivity.class));
            }
        });

    }
}