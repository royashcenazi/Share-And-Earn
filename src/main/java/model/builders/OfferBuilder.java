package model.builders;

import model.Offer;

import java.util.Date;

public class OfferBuilder {
    private int points;
    private String pictureURL;
    private Date timeToPublish;
    private Date timeToDelete;
    private String productName;
    private int maxPublishers;

    public OfferBuilder setPoints(int points) {
        this.points = points;
        return this;
    }

    public OfferBuilder setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
        return this;
    }

    public OfferBuilder setTimeToPublish(Date timeToPublish) {
        this.timeToPublish = timeToPublish;
        return this;
    }

    public OfferBuilder setTimeToDelete(Date timeToDelete) {
        this.timeToDelete = timeToDelete;
        return this;
    }

    public OfferBuilder setTimeToDelete(String productName) {
        this.productName = productName;
        return this;
    }

    public OfferBuilder setTimeToDelete(int maxPublishers) {
        this.maxPublishers = maxPublishers;
        return this;
    }

    public Offer createOffer() {
        return new Offer(points, pictureURL, timeToPublish, timeToDelete, productName, maxPublishers);
    }

    public OfferBuilder setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public OfferBuilder setMaxPublishers(int maxPublishers) {
        this.maxPublishers = maxPublishers;
        return this;
    }
}