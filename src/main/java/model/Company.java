package model;

import DataBase.AppUser;

import java.util.List;

public class Company {
    private int id;
    private String name;
    private String facebookId;
    private List<Offer> offers;
    private List<AppUser> Users;
    private DetailsWithPassword details;

    public Company() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    public List<AppUser> getUsers() {
        return Users;
    }

    public void setUsers(List<AppUser> users) {
        Users = users;
    }

    public DetailsWithPassword getDetails() {
        return details;
    }

    public void setDetails(DetailsWithPassword details) {
        this.details = details;
    }

}
