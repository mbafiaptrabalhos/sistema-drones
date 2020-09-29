package br.com.fiap.kafkamessage.service;

import br.com.fiap.kafkamessage.dto.DroneInfoDTO;

import java.util.List;

public interface DroneInfoDTOService {

    DroneInfoDTO save(DroneInfoDTO droneInfoDTO);

    List<DroneInfoDTO> getAll();
}
