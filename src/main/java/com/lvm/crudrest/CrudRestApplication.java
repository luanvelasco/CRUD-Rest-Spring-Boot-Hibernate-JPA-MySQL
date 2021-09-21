package com.lvm.crudrest;

import java.util.stream.LongStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.lvm.crudrest.entity.Flights;
import com.lvm.crudrest.repositories.FlightRepository;

@SpringBootApplication
public class CrudRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudRestApplication.class, args);
	}
	
	@Bean
    CommandLineRunner init(FlightRepository repository) {
        return args -> {
            repository.deleteAll();
            LongStream.range(1, 11).mapToObj(i -> {
                        Flights flights = new Flights();
                        flights.setFlightCompany("Company " + i);
                        flights.setAircraftModel("Boing-" + i + "-737");
                        flights.setAircraftIdentificationCode("BRA-" + i);
                        return flights;
            	})
                    .map(v -> repository.save(v))
                    .forEach(System.out::println);
        };
    }
	
}
