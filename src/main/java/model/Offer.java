package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Offer {
    private String productName;
    private String pictureURL;
    private int points;
    private Date timeToPublish;
    private Date timeToDelete;
    private int maxPublishers;
    private int offerId;
    private int currentPublisherNumber;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public Offer() {}

    @Override
    public boolean equals(Object obj) {
        try {
            Offer offer = (Offer) obj;
            return this.getOfferId() == offer.getOfferId();
        }catch (Exception e){
            return false;
        }
    }

    public Offer(int points, String pictureURL, Date timeToPublish, Date timeToDelete, String productName, int maxPublishers, int id) {
        this.points = points;
        this.pictureURL = pictureURL;
        this.timeToPublish = timeToPublish;
        this.timeToDelete = timeToDelete;
        this.productName = productName;
        this.maxPublishers = maxPublishers;
        this.offerId = id;
        this.currentPublisherNumber = 0;
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

    public String getTimeToPublishAsString() {
        String res = "";

        if (timeToDelete != null) {
            res = dateFormat.format(timeToPublish);
        }

        return res;
    }

    public void setTimeToPublish(Date timeToPublish) {
        this.timeToPublish = timeToPublish;
    }

    public Date getTimeToDelete() {
        return timeToDelete;
    }

    public String getTimeToDeleteAsString() {
        String res = "";

            if (timeToDelete != null) {
                res = dateFormat.format(timeToDelete);
        }

        return res;
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

    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    public int getCurrentPublisherNumber() {
        return currentPublisherNumber;
    }

    public void setCurrentPublisherNumber(int currentPublisherNumber) {
        this.currentPublisherNumber = currentPublisherNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("product name: ")
                .append(productName + " \n")
                .append("points: ")
                .append(points + " \n")
                .append("max publishers: ")
                .append(maxPublishers + " \n")
                .append("current publishers: ")
                .append(currentPublisherNumber + " \n")
                .append("max publishers: ")
                .append(maxPublishers + " \n")
                .append("max publishers: ")
                .append(maxPublishers + " \n");
        return sb.toString();
    }
}
