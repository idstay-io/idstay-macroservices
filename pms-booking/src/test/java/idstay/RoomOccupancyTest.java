package idstay;

import idstay.domain.model.RoomOccupancy;
import idstay.infrastructure.persistance.RoomOccupancyJpaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RoomOccupancyTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private RoomOccupancyJpaRepository repository;

    @Test
    public void fooTest() {

        this.entityManager.persist(new RoomOccupancy(1L, 1L, "20160107", "Checkin"));

        List<RoomOccupancy> roomOccupancyList = repository.findByDatesBetween(1L, 1L, "20160107", "20170109");

        System.out.println(roomOccupancyList);
    }

}
