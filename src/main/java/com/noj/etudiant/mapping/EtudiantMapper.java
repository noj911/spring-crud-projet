package com.noj.etudiant.mapping;

import com.noj.etudiant.dto.EtudiantDto;
import com.noj.etudiant.entity.Etudiant;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class EtudiantMapper {
    public EtudiantDto fromEtudiant(Etudiant etudiant){
        EtudiantDto etudiantDto= new EtudiantDto();
        BeanUtils.copyProperties(etudiant,etudiantDto);
        return etudiantDto;
    }
    public Etudiant fromEtudiantDTO(EtudiantDto etudiantDto){
        Etudiant etudiant= new Etudiant();
        BeanUtils.copyProperties(etudiantDto,etudiant);
        return etudiant;
    }
}
