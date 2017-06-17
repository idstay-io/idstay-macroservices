package idstay.application.support;

import idstay.application.HotelCrewService;
import idstay.domain.model.Crew;
import idstay.domain.model.HotelId;
import idstay.infrastructure.persistance.CrewRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class CrewServiceDefault implements HotelCrewService {
    private CrewRepository crewRepository;

    @Override
    @Cacheable("crews")
    public List<Crew> getAllCrews(HotelId hotelId) {
        log.info(hotelId.toString());
        System.out.println(crewRepository.findByHotelId(hotelId));
        return crewRepository.findByHotelId(hotelId);
    }

    @Autowired
    public void setCrewRepository(final CrewRepository crewRepository) {
        this.crewRepository = crewRepository;
    }
}
