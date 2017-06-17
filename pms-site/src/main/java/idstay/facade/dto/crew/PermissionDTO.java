package idstay.facade.dto.crew;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by min on 4/30/17.
 */
public class PermissionDTO {
    private List<String> permissions = new ArrayList<>();

    public PermissionDTO add(String permission) {
        this.permissions.add(permission);
        return this;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    @Override
    public String toString() {
        return "PermissionDTO{" +
                "permissions=" + permissions +
                '}';
    }
}
