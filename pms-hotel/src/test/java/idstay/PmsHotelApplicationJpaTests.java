package idstay;

import idstay.domain.model.*;
import idstay.infrastructure.persistance.HotelRepository;
import idstay.infrastructure.persistance.RoomRepository;
import idstay.infrastructure.persistance.RoomTypeRepository;
import idstay.restapi.support.HotelPropertyDTOAssembler;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class PmsHotelApplicationJpaTests {
    HotelId makersId = HotelId.newId();

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private HotelRepository hotelRepository;


    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Before
    public void setUp() {
        persistHotelProperty(new Hotel(makersId, "MAKES HOTEL"));

        RoomTypeCode mdCode = RoomTypeCode.newCode();
        RoomType md = (RoomType)persistHotelProperty(new RoomType(mdCode, makersId,"MODERN DOUBLE").acronym("MD"));


        RoomTypeCode sdCode = RoomTypeCode.newCode();
        RoomType sd = (RoomType)persistHotelProperty(new RoomType(sdCode, makersId,"SEMI DOUBLE").acronym("SD"));

        persistHotelProperty(new Room(RoomCode.newCode(), "301", makersId,  md, 3));
        persistHotelProperty(new Room(RoomCode.newCode(), "401", makersId,  md, 4));
        persistHotelProperty(new Room(RoomCode.newCode(), "501", makersId,  md, 5));
        persistHotelProperty(new Room(RoomCode.newCode(), "601", makersId,  md, 6));
        persistHotelProperty(new Room(RoomCode.newCode(), "701", makersId,  md, 7));

        persistHotelProperty(new Room(RoomCode.newCode(), "203", makersId,  sd, 2));
        persistHotelProperty(new Room(RoomCode.newCode(), "303", makersId,  sd, 3));
        persistHotelProperty(new Room(RoomCode.newCode(), "403", makersId,  sd, 4));
        persistHotelProperty(new Room(RoomCode.newCode(), "503", makersId,  sd, 5));
        persistHotelProperty(new Room(RoomCode.newCode(), "603", makersId,  sd, 6));
    }

    @Test
    public void roomTypeBuildTest() {
        assertThat(roomRepository.findByHotelId(makersId).size(), is(10));
        assertThat(roomTypeRepository.findByHotelId(makersId).size(), is(2));
    }

    @Test
    public void dtoTest() {
        HotelPropertyDTOAssembler assembler = new HotelPropertyDTOAssembler();
        assembler.setRooms(roomRepository.findByHotelId(makersId));
        System.out.println(assembler.getDto());
    }

    private Object persistHotelProperty(final Object object) {
        return this.entityManager.persist(object);
    }


}
