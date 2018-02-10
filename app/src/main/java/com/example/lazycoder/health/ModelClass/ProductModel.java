package com.example.lazycoder.health.ModelClass;

/**
 * Created by lazycoder on 2/9/18.
 */

public class ProductModel {

    private int id;
    private String productCode;
    private String title;
    private String shortDescription;
    private String fullDescription;
    private String imageUrl;
    private String state;
    private String category;
    private String shopName;
    private String address;
    private String postCode;
    private String phone;

    public ProductModel(String productCode, String title, String shortDescription, String fullDescription, String imageUrl, String state, String category, String shopName, String address, String postCode, String phone) {

        this.productCode = productCode;
        this.title = title;
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
        this.imageUrl = imageUrl;
        this.state = state;
        this.category = category;
        this.shopName = shopName;
        this.address = address;
        this.postCode = postCode;
        this.phone = phone;
    }

    public ProductModel(int id, String productCode, String title, String shortDescription, String fullDescription, String imageUrl, String state, String category, String shopName, String address, String postCode, String phone) {

        this.id = id;
        this.productCode = productCode;
        this.title = title;
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
        this.imageUrl = imageUrl;
        this.state = state;
        this.category = category;
        this.shopName = shopName;
        this.address = address;
        this.postCode = postCode;
        this.phone = phone;
    }


    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public ProductModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getTitle() {
        return title;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
