package idstay.domain.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data @ToString
public class RoomTypeProfile {
    @Column(nullable = true)
    private int maxAdult;
    @Column(nullable = true)
    private int maxChildren;
    @Column(nullable = true)
    private boolean extraBed;
    @Column(nullable = true)
    private long basePrice;
    @Column(nullable = true)
    private long extraPersionCharge;
    @Column(nullable = true)
    private long extraBedCharge;
    @Column(nullable = true)
    private int numberOfRooms;
}
