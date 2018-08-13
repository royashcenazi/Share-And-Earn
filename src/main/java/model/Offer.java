package model;

import java.util.Date;

public class Offer {
    private int maxAmount;
    private String productUrl;
    private Product product;
    private Date timeToPublish;
    private Date timeToDelete;

    public Offer() {
    }

    public int getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(int maxAmount) {
        this.maxAmount = maxAmount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getTimeToPublish() {
        return timeToPublish;
    }

    public void setTimeToPublish(Date timeToPublish) {
        this.timeToPublish = timeToPublish;
    }

    public Date getTimeToDelete() {
        return timeToDelete;
    }

    public void setTimeToDelete(Date timeToDelete) {
        this.timeToDelete = timeToDelete;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }
}
