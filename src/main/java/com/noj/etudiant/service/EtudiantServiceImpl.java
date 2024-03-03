package com.noj.etudiant.service;

import com.noj.etudiant.dao.EtudiantRepository;
import com.noj.etudiant.dto.EtudiantDto;
import com.noj.etudiant.entity.Etudiant;
import com.noj.etudiant.mapping.EtudiantMapper;
import jakarta.persistence.Cacheable;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EtudiantServiceImpl implements IEtudiant {

        private  EtudiantRepository etudiantRepository;
        private EtudiantMapper etudiantMapper;

        public EtudiantServiceImpl(EtudiantRepository etudiantRepository, EtudiantMapper etudiantMapper) {
            this.etudiantRepository = etudiantRepository;
            this.etudiantMapper = etudiantMapper;
        }

        @Override
        @Transactional(readOnly = true)
        public List<EtudiantDto> getAllStudents() {
            List<Etudiant> etudiants = (List<Etudiant>) etudiantRepository.findAll();
            return etudiants.stream()
                    .map(etudiantMapper::fromEtudiant)
                    .collect(Collectors.toList());
        }

        @Override
        @Transactional(readOnly = true)
        public EtudiantDto getStudentsById(Long id) {
            Optional<Etudiant> etudiants = etudiantRepository.findById(Math.toIntExact(id));
            return etudiants.map(etudiantMapper::fromEtudiant).orElse(null);
        }

        @Override
        @Transactional
        public EtudiantDto createStudents(EtudiantDto etudiantDto) {
            Etudiant student = etudiantMapper.fromEtudiantDTO(etudiantDto);
            Etudiant savedStudent = etudiantRepository.save(student);
            return etudiantMapper.fromEtudiant(savedStudent);
        }


    @Override
        @Transactional
        public EtudiantDto updateStudents(Long id, EtudiantDto studentdto) {
            Optional<Etudiant> StudentOptional = etudiantRepository.findById(Math.toIntExact(id));
            if (StudentOptional.isPresent()) {
                Etudiant existingStudent = StudentOptional.get();
                // Update fields from DTO
                existingStudent.setNom(studentdto.getNom());
                existingStudent.setPrenom(studentdto.getPrenom());
                // Save and return updated Student
                Etudiant updatedEtudiant = etudiantRepository.save(existingStudent);
                return etudiantMapper.fromEtudiant(updatedEtudiant);
            } else {
                return null; // Student not found
            }
        }

        @Override
        @Transactional
        public void deleteStudents(Long id) {
            etudiantRepository.deleteById(Math.toIntExact(id));
        }

}
