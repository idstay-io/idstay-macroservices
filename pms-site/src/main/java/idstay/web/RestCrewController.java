package idstay.web;

import idstay.facade.dto.crew.CrewDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/crew")
public class RestCrewController {
    private static final Logger log = LoggerFactory.getLogger(RestCrewController.class);

    @PutMapping("{id}")
    public CrewDTO pubCrew(@PathVariable Integer id, @RequestBody CrewDTO crew) {
        log.info(".............................." + crew.toString());
        crew.setCrewId(1000L);

        return crew;
    }
}
