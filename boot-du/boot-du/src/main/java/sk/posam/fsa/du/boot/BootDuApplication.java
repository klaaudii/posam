package sk.posam.fsa.du.boot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sk.posam.fsa.du.boot.domain.LocationService;

import javax.sql.DataSource;

@SpringBootApplication
public class BootDuApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootDuApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(LocationService locationService, DataSource dataSource) {
		return (args) -> {
			System.out.println(locationService.customerLivesInCountry(10L, 46L));
		};
	}

}
