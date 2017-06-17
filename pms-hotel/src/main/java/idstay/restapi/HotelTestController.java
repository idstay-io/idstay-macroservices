package idstay.restapi;

import idstay.restapi.dto.HotelCrewDTO;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HotelTestController {


    @GetMapping("/test")
    public List<Crew_> test() {

        List<Crew_> crews = new ArrayList<>();

        Crew_ crew = new Crew_("minsoo", "minsoo.kim@jkglobe.com");

        crew.getPermissions().add(new Crew_.Permission_("IS_OWNER"));
        crew.getPermissions().add(new Crew_.Permission_("IS_CREW"));


        Crew_ crew2 = new Crew_("minsoo2", "minsoo2.kim@jkglobe.com");

        crew2.getPermissions().add(new Crew_.Permission_("IS_OWNER"));

        crews.add(crew);
        crews.add(crew2);

        return crews;
    }

    @Data
    static class Crew_ {
        private String name;
        private String email;
        private List<Permission_> permissions = new ArrayList<>();

        public Crew_(String name, String email) {
            this.name = name;
            this.email = email;
        }


        @Data
        static class Permission_ {
            private String permission;

            public Permission_(String permission) {
                this.permission = permission;
            }
        }


    }




}
