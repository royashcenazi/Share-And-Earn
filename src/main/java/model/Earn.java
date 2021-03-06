package model;

import java.util.Date;

public class Earn {
    private int amount;
    private String companyId;
    private Date dueDate;
    private Date readyToUseDate;
    private int code;
    private String pictureUrl;
    private int offerId;

    private String productName;

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

    public Earn() {
    }

    public Date getReadyToUseDate() {
        return readyToUseDate;
    }

    public void setReadyToUseDate(Date readyToUseDate) {
        this.readyToUseDate = readyToUseDate;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Earn earn = (Earn) o;

        return code == earn.code;
    }

    @Override
    public int hashCode() {
        return code;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }
}
