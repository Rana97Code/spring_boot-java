package com.vat.bmitvat.entity.test;

public class PersonAddressDto {
    private Long personId;
    private String name;
    private String email;
    private String street;
    private String city;

    public PersonAddressDto() {
    }

    public PersonAddressDto(Long personId, String name, String email, String street, String city) {
        this.personId = personId;
        this.name = name;
        this.email = email;
        this.street = street;
        this.city = city;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "PersonAddressDto{" +
                "personId=" + personId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
