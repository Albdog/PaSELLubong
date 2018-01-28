package com.example.miguel909.bh2018;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
    private ProductItem productItem;
    private String tribeKey;

    public ProductAdapter(Context c, String key) {
        mContext = c;
        productItem = new ProductItem(mContext);
        tribeKey = key;
    }

    @Override
    public int getCount() {
        return productItem.getResourceIds().size();
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        ProductView view;

        convertView = LayoutInflater.from(mContext).inflate(R.layout.product_item, null);

        view = new ProductView();
        view.productArea = convertView.findViewById(R.id.product_item);
        view.productImage = convertView.findViewById(R.id.product_image);
        view.productName = convertView.findViewById(R.id.product_name);
        view.productPrice = convertView.findViewById(R.id.product_price);
        
        view.productImage.setImageResource(productItem.getResourceIds().get(position));
        view.productName.setText(productItem.getProductName().get(position));
        view.productPrice.setText(productItem.getProductPrice().get(position));
        view.productArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itemSelected = new Intent(v.getContext(), SelectProductActivity.class);
                itemSelected.putExtra("itemKey", productItem.getItemKey().get(position));
                v.getContext().startActivity(itemSelected);
            }
        });

        convertView.setTag(view);


        return convertView;
    }

    public static class ProductView extends AppCompatActivity {
        View productArea;
        ImageView productImage;
        TextView productName;
        TextView productPrice;
    }
}
