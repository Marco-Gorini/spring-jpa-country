package com.soprasteria.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.soprasteria.model.Region;

@Repository
public interface RegionRepository extends CrudRepository<Region,Integer>{
	
}
