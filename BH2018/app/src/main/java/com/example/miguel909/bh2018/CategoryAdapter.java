package com.example.miguel909.bh2018;

import android.content.Context;
import android.content.Intent;
import android.graphics.Region;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by miguel909 on 27/01/2018.
 */

class CategoryAdapter extends BaseAdapter {
    private Context mContext;
    private CategoryItem mCategoryItem;

    public CategoryAdapter(Context c) {
        mContext = c;
        mCategoryItem = new CategoryItem();
    }

    @Override
    public int getCount() {
        CategoryItem categoryItem = new CategoryItem();
        return categoryItem.getTitle().length;
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
        final CategoryView view;

        convertView = LayoutInflater.from(mContext).inflate(R.layout.category_item, null);

        view = new CategoryView();
        view.categoryIcon = convertView.findViewById(R.id.category_icon);
        view.categoryTitle = convertView.findViewById(R.id.category_title);
        view.categoryItem = convertView.findViewById(R.id.category_area)
        ;

        view.categoryIcon.setImageResource(mCategoryItem.getResourceIds()[position]);
        view.categoryTitle.setText(mCategoryItem.getTitle()[position]);
        view.categoryItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent categorySelected = new Intent(v.getContext(), RegionActivity.class);
                categorySelected.putExtra("selectedCategory", CategoryItem.getTitle()[position]);
                v.getContext().startActivity(categorySelected);
            }
        });

        convertView.setTag(view);


        return convertView;
    }

    public static class CategoryView extends AppCompatActivity {
        ImageView categoryIcon;
        TextView categoryTitle;
        LinearLayout categoryItem;
    }
}
