package idstay;

import idstay.application.HotelPropertyService;
import idstay.domain.model.HotelId;
import idstay.infrastructure.persistance.HotelRepository;
import idstay.infrastructure.persistance.RoomRepository;
import idstay.infrastructure.persistance.RoomTypeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
public class Boo {

    @Autowired
    HotelPropertyService service;

    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    RoomTypeRepository roomTypeRepository;

    @Autowired
    RoomRepository roomRepository;

    @Before
    public void setUp() {

    }


    @Test
    public void getAllRoomInfo() {
        service.getAllProperties(HotelId.of("#123"));



    }

}
