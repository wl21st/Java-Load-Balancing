package main;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class BackSideApplication {

	private static Logger log = LoggerFactory.getLogger(BackSideApplication.class);

	@Autowired
	Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(BackSideApplication.class, args);
	}

	@RequestMapping(value = "/")
	public String get() {
		log.info("Ribbon verificando...");
		return null;
	}

	@RequestMapping(value = "/host")
	public String host() {
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();
			StringBuilder result = new StringBuilder();
			result.append("<b>IP Address:</b>").append(inetAddress.getHostAddress()).append("<br>");
			result.append("<b>Host Name:</b>").append(inetAddress.getHostName()).append("<br>");
			result.append("<b>Port:</b> ").append(environment.getProperty("server.port")).append("<br>");

			result.append("<b>Properties:</b>");
			result.append("<ul>");
			for (Object propertyKeyName : System.getProperties().keySet()) {
				result.append("<li>");
				result.append(propertyKeyName).append(": ").append(System.getProperty(propertyKeyName.toString()));
				result.append("</li>");
			}
			result.append("</ul>");

			return result.toString();
		} catch (UnknownHostException e) {
			return e.toString();
		}
	}

}
