package com.example.kudu_kulinerbandung;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailMakanan extends AppCompatActivity {

    private TextView tvHarga,tvDesk,tvLokasi;
    private ImageView imgPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_makanan);

        tvHarga = findViewById(R.id.tv_harga_makanan);
        tvDesk = findViewById(R.id.tv_desk_makanan);
        tvLokasi = findViewById(R.id.tv_tempat);
        imgPhoto = findViewById(R.id.img_foto);

        Bundle bundle = getIntent().getExtras();

        String Nama = bundle.getString("Nama");
        String Harga = bundle.getString("Harga");
        String Desk = bundle.getString("Desk");
        String Lokasi = bundle.getString("Lokasi");

        Glide.with(this)
                .load(bundle.getString("Photo"))
                .apply(new RequestOptions().override(350,550))
                .into(imgPhoto);

        tvHarga.setText(Harga);
        tvDesk.setText(Desk);
        tvLokasi.setText(Lokasi);

        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle(Nama);
        }


    }
}
