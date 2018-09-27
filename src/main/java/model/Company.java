package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Company {

    private String name;
    private List<Offer> offers;
    private List<User> Users;
    private String logoUrl;
    private String email;
    private String phoneNumber;
    private String address;
    private String password;
    private List<Share> shares;
    private String about;

    public Company()  {
    }

    public Company(String name, String logoUrl, String email, String phoneNumber,
                   String address, String password, String about) {
        this.name = name;
        this.logoUrl = logoUrl;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.password = password;
        this.about = about;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    public List<User> getUsers() {
        return Users;
    }

    public void setUsers(List<User> users) {
        Users = users;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addOffer(Offer offer) {
        if (this.offers == null) {
            offers = new ArrayList<Offer>();
        }
        offers.add(offer);
    }

    public void addShare(Share share) {
        if (this.shares == null)
            this.shares = new ArrayList<Share>();
        this.shares.add(share);
    }

    public List<Share> getShares() {
        return shares;
    }

    public void setShares(List<Share> shares) {
        this.shares = shares;
    }

    public Offer getOfferById(int offerId) {
        Offer res = null;

        if(offers != null) {
            for (Offer offer : offers) {
                if (offer.getOfferId() == offerId)
                    res = offer;
            }
        }
        return res;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public void deleteOutDatedOffers() {
        if (offers != null) {
            Date now = new Date();
            List<Offer> toRemove =
                    offers.stream()
                            .filter(offer -> offer.getTimeToDelete().getTime() <= now.getTime())
                            .collect(Collectors.toList());
            offers.removeAll(toRemove);
        }
    }
}
