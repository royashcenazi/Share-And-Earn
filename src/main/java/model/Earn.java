package model;

import java.util.Date;
import java.util.UUID;

public class Earn {
    private int amount;
    private String companyId;
    private Date dueDate;
    private Date readyToUseDate;

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
}
