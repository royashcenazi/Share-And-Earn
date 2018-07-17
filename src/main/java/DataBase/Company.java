package DataBase;

import DataBase.AppUser;
import model.DetailsWithPassword;
import model.Offer;

import java.util.List;

public class Company extends MongoElement {
    private int id;
    private String name;
    private List<Offer> offers;
    private List<AppUser> Users;
    private DetailsWithPassword details;
    private String logoUrl;

    public Company(String id, String name, String pass, String logo_url) {
        super();
    }

    public Company() {
        this.setCollectionName(MongoConstants.CompanyCollection);
        this.setInheritedClass(this.getClass());
        this.setKey(this.getName());
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getLogoUrl() {
        return logoUrl;
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
        this.setKey(name);
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
