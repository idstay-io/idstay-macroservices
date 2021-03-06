package io.idstay.prs.domain;

import javax.persistence.*;

@Entity
public class RoomType {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="room_type_id")
    private long id;
    private String roomTypeName;
    private int sortId = 0;

    @ManyToOne
    @JoinColumn(name="hotel_id", nullable = false)
    private Hotel hotel;

    protected RoomType() {}
    public RoomType(final long id) {
        this.id = id;
    }
    public RoomType(String roomTypeName, int sortId, Hotel hotel) {
        this.roomTypeName = roomTypeName;
        this.sortId = sortId;
        this.hotel = hotel;
    }

    public long getId() {
        return id;
    }

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public int getSortId() {
        return sortId;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof RoomType)) {
            return false;
        }

        return (id == ((RoomType)object).id) ? true : false;
    }

    public int hashCode() {
        return (int) id;
    }

}
