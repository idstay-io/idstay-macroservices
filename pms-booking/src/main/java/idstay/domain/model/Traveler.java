package idstay.domain.model;

import javax.persistence.Embeddable;

@Embeddable
public class Traveler {
    private String email;
    private String firstName;
    private String lastName;
    private String fullName;
    private String phoneNumber;
    private Nationality nationality;


    public static Traveler of(final String lastName, final String firstName) {
        return new Traveler(lastName, firstName);
    }

    public static Traveler of(final String fullName) {
        return new Traveler(fullName);
    }

    private Traveler(final String lastName, final String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.fullName = lastName + " " + firstName;
    }

    private Traveler(final String fullName) {
        this.fullName = fullName;
    }

    public Traveler phoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Traveler email(final String email) {
        this.email = email;
        return this;
    }

    public Traveler nationality(final Nationality nationality) {
        this.nationality = nationality;
        return this;
    }
    private Traveler() {}

    @Override
    public String toString() {
        return "Traveler{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
