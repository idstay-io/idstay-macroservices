package idstay;

import idstay.domain.model.RoomType;
import idstay.domain.model.RoomTypeCode;
import idstay.infrastructure.persistance.RoomRepository;
import idstay.infrastructure.persistance.RoomTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableCaching
public class PmsHotelApplication {

	private static final Logger log = LoggerFactory.getLogger(PmsHotelApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PmsHotelApplication.class, args);
	}

	@Autowired
    RoomRepository roomRepository;

	@Autowired
    RoomTypeRepository roomTypeRepository;

	@Bean
	public CommandLineRunner demo() {
		return (args) -> {

		};
	}

    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        List<Cache> caches = new ArrayList<Cache>();
        caches.add(new ConcurrentMapCache("rooms"));
        caches.add(new ConcurrentMapCache("roomTypes"));
        caches.add(new ConcurrentMapCache("crews"));
        cacheManager.setCaches(caches);
        return cacheManager;
    }
}




