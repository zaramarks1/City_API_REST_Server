package com.dao;

import com.entity.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface VilleDao extends JpaRepository<Ville, String>, JpaSpecificationExecutor<Ville> {

   Ville findByCodeCommuneINSEE(String codeCommuneINSEE);

   Ville findByNomCommune(String nomCommune);

   Ville findVilleById(Integer id);

   boolean existsVilleById(Integer id);

   boolean existsByCodeCommuneINSEE(String codeCommuneINSEE);

   @Query(value = "select * from ville_france  where :condition like :rep" , nativeQuery = true)
    List<Ville> searchMethod(@Param("condition") String condition, @Param("rep")String rep);


   List<Ville> findByCodePostal(String response);
}
