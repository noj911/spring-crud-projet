package com.noj.etudiant.service;

import com.noj.etudiant.dto.EtudiantDto;

import java.util.List;

public interface IEtudiant {
    List<EtudiantDto> getAllStudents();

    EtudiantDto getStudentsById(Long id);

    EtudiantDto createStudents(EtudiantDto studentdto);

    EtudiantDto updateStudents(Long id, EtudiantDto etudiantDto);

    void deleteStudents(Long id);
}
