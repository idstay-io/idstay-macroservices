package io.idstay.prs.domain;

import javax.persistence.*;

@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hotel_id")
    private long id;
    private String hotelName;

    protected Hotel() {
    }

    public Hotel(final long id) {
        this.id = id;
    }

    public Hotel(String hotelName) {
        this.hotelName = hotelName;
    }

    public long getId() {
        return id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof Hotel)) {
            return false;
        }

        return (id == ((Hotel) object).id) ? true : false;
    }

    public int hashCode() {
        return (int) id;
    }

}
