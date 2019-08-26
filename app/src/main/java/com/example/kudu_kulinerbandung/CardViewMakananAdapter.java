package com.example.kudu_kulinerbandung;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardViewMakananAdapter extends RecyclerView.Adapter<CardViewMakananAdapter.CardViewViewHolder> {

    private ArrayList<Makanan> listMakanan;

    public CardViewMakananAdapter(ArrayList<Makanan> list){
        listMakanan = list;
    }

    @NonNull
    @Override
    public CardViewMakananAdapter.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_card_view,viewGroup,false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewMakananAdapter.CardViewViewHolder holder, int position) {
        Makanan makanan = listMakanan.get(position);

        Glide.with(holder.itemView.getContext())
                .load(makanan.getPhoto())
                .apply(new RequestOptions().override(350,550))
                .into(holder.imgPhoto);
        holder.tvName.setText(makanan.getNama());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
//                Toast.makeText(holder.itemView.getContext(), "Kamu memilih " + listMakanan.get(holder.getAdapterPosition()).getNama(), Toast.LENGTH_SHORT).show();
                Intent detMakanan = new Intent(holder.itemView.getContext(), DetailMakanan.class);
                detMakanan.putExtra("Nama", listMakanan.get(holder.getAdapterPosition()).getNama());
                detMakanan.putExtra("Harga", listMakanan.get(holder.getAdapterPosition()).getHarga());
                detMakanan.putExtra("Desk", listMakanan.get(holder.getAdapterPosition()).getDesk());
                detMakanan.putExtra("Photo", listMakanan.get(holder.getAdapterPosition()).getPhoto());
                detMakanan.putExtra("Lokasi", listMakanan.get(holder.getAdapterPosition()).getLokasi());
                context.startActivity(detMakanan);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listMakanan.size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder{
        ImageView imgPhoto;
        TextView tvName;

        public CardViewViewHolder(@NonNull View itemView){
            super(itemView);

            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_nama_makanan);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Context context = view.getContext();
//                    Intent detMakanan = new Intent(context, DetailMakanan.class);
//                    detMakanan.putExtra("Nama", listMakanan.get(holder.getAdapterPosition()).getNama());
//                    detMakanan.putExtra("Harga", listMakanan.get(holder.getAdapterPosition()).getHarga());
//                    detMakanan.putExtra("Desk", listMakanan.get(holder.getAdapterPosition()).getDesk());
//                    detMakanan.putExtra("Photo", listMakanan.get(holder.getAdapterPosition()).getPhoto());
//                    context.startActivity(detMakanan);
//
//                }
//            });
        }
    }
}
