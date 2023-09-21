package com.amdocs.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amdocs.entity.TruckEntity;

public interface TruckRepository extends JpaRepository<TruckEntity, Integer> {
	
}
