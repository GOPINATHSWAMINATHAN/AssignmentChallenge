package com.teluschallenge.mapping.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

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

import com.teluschallenge.mapping.exceptions.ResourceNotFoundException;
import com.teluschallenge.mapping.model.Assignment;
import com.teluschallenge.mapping.model.Technician;
import com.teluschallenge.mapping.repository.AssignmentRepository;
import com.teluschallenge.mapping.repository.TechnicianRepository;

@RestController
@RequestMapping(value = "/api/v1")
public class TechnicianController {
	
	@Autowired
    private TechnicianRepository technicianRepository;
	
	@Autowired
    private AssignmentRepository assignmentRepository;

	/* Technician APIs */
	
	@GetMapping("/technicians")
    public List < Technician > getTechnicians() {
        return technicianRepository.findAll();
    }
	
	@GetMapping("/technicians/{id}")
    public ResponseEntity < Technician > getTechnicianById(
        @PathVariable(value = "id") Long technicianId) throws ResourceNotFoundException {
		Technician technician = technicianRepository.findById(technicianId)
            .orElseThrow(() -> new ResourceNotFoundException("Technician not found :: " + technicianId));
        return ResponseEntity.ok().body(technician);
    }
	
	@PostMapping("/technicians")
    public Technician createTechnician(@Valid @RequestBody Technician technician) {
        return technicianRepository.save(technician);
    }
	
	@DeleteMapping("/technicians/{id}")
    public Map < String, Boolean > deleteTechnician(
        @PathVariable(value = "id") Long technicianId) throws ResourceNotFoundException {
		Technician technician = technicianRepository.findById(technicianId)
            .orElseThrow(() -> new ResourceNotFoundException("Technician not found :: " + technicianId));

        technicianRepository.delete(technician);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
	
	@PutMapping("/technicians/{id}")
    public ResponseEntity<Technician> updateTechnician(
    @PathVariable(value = "id") Long technicianId,
    @Valid @RequestBody Technician technician) throws ResourceNotFoundException {
         Technician tech = technicianRepository.findById(technicianId)
          .orElseThrow(() -> new ResourceNotFoundException("Technician not found on :: "+ technicianId));
  
         
        tech.setId(technician.getId());
        tech.setFirstName(technician.getFirstName());
        tech.setLastName(technician.getLastName());
        tech.setEmail(technician.getEmail());
        final Technician updateTechnician = technicianRepository.save(tech);
        return ResponseEntity.ok(updateTechnician);
   }

}
