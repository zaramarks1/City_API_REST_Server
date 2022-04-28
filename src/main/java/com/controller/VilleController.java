package com.controller;

import com.dao.VilleDao;
import com.entity.Ville;
import com.model.VilleModel;
import com.service.VilleService;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/ville")
public class VilleController {

	@Autowired
	VilleService villeService;

	// fonction pour récupérer le contenu de la BDD
	@GetMapping("/all")
	public ResponseEntity<List<Ville>> getAll() {

		return ResponseEntity.ok(villeService.getAll());
	}

	@GetMapping("/{code}/code")
		public ResponseEntity<Ville> getByCode(@PathVariable("code") String code ) {

			return ResponseEntity.ok(villeService.getByCode(code));
		}

	@PostMapping
	public ResponseEntity<Ville> add(@RequestBody VilleModel ville) throws SQLException {
		System.out.println("entrou");
		return ResponseEntity.ok(villeService.add(ville));

	}

	@PutMapping
	public ResponseEntity<Ville> replace(@RequestBody VilleModel ville) throws  ObjectNotFoundException {

		return ResponseEntity.ok(villeService.replace(ville));

	}

	



}