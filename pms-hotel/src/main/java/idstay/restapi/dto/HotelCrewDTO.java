package idstay.restapi.dto;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data @ToString
public class HotelCrewDTO {
    List<HotelCrewDTO.Crew> crews = new ArrayList<>();

    public HotelCrewDTO add(HotelCrewDTO.Crew crew) {
        crews.add(crew);
        return this;
    }

    @Data @ToString
    public static class Crew {
        private String crewCode;
        private String nickName;
        private String crewName;
    }
}
