package io.idstay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class PmsConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(PmsConfigApplication.class, args);
	}
}
