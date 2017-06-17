package idstay.domain.model;





import idstay.domain.support.IDGenerator;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@ToString @EqualsAndHashCode
public class RoomCode implements Serializable {
    @Column(name="ROOM_CODE")
    private String code;

    public static RoomCode newCode() {
        return new RoomCode(IDGenerator.getIdString());
    }
    public static RoomCode of(final String code) {
        return new RoomCode(code);
    }

    private RoomCode(final String code) {
        this.code = code;
    }

    public String codeString() {
        return code;
    }

    RoomCode() {}
}