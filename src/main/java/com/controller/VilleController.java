package com.controller;

import com.dao.VilleDao;
import com.entity.Ville;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.model.VilleModel;
import com.service.VilleService;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
		public ResponseEntity<Ville> getByCode(@PathVariable("code") String code ) {

			return ResponseEntity.ok(villeService.getByCode(code));
		}
	@CrossOrigin(origins = "http://localhost:8080")
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