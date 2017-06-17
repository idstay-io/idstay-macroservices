package idstay.web;


import idstay.facade.dto.crew.CrewDTO;
import org.slf4j.*;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.client.RestTemplate;


import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class CrewController {
    private static final Logger log = LoggerFactory.getLogger(CrewController.class);

    @GetMapping("/crews")
    public String CrewRead(Model model) {

//        List<CrewDTO> crews = new ArrayList<>();
 //       crews.add(new CrewDTO(1L, "@ally", "ally", "ally@jkglobe.com", true));
//        crews.add(new CrewDTO(2L, "@giny", "giny", "biz@jkglobe.com", true));
//        crews.add(new CrewDTO(3L, "@may", "may", "may@jkglobe.com", true));
//        crews.add(new CrewDTO(4L, "@mike", "mike", "mike@jkglobe.com", true));

//        model.addAttribute("crews", crews);


        log.info("icall colled");
        return "crew/board";
    }

    @GetMapping("/crew/{crewId}")
    public String readCrew(@PathVariable Long crewId,
            Model model) {
        log.info("readCrew");

        URI uri = URI.create("http://localhost:8091/1/crews");

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<CrewDTO[]> response = restTemplate.getForEntity(uri, CrewDTO[].class);

        log.info(response.getHeaders().toString());
        CrewDTO[] crews = response.getBody();

        List<CrewDTO> crewDTOS = Arrays.asList(crews);

        log.info("..........." + crewDTOS.toString());


        List<CrewDTO> crewx = Arrays.asList(restTemplate.getForObject(uri, CrewDTO[].class));

       log.info(".....................");
       log.info(crews.toString());

        return "crew/anything";
    }

    @PostMapping("/crew/{crewID}")
    public String updteCrew(@PathVariable Long crewID,
                            @Validated CrewDTO crew,
                            BindingResult result,
                            Model model) {
        log.info("......." + crew.toString());

        return "redirect:/crews";
    }




}
