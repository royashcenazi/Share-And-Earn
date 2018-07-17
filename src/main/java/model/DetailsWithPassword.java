package model;

public class DetailsWithPassword extends Details {
    private String password;

    public DetailsWithPassword(String email, String phoneNumber, String address, String password) {
       super(email, phoneNumber, address);
        this.password = password;
    }
}
