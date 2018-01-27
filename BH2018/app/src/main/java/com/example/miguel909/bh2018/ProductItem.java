package com.example.miguel909.bh2018;

/**
 * Created by miguel909 on 27/01/2018.
 */

class ProductItem {
    private static int[] resourceIds;
    private static String[] productName;
    private static String[] productPrice;

    public ProductItem(){
        resourceIds = new int[]{R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background};
        productName = new String[] {"Product 1", "Product 2", "Product 3"};
        productPrice = new String[] {"1234.56", "345.78", "5023.12"};
    }

    public static int[] getResourceIds() {
        return resourceIds;
    }

    public static void setResourceIds(int[] resourceIds) {
        ProductItem.resourceIds = resourceIds;
    }

    public static String[] getProductName() {
        return productName;
    }

    public static void setProductName(String[] productName) {
        ProductItem.productName = productName;
    }

    public static String[] getProductPrice() {
        return productPrice;
    }

    public static void setProductPrice(String[] productPrice) {
        ProductItem.productPrice = productPrice;
    }
}
