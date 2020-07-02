package main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@SpringBootApplication
public class BackSideApplication {

	private static Logger log = LoggerFactory.getLogger(BackSideApplication.class);

	@Autowired
	Environment environment;

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Autowired
	private RestTemplate restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(BackSideApplication.class, args);
	}

	@RequestMapping(value = "/")
	public String get() {
		log.info("Ribbon verificando...");
		return "Olá!";
	}

	@RequestMapping(value = "/host")
	public String host() {
		return environment.getProperty("server.port");
	}

}
