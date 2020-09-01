package br.com.fiap.sistema.drones.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.sistema.drones.model.DroneInfo;
import br.com.fiap.sistema.drones.service.DroneInfoService;

@RestController
public class DroneInfoController {

	@Autowired
	private DroneInfoService service;

	@GetMapping("/drone")
	public ResponseEntity<List<DroneInfo>> getAllDrones() {
		return new ResponseEntity<>(service.getAllDrones(), HttpStatus.OK);
	}

	@GetMapping("/drone/{id}")
	public ResponseEntity<DroneInfo> getById(@PathVariable String id) {
		return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
	}

}
