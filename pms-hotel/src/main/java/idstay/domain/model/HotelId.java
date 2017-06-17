package idstay.domain.model;



import idstay.domain.support.IDGenerator;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@ToString @EqualsAndHashCode
public class HotelId implements Serializable {
    @Column(name="HOTEL_ID")
    private String id;

    public static HotelId newId() {
        return new HotelId(IDGenerator.getIdString2());
    }
    public static HotelId of(final String id) {
        return new HotelId(id);
    }

    private HotelId(final String id) {
        this.id = id;
    }

    public String idString() {
        return id;
    }

    HotelId() {}
}