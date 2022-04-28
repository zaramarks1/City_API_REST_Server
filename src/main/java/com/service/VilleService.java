package com.service;

import com.dao.VilleDao;
import com.entity.Ville;
import com.model.VilleModel;

import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLDataException;
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

    public Ville add(VilleModel villeModel) throws SQLException{
        if(!villeDao.existsById(villeModel.getCodeCommuneINSEE())){
            return this.villeDao.save(villeModel.villeModelToVille());
        }
        throw new SQLException("Ville existe deja ");
    }

    public Ville replace(VilleModel villeModel) throws ObjectNotFoundException {

        if(!villeDao.existsById(villeModel.getCodeCommuneINSEE())){
            return  this.villeDao.save(villeModel.villeModelToVille());
        }
        throw new ObjectNotFoundException("Ville n'existe pas ");


    }
}
