package idstay.domain.model;



import idstay.domain.support.IDGenerator;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@ToString @EqualsAndHashCode
public class RoomTypeCode implements Serializable {
    @Column(name="ROOM_TYPE_CODE")
    private String code;

    public static RoomTypeCode newCode() {
        return new RoomTypeCode(IDGenerator.getIdString());
    }
    public static RoomTypeCode of(final String code) {
        return new RoomTypeCode(code);
    }

    private RoomTypeCode(final String code) {
        this.code = code;
    }

    public String codeString() {
        return code;
    }

    RoomTypeCode() {}
}