package hh.backend.boulderbuddy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class BoulderbuddyApplication {

	private static final Logger log = LoggerFactory.getLogger(BoulderbuddyApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BoulderbuddyApplication.class, args);
	}

}
