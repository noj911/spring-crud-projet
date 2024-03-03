package com.noj.etudiant.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class EtudiantDto {
    private Long id;
    private String nom;
    private String prenom;
}
