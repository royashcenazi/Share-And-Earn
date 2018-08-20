package model.builders;

import model.Company;

public class CompanyBuilder {
    private String name;
    private String logoUrl;
    private String email;
    private String phoneNumber;
    private String address;
    private String password;

    public CompanyBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public CompanyBuilder setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
        return this;
    }

    public CompanyBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public CompanyBuilder setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public CompanyBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public CompanyBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public Company createCompany() {
        return new Company(name, logoUrl, email, phoneNumber, address, password);
    }
}