package idstay.domain.model;

import idstay.domain.model.CrewCode;
import idstay.domain.model.HotelId;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="CREW")
@ToString @Getter
public class Crew {
    @Id
    private CrewCode code;

    private HotelId hotelId;

    private String crewName;

    private String email;

    private String nickName;

    private String language;

    private boolean active = true;

    public Crew(final CrewCode code, final String crewName, final HotelId hotelId) {
        this.code = code;
        this.crewName = crewName;
        this.hotelId = hotelId;
    }
    Crew() {}
}
