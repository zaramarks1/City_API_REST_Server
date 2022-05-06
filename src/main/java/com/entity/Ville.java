package com.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Entity
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ville_france")
public class Ville implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "Code_commune_INSEE", nullable = false, unique = true)
    private String codeCommuneINSEE;

    @Column(name = "Nom_commune", nullable = false)
    private String nomCommune;

    @Column(name = "Code_postal", nullable = false)
    private String codePostal;

    @Column(name = "Libelle_acheminement", nullable = false)
    private String libelleAcheminement;

    @Column(name = "Ligne_5", nullable = false)
    private String ligne5;

    @Column(name = "Latitude", nullable = false)
    private String latitude;

    @Column(name = "Longitude", nullable = false)
    private String longitude;





}
