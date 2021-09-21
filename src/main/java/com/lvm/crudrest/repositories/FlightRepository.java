package com.lvm.crudrest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lvm.crudrest.entity.Flights;

public interface FlightRepository extends JpaRepository<Flights, Long>{

}
