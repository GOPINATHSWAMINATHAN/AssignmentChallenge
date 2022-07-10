package com.teluschallenge.mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teluschallenge.mapping.model.Technician;

@Repository
public interface TechnicianRepository extends JpaRepository<Technician, Long>{

}
