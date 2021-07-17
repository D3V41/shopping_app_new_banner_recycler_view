package com.example.progaurd.model;

public class HorizontalProductsScrollModel {
    private int productImage;
    private String productTitle;
    private String productDescription;
    private String productPrize;

    public HorizontalProductsScrollModel(int productImage, String productTitle, String productDescription, String productPrize) {
        this.productImage = productImage;
        this.productTitle = productTitle;
        this.productDescription = productDescription;
        this.productPrize = productPrize;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductPrize() {
        return productPrize;
    }

    public void setProductPrize(String productPrize) {
        this.productPrize = productPrize;
    }
}
