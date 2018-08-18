package model;

import java.util.Date;

public class Offer {
    private String productName;
    private String pictureURL;
    private int amount;
    private Date timeToPublish;
    private Date timeToDelete;

    public Offer() {}

    public Offer(int amount, String pictureURL, Date timeToPublish, Date timeToDelete) {
        this.amount = amount;
        this.pictureURL = pictureURL;
        this.timeToPublish = timeToPublish;
        this.timeToDelete = timeToDelete;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
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

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
