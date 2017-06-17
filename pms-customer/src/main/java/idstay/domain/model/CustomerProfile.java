package idstay.domain.model;


import lombok.Data;
import lombok.ToString;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
@Data @ToString
public class CustomerProfile {
    private String firstName;
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String phone;
    private String passport;
    @Enumerated(EnumType.STRING)
    private Nationality nationality;
}
