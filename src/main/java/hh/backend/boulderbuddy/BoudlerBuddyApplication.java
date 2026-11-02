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
import hh.backend.boulderbuddy.domain.Execution;
import hh.backend.boulderbuddy.domain.ExecutionRepository;
import hh.backend.boulderbuddy.domain.Gym;
import hh.backend.boulderbuddy.domain.GymRepository;
import hh.backend.boulderbuddy.domain.Route;
import hh.backend.boulderbuddy.domain.RouteRepository;
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
	public CommandLineRunner BoulderBuddyDemoData(GymRepository gRepository, RouteRepository rRepository,
												  SessionRepository sRepository, ExecutionRepository eRepository,
												  AppUserRepository aRepository) {
		return (args) -> {
			log.info("save demo data");
			/* Gyms */
			Gym salmis = gRepository.save(
				new Gym("KiipeilyAreena Salmisaari"));
			Gym redi = gRepository.save(
				new Gym("KiipeilyAreena Kalasatama"));

			/* Routes */
			Route route1 = rRepository.save(
				new Route("Blue", "Slab", "6C", "Current", salmis));
			
			Route route2 = rRepository.save(
				new Route("White", "Slab", "6C", "Current", redi));

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
			
			/* Executions */
			eRepository.save( new Execution(2, 4, "Sent", "Moderate", route1, session1));
			eRepository.save( new Execution(2, 8, "Project", "Hard", route2, session2));

			/* Users */
			AppUser	demoUser1 = 
				new AppUser(
					"admin_demo", 
					"$2a$12$Gdi1Pb7ZXj3thY8M/asR8uFQsxzcc2gQRxl4LmK0k3BmVRU0prhIC", 
					"admin.demo@boulderbuddy.com", 
					"ADMIN");
			
			AppUser demoUser2 = 
				new AppUser(
					"user_demo", 
					"$2a$12$6zHmZ6WkTPcFI5TDtddzzOJpNuPhDxiyoQLOtqZdwR5aaiG/jhlda", 
					"user.demo@boulderbuddy.com", 
					"USER");
				
			aRepository.save(demoUser1);
			aRepository.save(demoUser2);

		};
	}

}
