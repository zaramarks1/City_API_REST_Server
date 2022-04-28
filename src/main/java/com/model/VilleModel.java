package com.model;

import com.entity.Ville;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VilleModel {


    private String codeCommuneINSEE;

    private String nomCommune;

    private String codePostal;

    private String libelleAcheminement;

    private String ligne5;

    private String latitude;

    private String longitude;

    public Ville villeModelToVille(){
        Ville ville = new Ville();
        ville.setCodeCommuneINSEE(this.codeCommuneINSEE);
        ville.setCodePostal( this.codePostal);
        ville.setLibelleAcheminement(this.libelleAcheminement);
        ville.setLigne5( this.ligne5 );
        ville.setLatitude(this.latitude);
        ville.setLongitude(this.longitude);
        ville.setNomCommune(this.nomCommune);

        return ville;
    }
}
