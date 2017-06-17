package idstay.facade.dto.crew;

public class CrewDTO {
    private Long crewId;

    private Long hotelId;
    private String nickName;

    private PermissionDTO permissions;
    private String crewName;
    private String email;

    public CrewDTO() {}
    public CrewDTO(Long crewId, Long hotelId, String nickName, String crewName, String email) {
        this.crewId = crewId;
        this.hotelId = hotelId;
        this.nickName = nickName;
        this.crewName = crewName;
        this.email = email;
    }

    public Long getCrewId() {
        return crewId;
    }

    public void setCrewId(Long crewId) {
        this.crewId = crewId;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public PermissionDTO getPermissions() {
        return permissions;
    }

    public void setPermissions(PermissionDTO permissions) {
        this.permissions = permissions;
    }

    public String getCrewName() {
        return crewName;
    }

    public void setCrewName(String crewName) {
        this.crewName = crewName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "CrewDTO{" +
                "crewId=" + crewId +
                ", hotelId=" + hotelId +
                ", nickName='" + nickName + '\'' +
                ", permissions=" + permissions +
                ", crewName='" + crewName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
