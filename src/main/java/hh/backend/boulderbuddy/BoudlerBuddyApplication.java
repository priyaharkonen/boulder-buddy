package hh.backend.boulderbuddy;

import java.time.LocalDate;
import java.time.LocalTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.backend.boulderbuddy.domain.AppUser;
import hh.backend.boulderbuddy.domain.AppUserRepository;
import hh.backend.boulderbuddy.domain.Log;
import hh.backend.boulderbuddy.domain.LogRepository;
import hh.backend.boulderbuddy.domain.Gym;
import hh.backend.boulderbuddy.domain.GymRepository;
import hh.backend.boulderbuddy.domain.Boulder;
import hh.backend.boulderbuddy.domain.BoulderRepository;
import hh.backend.boulderbuddy.domain.Session;
import hh.backend.boulderbuddy.domain.SessionRepository;


@SpringBootApplication
public class BoudlerBuddyApplication {

	private static final Logger log = LoggerFactory.getLogger(BoudlerBuddyApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BoudlerBuddyApplication.class, args);
	}

	/* Demo data for testing */
	@Bean
	public CommandLineRunner BoulderBuddyDemoData(GymRepository gRepository, BoulderRepository bRepository,
												  SessionRepository sRepository, LogRepository eRepository,
												  AppUserRepository aRepository) {
		return (args) -> {
			log.info("save demo data");
			/* Gyms */
			Gym salmis = gRepository.save(
				new Gym("KiipeilyAreena Salmisaari"));
			Gym redi = gRepository.save(
				new Gym("KiipeilyAreena Kalasatama"));

			/* Boulders */
			Boulder boulder1 = bRepository.save(
				new Boulder("Blue", "Slab", "Grimps and pockets", "6C", "Current", salmis));
			
			Boulder boulder2 = bRepository.save(
				new Boulder("White", "Slab", "Grimps", "6C", "Current", redi));

			/* Sessions */
			Session session1 = sRepository.save(
					new Session(
					"Demo sessio 1", 
					LocalDate.of(2026, 10, 29), 
					LocalTime.of(18, 5), 
					LocalTime.of(1, 47), 
					salmis));
			
			Session session2 = sRepository.save(
				new Session(
					"Demo sessio 2", 
					LocalDate.of(2026, 11, 1), 
					LocalTime.of(17, 15), 
					LocalTime.of(1, 40), 
					redi));
			
			/* Logs */
			eRepository.save( new Log(2, 4, "Sent", "Moderate", boulder1, session1));
			eRepository.save( new Log(2, 8, "Project", "Hard", boulder2, session2));

			/* Users */
			AppUser	demoUser1 = 
				new AppUser(
					"admindemo", 
					"$2a$12$p2XeAKK0dm.puExf3bhzJOE9jDdjS0DgWPLKTAmcFNXKX8TXGYl/K", /* demoadmin */
					"admin.demo@boulderbuddy.com", 
					"ADMIN");
			
			AppUser demoUser2 = 
				new AppUser(
					"userdemo", 
					"$2a$12$DusC49YYlYkgmBKRirA.UO7.vpYVndpF4iaLTpMQKJZpQV4g.SJ5O", /* demouser */
					"user.demo@boulderbuddy.com", 
					"USER");
				
			aRepository.save(demoUser1);
			aRepository.save(demoUser2);

		};
	}

}
