package idstay.web;

import idstay.facade.dto.crew.CrewDTO;
import lombok.Data;
import lombok.ToString;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class TestController {

    @RequestMapping("/test")
    public void makeTest() {
        URI uri = URI.create("http://localhost:8091/test");

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Crew_[]> response = restTemplate.getForEntity(uri, Crew_[].class);

        System.out.println(response.getStatusCode().toString());
        List<Crew_> crews = Arrays.asList(response.getBody());

        System.out.println("==================================");
        System.out.println(crews);

    }


    @Data @ToString
    static class Crew_ {
        private String name;
        private String email;
        private List<Permission_> permissions = new ArrayList<>();

        public Crew_() {}
        public Crew_(String name, String email) {
            this.name = name;
            this.email = email;
        }

        @Data @ToString
        static class Permission_ {
            private String permission;

            public Permission_() {}
            public Permission_(String permission) {
                this.permission = permission;
            }
        }
    }






}
