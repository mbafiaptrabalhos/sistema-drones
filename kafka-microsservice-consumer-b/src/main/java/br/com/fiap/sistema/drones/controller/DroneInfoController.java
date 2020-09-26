package br.com.fiap.sistema.drones.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.sistema.drones.model.DroneInfo;
import br.com.fiap.sistema.drones.service.DroneInfoService;

@RestController
@RequestMapping("drones")
public class DroneInfoController {
    private final DroneInfoService service;

    public DroneInfoController(DroneInfoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<DroneInfo>> getAllDrones() {
        return new ResponseEntity<>(service.getAllDrones(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DroneInfo> getById(@PathVariable final String id) {
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

}
