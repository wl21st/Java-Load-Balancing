package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class BackSideApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackSideApplication.class, args);
	}

	@RequestMapping(value = "/")
	public String get() {
		return "Backside funcionando!";
	}

}
