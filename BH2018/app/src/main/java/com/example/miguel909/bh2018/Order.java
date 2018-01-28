package com.example.miguel909.bh2018;

/**
 * Created by miguel909 on 28/01/2018.
 */

public class Order {
    private int itemKey;
    private int itemImage;
    private int quantity;
    private int unitPrice;

    public Order(int ik, int ii, int q, int up){
        itemKey = ik;
        itemImage = ii;
        quantity = q;
        unitPrice = up;
    }

    public int getItemKey() {
        return itemKey;
    }

    public void setItemKey(int itemKey) {
        this.itemKey = itemKey;
    }

    public int getItemImage() {
        return itemImage;
    }

    public void setItemImage(int itemImage) {
        this.itemImage = itemImage;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }
}
