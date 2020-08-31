package br.com.fiap.sistema.drones.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.fiap.sistema.drones.exception.DroneNaoEncontradoException;
import br.com.fiap.sistema.drones.model.DroneInfo;
import br.com.fiap.sistema.drones.repository.DroneInfoRepository;

public class DroneInfoService {

	@Autowired
	private DroneInfoRepository repository;

	public List<DroneInfo> getAllDrones() {
		return repository.findAll();
	}

	public DroneInfo save(DroneInfo drone) {
		return repository.save(drone);
	}

	public void delete(Long id) {
		if (repository.findById(id).isPresent()) {
			repository.delete(repository.findById(id).get());
		} else {
			throw new DroneNaoEncontradoException();
		}
	}

	public DroneInfo getById(Long id) {
		if (repository.findById(id).isPresent()) {
			return repository.findById(id).get();
		} else {
			throw new DroneNaoEncontradoException();
		}

	}

}