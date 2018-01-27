package com.example.miguel909.bh2018;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

/**
 * Created by miguel909 on 27/01/2018.
 */

class ProductAdapter extends BaseAdapter {

    private Context mContext;

    public ProductAdapter(Context c) {
        mContext = c;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ProductView view;

        convertView = LayoutInflater.from(mContext).inflate(R.layout.product_item, null);
        ProductItem productItem = new ProductItem();

        view = new ProductView();
        view.productImage = convertView.findViewById(R.id.product_image);
        view.productName = convertView.findViewById(R.id.product_name);
        view.productPrice = convertView.findViewById(R.id.product_price);

        view.productImage.setImageResource(productItem.getResourceIds()[position]);
        view.productName.setText(productItem.getProductName()[position]);
        view.productPrice.setText(productItem.getProductPrice()[position]);

        convertView.setTag(view);

        return convertView;
    }

    public static class ProductView extends AppCompatActivity {
        ImageView productImage;
        TextView productName;
        TextView productPrice;
    }
}
