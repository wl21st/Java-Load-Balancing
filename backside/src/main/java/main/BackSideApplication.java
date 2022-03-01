package main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@SpringBootApplication
public class BackSideApplication {

    private static Logger log = LoggerFactory.getLogger(BackSideApplication.class);

    @Autowired
    private Environment environment;

    private InetAddress inetAddress;
    private String hostName;
    private String hostAddress;

    public static void main(String[] args) {
        SpringApplication.run(BackSideApplication.class, args);
    }

    @PostConstruct
    private void init() {
        try {
            this.inetAddress = InetAddress.getLocalHost();

            this.hostName = inetAddress.getHostName();
            this.hostAddress = inetAddress.getHostAddress();
        } catch (UnknownHostException e) {
            log.warn("Cannot get the name of localhost!", e);
        }
    }

    @RequestMapping(value = "/")
    public String get() {
        return "netflex-ribbon-client";
    }

    @RequestMapping(value = "/host")
    public String host() {
        StringBuilder result = new StringBuilder();

        result.append("<b>IP Address:</b>").append(this.hostAddress).append("<br>");
        result.append("<b>Host Name:</b>").append(this.hostName).append("<br>");
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
    }

}
