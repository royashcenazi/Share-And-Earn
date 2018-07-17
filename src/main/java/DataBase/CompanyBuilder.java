package DataBase;

import model.DetailsWithPassword;
import model.Offer;

import java.util.List;

public class CompanyBuilder {
    private int id;
    private String name;
    private List<Offer> offers;
    private List<AppUser> users;
    private DetailsWithPassword details;
    private String logoUrl;

    public CompanyBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public CompanyBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public CompanyBuilder setOffers(List<Offer> offers) {
        this.offers = offers;
        return this;
    }

    public CompanyBuilder setUsers(List<AppUser> users) {
        this.users = users;
        return this;
    }

    public CompanyBuilder setDetails(DetailsWithPassword details) {
        this.details = details;
        return this;
    }

    public CompanyBuilder setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
        return this;
    }

    public Company createCompany() {
        return new Company(id, name, offers, users, details, logoUrl);
    }
}