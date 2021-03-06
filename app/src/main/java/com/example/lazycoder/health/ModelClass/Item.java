package com.example.lazycoder.health.ModelClass;

/**
 * Created by lazycoder on 2/8/18.
 */

public class Item {
    private String title;
    private String description;
    private String location;
    private int imageUrl;
    private String productCode;

    public Item(String title, String description, String location, int imageUrl) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.imageUrl = imageUrl;
    }

    public Item(String title, String description, String location, int imageUrl, String productCode) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.imageUrl = imageUrl;
        this.productCode = productCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
}
