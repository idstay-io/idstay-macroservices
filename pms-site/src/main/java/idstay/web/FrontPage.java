package idstay.web;


import idstay.model.HotelProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Controller
@Slf4j
public class FrontPage {
    private static final String HOTEL_PROPERTY_ENTRY = "http://localhost:8091";

    @GetMapping("/")
    public String getFrontPage() {
        return "login";
    }
}
