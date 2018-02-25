package com.example.miguel909.bh2018;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by miguel909 on 28/01/2018.
 */

public class CartAdapter extends RecyclerView.Adapter{

    private Context mContext;
    private Order order;

    CartAdapter(Context c){
        mContext = c;
        order = new Order(c);

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ListViewHolder) holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return order.getItemKey().size();
    }

    private class ListViewHolder extends RecyclerView.ViewHolder {

        ImageView mImageView;
        TextView mTextView1;
        TextView mTextView2;
        TextView mTextView3;
        Button button;

        public ListViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.cart_image);
            mTextView1 = itemView.findViewById(R.id.cart_name);
            mTextView2 = itemView.findViewById(R.id.cart_quantity);
            mTextView3 = itemView.findViewById(R.id.cart_price);
            button = itemView.findViewById(R.id.remove_button);
        }

        public void bindView(final int position) {
            mImageView.setImageResource(order.getItemImage().get(position));
            mTextView1.setText(order.getItemName().get(position));
            mTextView2.setText(Integer.toString(order.getQuantity().get(position)));
            mTextView3.setText(order.getUnitPrice().get(position));
        }
    }
}
