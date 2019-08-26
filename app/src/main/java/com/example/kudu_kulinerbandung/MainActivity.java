package com.example.kudu_kulinerbandung;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvMakanan;
    private ArrayList<Makanan> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMakanan = findViewById(R.id.rv_makanan);
        rvMakanan.setHasFixedSize(true);

        list.addAll(DataMakanan.getListData());
        showRecyclerCardView();
    }

    private void showRecyclerCardView(){
        rvMakanan.setLayoutManager(new LinearLayoutManager(this));
        CardViewMakananAdapter cardViewMakananAdapter = new CardViewMakananAdapter(list);
        rvMakanan.setAdapter(cardViewMakananAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.about, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.about:
                toAboutIntent();
                return true;

        }
        return false;
    }
    public void toAboutIntent(){
        Intent about = new Intent(MainActivity.this,About.class);
        startActivity(about);
    }
}
