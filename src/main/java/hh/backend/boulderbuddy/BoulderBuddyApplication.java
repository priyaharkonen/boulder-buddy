package hh.backend.boulderbuddy;

import java.time.LocalDate;

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


@SpringBootApplication
public class BoulderBuddyApplication {

	private static final Logger log = LoggerFactory.getLogger(BoulderBuddyApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BoulderBuddyApplication.class, args);
	}

	/* Demo data for testing */
	@Bean
	public CommandLineRunner BoulderBuddyDemoData(GymRepository gRepository, BoulderRepository bRepository,
												  LogRepository lRepository, AppUserRepository aRepository) {
		return (args) -> {
			log.info("save demo data");
			/* Gyms */
			Gym salmis = gRepository.save(
				new Gym("KiipeilyAreena", "Salmisaari", "10-22", "10-20"));
			Gym redi = gRepository.save(
				new Gym("KiipeilyAreena", "Redi", "10-22", "10-20"));
				

			/* Boulders */
			Boulder boulder1 = bRepository.save(
				new Boulder("Blue", "6C", "Slab", "Crimps and pockets", "Available", salmis));
			
			Boulder boulder2 = bRepository.save(
				new Boulder("White", "6C", "Slab", "Crimps", "Available", redi));
			
			/* Users */
			AppUser	demoUser1 = 
				new AppUser(
					"bb-admin", 
					"$2a$12$p2XeAKK0dm.puExf3bhzJOE9jDdjS0DgWPLKTAmcFNXKX8TXGYl/K", /* demoadmin */
					"admin.demo@boulderbuddy.com", 
					"ADMIN");
			
			AppUser demoUser2 = 
				new AppUser(
					"bb-user", 
					"$2a$12$DusC49YYlYkgmBKRirA.UO7.vpYVndpF4iaLTpMQKJZpQV4g.SJ5O", /* demouser */
					"user.demo@boulderbuddy.com", 
					"USER");
			
			AppUser demoUser3 = 
				new AppUser(
					"priiuska", 
					"$2a$12$FCOhoMNffDEXD0b0L8Nf4eXxVyAsKcY5faV2qCAjECsEOqUhp3/o2", /* priya123 */
					"priya.harkonen@gmail.com", 
					"USER");
			
			aRepository.save(demoUser1);
			aRepository.save(demoUser2);
			aRepository.save(demoUser3);
			
			/* Logs */
			lRepository.save( new Log(LocalDate.of(2026, 10, 29), 3, "Sent", "Moderate", "Positiivinen yllätys kun sai sendattua session loppuun, kiva reitti",demoUser2, boulder1));
			lRepository.save(new Log(LocalDate.of(2026, 11, 01), 6, "Projecting", "Hard", "First move seems impossible", demoUser3, boulder2));


		};
	}

}
