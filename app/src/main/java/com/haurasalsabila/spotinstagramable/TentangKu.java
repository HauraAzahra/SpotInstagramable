package com.haurasalsabila.spotinstagramable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class TentangKu extends AppCompatActivity {

    private String title = "Tentang";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang_ku);
        setActionBarTitle(title);
    }
    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }
}

