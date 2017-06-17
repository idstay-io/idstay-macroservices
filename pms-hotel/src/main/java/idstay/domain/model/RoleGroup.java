package idstay.domain.model;

import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Embeddable
@ToString
public class RoleGroup {
    @ElementCollection
    @CollectionTable(name = "CREW_ROLES", joinColumns = @JoinColumn(name = "CREW_ID"))
    @Enumerated(EnumType.STRING)
    private List<Role> roles = new ArrayList<>();

    public RoleGroup role(final Role role) {
        if (!roles.contains(role))
            roles.add(role);
        return this;
    }


    RoleGroup(){
        //Needed by Jpa
    }
}
