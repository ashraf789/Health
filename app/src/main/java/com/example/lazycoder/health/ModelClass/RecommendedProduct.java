package com.example.lazycoder.health.ModelClass;

/**
 * Created by lazycoder on 2/8/18.
 */

public class RecommendedProduct {
    private String title;
    private String shortDescription;
    private String location;
    private int imageUrl;
    private String productCode;

    public RecommendedProduct(String title, String description, String location, int imageUrl) {
        this.title = title;
        this.shortDescription = description;
        this.location = location;
        this.imageUrl = imageUrl;
    }

    public RecommendedProduct(String title, String description, String location) {
        this.title = title;
        this.shortDescription = description;
        this.location = location;
    }

    public RecommendedProduct(String title, String shortDescription, String location, int imageUrl, String productCode) {
        this.title = title;
        this.shortDescription = shortDescription;
        this.location = location;
        this.imageUrl = imageUrl;
        this.productCode = productCode;
    }

    public String getTitle() {
        return title;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
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
}
