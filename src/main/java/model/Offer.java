package model;

import java.util.Date;

public class Offer {
    private String productName;
    private String pictureURL;
    private int points;
    private Date timeToPublish;
    private Date timeToDelete;
    private int maxPublishers;

    public Offer() {}

    public Offer(int points, String pictureURL, Date timeToPublish, Date timeToDelete, String productName, int maxPublishers) {
        this.points = points;
        this.pictureURL = pictureURL;
        this.timeToPublish = timeToPublish;
        this.timeToDelete = timeToDelete;
        this.productName = productName;
        this.maxPublishers = maxPublishers;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
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

    public int getMaxPublishers() {
        return maxPublishers;
    }

    public void setMaxPublishers(int maxPublishers) {
        this.maxPublishers = maxPublishers;
    }
}
