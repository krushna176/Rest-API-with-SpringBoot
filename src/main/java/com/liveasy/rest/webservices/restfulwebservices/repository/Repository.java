package com.liveasy.rest.webservices.restfulwebservices.repository;

import com.liveasy.rest.webservices.restfulwebservices.entities.Load;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Repository extends JpaRepository<Load,Integer> {


    Optional<Load>findByShipperId(String ShipperId);

}
