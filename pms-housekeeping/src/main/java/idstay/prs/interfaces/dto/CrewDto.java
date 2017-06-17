package io.idstay.prs.interfaces.dto;

import io.idstay.prs.domain.Crew;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class CrewDto {
    private long id;
    private String crewName;
    private Locale locale;

    public CrewDto(final String crewName) {
        this.crewName = crewName;
    }

    public CrewDto(final long id, final String crewName, final Locale locale) {
        this.id = id;
        this.crewName = crewName;
        this.locale = locale;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCrewName() {
        return crewName;
    }

    public void setCrewName(String crewName) {
        this.crewName = crewName;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public static List<CrewDto> dtoList(List<Crew> iterable) {
        List<CrewDto> crews = new ArrayList<CrewDto>();

        for(Crew crew : iterable) {
            crews.add(CrewDto.dto(crew));
        }
        return crews;
    }

    public static CrewDto dto(Crew crew) {
        return new CrewDto(crew.getId(), crew.getCrewName(), crew.getLocale());
    }


}

