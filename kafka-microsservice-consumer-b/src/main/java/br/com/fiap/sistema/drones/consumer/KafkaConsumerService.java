package br.com.fiap.sistema.drones.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.com.fiap.sistema.drones.model.DroneInfo;
import br.com.fiap.sistema.drones.service.DroneInfoService;

@Component
public class KafkaConsumerService {

	@Autowired
	private DroneInfoService service;

	
	@KafkaListener(topics = "${kafka.drone.info.topic}", containerFactory = "kafkaJsonListenerContainerFactory")
	public void listener(@Payload DroneInfo info) {
		System.out.println("Mensagem recebida: " + info);
		service.save(info);

	}

}
