package com.noj.etudiant.dao;

import com.noj.etudiant.entity.Etudiant;
import org.springframework.data.repository.CrudRepository;

public interface EtudiantRepository extends CrudRepository<Etudiant,Integer>{

	Etudiant findByEmail(String email);


}