package com.example.miguel909.bh2018;

/**
 * Created by miguel909 on 27/01/2018.
 */

class CategoryItem {
    private static int[] resourceIds;
    private static String[] title;

    public CategoryItem(){
        resourceIds = new int[]{R.drawable.trinkets, R.drawable.textiles, R.drawable.furniture, R.drawable.raw_materials, R.drawable.shells, R.drawable.rattan ,R.drawable.jewelry, R.drawable.coconut, R.drawable.bamboo};
        title = new String[] {"Trinkets", "Textiles", "Furniture", "Raw Materials", "Shells", "Rattan", "Jewelry", "Coconut", "Bamboo"};
    }

    public static String[] getTitle() {
        return title;
    }

    public static void setTitle(String[] title) {
        CategoryItem.title = title;
    }

    public static int[] getResourceIds() {
        return resourceIds;
    }

    public static void setResourceIds(int[] resourceIds) {
        CategoryItem.resourceIds = resourceIds;
    }
}
