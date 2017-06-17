package io.idstay.prs.domain;

import io.idstay.prs.domain.common.CleaningStatus;
import io.idstay.prs.domain.common.Remarks;
import io.idstay.prs.domain.common.ReservationStatus;
import io.idstay.prs.domain.common.RoomStatus;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Housekeeping {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="housekeeping_id")
    private long id;

    @ManyToOne
    @JoinColumn(name="room_id", nullable = false)
    private Room room;

    @ManyToOne
    @JoinColumn(name="room_type_id", nullable = false)
    private RoomType roomType;

    private long hotelId;

    @Column(name="reservation_status")
    @Enumerated(EnumType.STRING)
    private ReservationStatus reservationStatus;

    @Column(name="room_status")
    @Enumerated(EnumType.STRING)
    private RoomStatus roomStatus;

    @Column(name="cleaning_status")
    @Enumerated(EnumType.STRING)
    private CleaningStatus cleaningStatus;

    @ElementCollection(targetClass=Remarks.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name="housekeeping_remarks", joinColumns = @JoinColumn(name="remark_id"))
    @Column(name="remarks")
    @Fetch(FetchMode.SUBSELECT)
    Set<Remarks> remarks = new HashSet<Remarks>();

    private String memo = "";

    private int sortId = 0;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

    protected Housekeeping() {}
    public Housekeeping(final Room room) {
        this.room = room;
        this.roomType = room.getRoomType();
        this.hotelId = room.getRoomType().getId();
    }

    public Long getId() {
        return id;
    }

    public Room getRoom() {
        return room;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public long getHotelId() {
        return hotelId;
    }

    public Housekeeping reservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
        return this;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public Housekeeping roomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
        return this;
    }

    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public Housekeeping cleaningStatus(CleaningStatus cleaningStatus) {
        this.cleaningStatus = cleaningStatus;
        return this;
    }

    public CleaningStatus getCleaningStatus() {
        return cleaningStatus;
    }

    public Housekeeping remarks(Set<Remarks> remarks) {
        this.remarks = remarks;
        return this;
    }

    public Housekeeping remark(Remarks remark) {
        this.remarks.add(remark);
        return this;
    }

    public Set<Remarks> getRemarks() {
        return remarks;
    }

    public String getMemo() {
        return memo;
    }

    public Housekeeping memo(final String memo) {
        this.memo = memo;
        return this;
    }

    public int getSortId() {
        return sortId;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public Housekeeping lastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof Housekeeping)) {
            return false;
        }

        return (id == ((Housekeeping)object).id) ? true : false;
    }

    public int hashCode() {
        return (int) id;
    }
}
