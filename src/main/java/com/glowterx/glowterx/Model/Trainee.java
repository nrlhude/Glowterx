package com.glowterx.glowterx.Model;

public class Trainee {
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String email;

    private String TraineeUsername;
    private String TraineePass;

    public Trainee() {
    }

    public Trainee(int id, String firstName, String lastName, String address, String city, String state, String zip,
            String phone, String email, String TraineeUsername, String TraineePass) {
        this.TraineeUsername = TraineeUsername;
        this.TraineePass = TraineePass;

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;

    }

    public String getTraineeUsername() {
        return TraineeUsername;
    }

    public void setTraineeUsername(String TraineeUsername) {
        this.TraineeUsername = TraineeUsername;
    }

    public String getTraineePass() {
        return TraineePass;
    }

    public void setTraineePass(String TraineePass) {
        this.TraineePass = TraineePass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}