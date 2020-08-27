package com.example.dailyapp.matchcourses;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.dailyapp.R;

import java.util.List;

/**
 * Created by yarolegovich on 07.03.2017.
 */

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ViewHolder> {

    private List<Item> data;

    public ShopAdapter(List<Item> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_shop_card, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Item itemDatos = data.get(position);

        holder.tv_titulo.setText(itemDatos.getName());
        holder.tv_cantidad_cursos.setText(itemDatos.getPrice());


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView image;
        private TextView tv_titulo;
        private TextView tv_cantidad_cursos;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            tv_titulo = itemView.findViewById(R.id.tv_titulo);
            tv_cantidad_cursos = itemView.findViewById(R.id.tv_cantidad_cursos);
        }
    }
}
