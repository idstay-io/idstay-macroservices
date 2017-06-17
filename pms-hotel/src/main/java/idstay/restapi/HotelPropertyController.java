package idstay.restapi;


import idstay.application.HotelCrewService;
import idstay.application.HotelPropertyService;
import idstay.domain.model.*;
import idstay.infrastructure.persistance.HotelRepository;
import idstay.infrastructure.persistance.RoomRepository;
import idstay.infrastructure.persistance.RoomTypeRepository;
import idstay.restapi.dto.HotelCrewDTO;
import idstay.restapi.dto.HotelPropertyDTO;
import idstay.restapi.support.HotelCrewDTOAssembler;
import idstay.restapi.support.HotelPropertyDTOAssembler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
public class HotelPropertyController {

    private HotelPropertyService hotelPropertyService;
    private HotelCrewService hotelCrewService;


    @GetMapping("/{hotelId}/properties")
    public HotelPropertyDTO getHotelProperties(@PathVariable String hotelId) {


        HotelPropertyDTOAssembler assembler = new HotelPropertyDTOAssembler();
        assembler.setRooms(hotelPropertyService.getAllRooms(HotelId.of(hotelId)));
        assembler.setRoomTypes(hotelPropertyService.getAllRoomTypes(HotelId.of(hotelId)));

        return assembler.getDto();
    }

    @GetMapping("/{hotelId}/crews")
    public HotelCrewDTO getHotelCrews(@PathVariable String hotelId) {
        HotelCrewDTOAssembler assembler = new HotelCrewDTOAssembler();
        assembler.setCrews(hotelCrewService.getAllCrews(HotelId.of(hotelId)));

        return assembler.getDto();
    }

    @Autowired
    public void setHotelPropertyService(final HotelPropertyService hotelPropertyService) {
        this.hotelPropertyService = hotelPropertyService;
    }

    @Autowired
    public void setHotelCrewService(final HotelCrewService hotelCrewService) {
        this.hotelCrewService = hotelCrewService;
    }
}
