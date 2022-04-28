package com.dao;

import com.entity.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;



@Repository
public interface VilleDao extends JpaRepository<Ville, String>, JpaSpecificationExecutor<Ville> {

   Ville findByCodeCommuneINSEE(String codeCommuneINSEE);


}
