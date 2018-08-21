package model;

import java.security.PrivateKey;
import java.util.Date;

public class Share {

    private int amount;
    private String companyId;
    private Date dueDate;
    private Date readyToUseDate;
    private User publisher;
    private Offer offer;
    private String postId;

    public Share() {}

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getReadyToUseDate() {
        return readyToUseDate;
    }

    public void setReadyToUseDate(Date readyToUseDate) {
        this.readyToUseDate = readyToUseDate;
    }

    public User getPublisher() {
        return publisher;
    }

    public void setPublisher(User publisher) {
        this.publisher = publisher;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }
}
