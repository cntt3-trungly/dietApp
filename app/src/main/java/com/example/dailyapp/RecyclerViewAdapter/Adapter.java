package com.example.dailyapp.RecyclerViewAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.dailyapp.R;

import java.util.List;
/**
 * Created by Mohammmed Alsudani on 26-Jan-19.
 * for more visit http://materialuiux.com
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private LayoutInflater mInflater;
    private List<Itam> mData;

    public Adapter(List<Itam> Data) {
        mData = Data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_item, viewGroup, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        // set values for each item
        Itam itam = mData.get(position);
        viewHolder.txTitle.setText(itam.Title);
        viewHolder.txtBody.setText(itam.Body);
        viewHolder.txtcommentcount.setText(String.valueOf(itam.commentCount));
        viewHolder.txtDate.setText(itam.Date);
        viewHolder.txtlikecount.setText(String.valueOf(itam.likecount));

        // check if it was liked or no
        if (itam.like) {
            viewHolder.bLike.setImageResource(R.drawable.ic_like);
        } else {
            viewHolder.bLike.setImageResource(R.drawable.ic_unlike);
        }


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txTitle, txtBody, txtDate, txtcommentcount, txtlikecount;
        public ImageButton bLike;

        public ViewHolder(View v) {
            super(v);
            txTitle = (TextView) v.findViewById(R.id.id_Title_TextView);

            txtBody = (TextView) v.findViewById(R.id.id_body_TextView);
            txtDate = (TextView) v.findViewById(R.id.id_Date_TextView);
            txtcommentcount = (TextView) v.findViewById(R.id.id_commentCount_TextView);
            txtlikecount = (TextView) v.findViewById(R.id.id_likeCount_TextView);
            bLike = (ImageButton) v.findViewById(R.id.id_like_ImageButton);
        }
    }
}
