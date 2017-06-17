package idstay.domain.model;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Embeddable
public class PermissionGroup {

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "CREW_PERMISSIONS", joinColumns = @JoinColumn(name = "CREW_ID"))
    @Enumerated(EnumType.STRING)
    @Fetch(FetchMode.SUBSELECT)
    private List<Permission> permissionList = new ArrayList<>();

    public static PermissionGroup newInstance() {
        return new PermissionGroup();
    }

    public PermissionGroup permission(final Permission permission) {
        if (!permissionList.contains(permission))
            permissionList.add(permission);

        return this;
    }

    public List<Permission> getPermissionList() {
        return permissionList;
    }

    @Override
    public String toString() {
        return "PermissionGroup{" +
                "permissionList=" + permissionList +
                '}';
    }

    PermissionGroup(){
        //Needed by Jpa
    }
}
