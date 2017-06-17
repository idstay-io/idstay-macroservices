package idstay.restapi.support;


import idstay.domain.model.Crew;
import idstay.domain.model.Room;
import idstay.restapi.dto.HotelCrewDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by min on 6/5/17.
 */
public class HotelCrewDTOAssembler {
    HotelCrewDTO dto = new HotelCrewDTO();

    public void setCrews(List<Crew> crews) {
        for(Crew crew : crews) {
            HotelCrewDTO.Crew newCrew = new HotelCrewDTO.Crew();
            newCrew.setCrewCode(crew.getCode().idString());
            newCrew.setNickName(crew.getNickName());
            newCrew.setCrewName(crew.getCrewName());

            dto.add(newCrew);
        }
    }

    public HotelCrewDTO getDto() {
        System.out.println(dto);
        return dto;
    }

}
