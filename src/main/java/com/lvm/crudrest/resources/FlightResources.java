package com.lvm.crudrest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lvm.crudrest.entity.Flights;
import com.lvm.crudrest.repositories.FlightRepository;

@RestController
@RequestMapping(value = "/flights")
public class FlightResources {

	@Autowired
	private FlightRepository repository;
	
	FlightResources(FlightRepository flightRepository){
		this.repository = flightRepository;
	}
	
	@GetMapping
	public List<Flights> findAll() {
		return repository.findAll();
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<Flights> findbyId(@PathVariable long id) {
		return repository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Flights addFlights(@RequestBody Flights flight) {
		return repository.save(flight);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Flights> updateFlights(@PathVariable("id") long id, @RequestBody Flights flight){
		return repository.findById(id)
				.map(record -> {
					record.setFlightCompany(flight.getFlightCompany());
					record.setAircraftModel(flight.getAircraftModel());
					record.setAircraftIdentificationCode(flight.getAircraftIdentificationCode());
					Flights addFlights = repository.save(record);
					return ResponseEntity.ok().body(addFlights);
				}).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> deleteFlights(@PathVariable Long id){
		return repository.findById(id)
				.map(record -> {
					repository.deleteById(id);
					return ResponseEntity.ok().build();
				}).orElse(ResponseEntity.notFound().build());
	}
}
