package com.example.miguel909.bh2018;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by miguel909 on 27/01/2018.
 */

class TribeListAdapter extends RecyclerView.Adapter {

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tribe_item, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ListViewHolder) holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        TribeItem tmp = new TribeItem();
        return tmp.getNames().length;
    }

    private class ListViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImageView;
        private TextView mTextView;

        public ListViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.tribe_picture);
            mTextView = itemView.findViewById(R.id.tribe_name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
        }

        public void bindView(int position){
            TribeItem tmp = new TribeItem();
            mImageView.setImageResource(tmp.getResourceIds()[position]);
            mTextView.setText(tmp.getNames()[position]);

        }
    }
}
