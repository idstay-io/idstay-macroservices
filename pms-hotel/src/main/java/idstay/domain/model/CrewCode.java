package idstay.domain.model;



import idstay.domain.support.IDGenerator;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@ToString @EqualsAndHashCode
public class CrewCode implements Serializable {
    @Column(name="CREW_ID")
    private String code;

    private CrewCode(final String code) {
        this.code = code;
    }
    public static CrewCode of(String code) {
        return new CrewCode(code);
    }
    public static CrewCode gen() {
        return new CrewCode(IDGenerator.getIdString());
    }

    public String idString() {
        return code;
    }
    CrewCode() {}
}