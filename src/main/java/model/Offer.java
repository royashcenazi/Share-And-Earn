package model;

import java.util.Date;

public class Offer {
    private int maxAmount;
    private String productUrl;
    private Date timeToPublish;
    private Date timeToDelete;

    public Offer() {}

    public Offer(int maxAmount, String productUrl, Date timeToPublish, Date timeToDelete) {
        this.maxAmount = maxAmount;
        this.productUrl = productUrl;
        this.timeToPublish = timeToPublish;
        this.timeToDelete = timeToDelete;
    }

    public int getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(int maxAmount) {
        this.maxAmount = maxAmount;
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
