package com.service;

import com.dao.VilleDao;
import com.entity.Ville;
import com.model.VilleModelAdd;
import com.model.VilleModelModifier;

import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;


@Service
public class VilleService {

    @Autowired
    private VilleDao villeDao;

    public List<Ville>  getAll(){
        return this.villeDao.findAll();
    }

    public Ville  getByCode(String code){

        return this.villeDao.findByCodeCommuneINSEE(code);
    }

    public Ville getById(String id){

        return this.villeDao.findVilleById(Integer.valueOf(id));
    }


    public Ville  getByNom(String nomCommune){

        return this.villeDao.findByNomCommune(nomCommune);
    }

    public Ville add(VilleModelAdd villeModel) throws SQLException{
        if(!villeDao.existsByCodeCommuneINSEE(villeModel.getCodeCommuneINSEE())){
            return this.villeDao.save(villeModel.villeModelToVilleAdd());
        }
        throw new SQLException("Ville existe deja ");
    }

    public Ville replace(VilleModelModifier villeModel) throws ObjectNotFoundException {

        if(villeDao.existsVilleById(villeModel.getId())){

            return  this.villeDao.save(villeModel.villeModelToVilleModifier());
        }
        throw new ObjectNotFoundException("Ville n'existe pas ");

    }

    public void delete(String id){

        Integer idVille = Integer.valueOf(id);
        if(villeDao.existsVilleById(idVille)){
            Ville ville = villeDao.findVilleById(idVille);
             this.villeDao.delete(ville);
        }
    }

    public  List<Ville> search(String condition, String response) throws ObjectNotFoundException {

        List<Ville> villes = this.villeDao.searchMethod(condition, response);

        return villes;

    }
}
