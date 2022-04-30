package com.controller;

import com.entity.Ville;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.model.VilleModelAdd;
import com.model.VilleModelModifier;
import com.service.VilleService;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/ville")
public class VilleController {

	@Autowired
	VilleService villeService;

	private static final Gson gson = new Gson();


	// fonction pour récupérer le contenu de la BDD
	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getAll() throws JsonProcessingException {

		//gson.toJson(villeService.getAll())
		ObjectMapper mapper = new ObjectMapper();

		return gson.toJson(villeService.getAll());
	}

	@GetMapping("/{code}/code")
	@CrossOrigin(origins = "http://localhost:8080")
		public String getByCode(@PathVariable("code") String code ) {
			System.out.println(code);
			return gson.toJson(villeService.getByCode(code));
		}

	@GetMapping("/{id}")
	@CrossOrigin(origins = "http://localhost:8080")
	public String getById(@PathVariable("id") String id ) {

		return gson.toJson(villeService.getById(id));
	}

	@GetMapping("/{nom}/nom")
	@CrossOrigin(origins = "http://localhost:8080")
	public String getByNom(@PathVariable("nom") String nom ) {
		return gson.toJson(villeService.getByNom(nom));
	}


	@CrossOrigin(origins = "http://localhost:8080")
	@PostMapping
	public ResponseEntity<Ville> add(@RequestBody VilleModelAdd ville) throws SQLException {
		return ResponseEntity.ok(villeService.add(ville));

	}
	@CrossOrigin(origins = "http://localhost:8080")
	@PutMapping
	public ResponseEntity<Ville> replace(@RequestBody VilleModelModifier ville) throws  ObjectNotFoundException {

		return ResponseEntity.ok(villeService.replace(ville));

	}

	@CrossOrigin(origins = "http://localhost:8080")
	@DeleteMapping
	public void delete(@RequestBody String id) throws  ObjectNotFoundException {

		villeService.delete(id);

	}

	@CrossOrigin(origins = "http://localhost:8080")
	@DeleteMapping("/{id}")
	public void deletePath(@PathVariable("id") String id) throws  ObjectNotFoundException {

		villeService.delete(id);

	}

	



}