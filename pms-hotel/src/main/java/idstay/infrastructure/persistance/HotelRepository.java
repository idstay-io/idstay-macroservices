package idstay.infrastructure.persistance;

import idstay.domain.model.Hotel;
import idstay.domain.model.HotelId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by min on 6/5/17.
 */
public interface HotelRepository extends JpaRepository<Hotel, HotelId> {
}
