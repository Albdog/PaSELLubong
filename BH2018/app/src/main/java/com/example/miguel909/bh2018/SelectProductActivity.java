package com.example.miguel909.bh2018;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by miguel909 on 28/01/2018.
 */

public class SelectProductActivity extends AppCompatActivity {

    private ImageView productImage;
    private RecyclerView productDetailsRecyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private TextView quantityDisplay;
    private static int imageId;
    private static String name;
    private static String price;
    private static String description;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_product_activity);

        productImage = findViewById(R.id.select_product_image);
        TextView textView1 = findViewById(R.id.selected_product_name);
        TextView textView2 = findViewById(R.id.selected_product_price);
        TextView textView3 = findViewById(R.id.selected_product_description);

        String itemKey = getIntent().getExtras().getString("itemKey");
        final ProductItem productItem = new ProductItem(this);

        imageId = 0;
        name = "";
        price = "";
        description = "";

        for(int i = 0; i < productItem.getItemKey().size(); i++){
            if(productItem.getItemKey().get(i).equals(itemKey)){
                imageId = productItem.getResourceIds().get(i);
                name = productItem.getProductName().get(i);
                price = productItem.getProductPrice().get(i);
               description = productItem.getProductDescription().get(i);
            }
        }

        productImage.setImageResource(imageId);
        textView1.setText(name);
        textView2.setText(price);
        textView3.setText(description);


        quantityDisplay = findViewById(R.id.quantity_display);

        Button decreaseQuantityButton = findViewById(R.id.decrease_quantity_button);
        decreaseQuantityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = Integer.parseInt(quantityDisplay.getText().toString());

                if(num > 0){
                    num-=1;
                    quantityDisplay.setText(Integer.toString(num));
                }
            }
        });
        Button increaseQuantityButton = findViewById(R.id.increase_quantity_button);
        increaseQuantityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = Integer.parseInt(quantityDisplay.getText().toString());
                num+=1;
                quantityDisplay.setText(Integer.toString(num));
            }
        });

        Button addToCartButton = findViewById(R.id.add_to_cart_button);
        addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Order order = new Order(getApplication());
                order.addToCart(name, imageId, Integer.parseInt(quantityDisplay.getText().toString()), price);
            }
        });

    }
}
