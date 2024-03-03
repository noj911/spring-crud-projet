package com.noj.etudiant.controller;

import com.noj.etudiant.dto.EtudiantDto;
import com.noj.etudiant.service.EtudiantServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class  EtudiantController {

	private final EtudiantServiceImpl etudiantService;

	public EtudiantController(EtudiantServiceImpl etudiantService    ) {
		this.etudiantService = etudiantService;
	}

	@GetMapping("/etudiantList")
	public List<EtudiantDto> getAllStudents() {
        return etudiantService.getAllStudents();
	}

	// Afficher un Batiment par ID
	@GetMapping("/{id}")
	public EtudiantDto getStudentsById(@PathVariable Long id) {
        return etudiantService.getStudentsById(id);
	}

	@PostMapping("/createStudent")
	public EtudiantDto createStudents(@RequestBody EtudiantDto studentdto) {
		return  etudiantService.createStudents(studentdto);
	}


	@DeleteMapping("/delete/{id}")
	public void  deleteStudent(@PathVariable Long id) {etudiantService.deleteStudents(id);}



}
