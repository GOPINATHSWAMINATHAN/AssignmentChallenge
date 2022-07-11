package com.teluschallenge.mapping.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teluschallenge.mapping.exceptions.ResourceNotFoundException;
import com.teluschallenge.mapping.model.Assignment;
import com.teluschallenge.mapping.repository.AssignmentRepository;


@RestController
@RequestMapping(value = "/api/v1")
public class AssignmentController {
	@Autowired
	private AssignmentRepository assignmentRepository;


	@GetMapping("/assignments")
	public List < Assignment > getAssignments() {
		return assignmentRepository.findAll();
	}

	@GetMapping("/assignments/{id}")
	public ResponseEntity <Assignment> getAssignmentById(
			@PathVariable(value = "id") Long assignmentId) throws ResourceNotFoundException {
		Assignment assignment = assignmentRepository.findById(assignmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Assignment not found :: " + assignmentId));
		return ResponseEntity.ok().body(assignment);
	}

	@PostMapping("/assignments")
	public Assignment createAssignment(@Valid @RequestBody Assignment assignment) {
		return assignmentRepository.save(assignment);
	}

	@DeleteMapping("/assignments/{id}")
	public Map < String, Boolean > deleteAssignment(
			@PathVariable(value = "id") Long assignmentId) throws ResourceNotFoundException {
		Assignment assignment = assignmentRepository.findById(assignmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Technician not found :: " + assignmentId));

		assignmentRepository.delete(assignment);
		Map < String, Boolean > response = new HashMap < > ();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	@PutMapping("/assignments/{id}")
    public ResponseEntity<Assignment> updateAssignment(
    @PathVariable(value = "id") Long assignmentId,
    @Valid @RequestBody Assignment assignment) throws ResourceNotFoundException {
         Assignment assign = assignmentRepository.findById(assignmentId)
          .orElseThrow(() -> new ResourceNotFoundException("Assignment not found on :: "+ assignmentId));
        assign.setId(assignment.getId());
        assign.setTechnicianId(assignment.getTechnicianId());
        assign.setStartTime(assignment.getStartTime());
        assign.setEndTime(assignment.getEndTime());
        final Assignment updateAssignment = assignmentRepository.save(assign);
        return ResponseEntity.ok(updateAssignment);
   }
	

}
