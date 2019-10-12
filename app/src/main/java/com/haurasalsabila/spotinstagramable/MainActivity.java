package com.haurasalsabila.spotinstagramable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvSpot;

    String[] nameSpot;
    String[] descriptionSpot;
    String[] placeSpot;

    int[] photoSpot;

    private String title = "Spot Foto Instagramable";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setActionBarTitle(title);

        rvSpot = findViewById(R.id.rv_spot);

        nameSpot = getResources().getStringArray(R.array.spot_name);
        descriptionSpot = getResources().getStringArray(R.array.spot_description);
        placeSpot = getResources().getStringArray(R.array.spot_place);

        photoSpot = new int[] {R.drawable.spot1, R.drawable.spot2,R.drawable.spot3,R.drawable.spot4,R.drawable.spot5,
                R.drawable.spot6, R.drawable.spot7, R.drawable.spot8,R.drawable.spot9,R.drawable.spot10};

        AdapterSpot adapterSpot = new AdapterSpot(MainActivity.this,nameSpot,descriptionSpot,placeSpot,photoSpot);

        rvSpot.setHasFixedSize(true);
        rvSpot.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        rvSpot.setAdapter(adapterSpot);

        
    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.about:
                about();
                break;
        }

    }

    private void about() {
        Intent intent = new Intent(getApplicationContext(),TentangKu.class);
        startActivity(intent);
    }
}
