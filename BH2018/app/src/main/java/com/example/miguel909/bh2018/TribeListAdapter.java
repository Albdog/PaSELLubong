package com.example.miguel909.bh2018;

import android.content.Context;
import android.content.Intent;
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

    private Context mContext;
    private TribeItem tribeItem;

    public TribeListAdapter(Context c){
        mContext = c;
        tribeItem = new TribeItem(mContext);
    }

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
        return tribeItem.getResourceIds().size();
    }

    private class ListViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImageView;
        private View view;

        public ListViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.tribe_picture);
            view = itemView.findViewById(R.id.tribe_item);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
        }

        public void bindView(final int position){

            mImageView.setImageResource(tribeItem.getResourceIds().get(position));
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent selectTribe = new Intent(v.getContext(), DisplayProductsActivity.class);
                    selectTribe.putExtra("selectedTribe", tribeItem.getTribeKey().get(position));
                    v.getContext().startActivity(selectTribe);
                }
            });

        }
    }
}
