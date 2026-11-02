package hh.backend.boulderbuddy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class BoudlerBuddyApplication {

	private static final Logger log = LoggerFactory.getLogger(BoudlerBuddyApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BoudlerBuddyApplication.class, args);
	}

}
