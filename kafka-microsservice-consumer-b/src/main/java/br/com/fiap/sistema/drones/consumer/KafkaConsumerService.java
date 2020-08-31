package br.com.fiap.sistema.drones.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.google.gson.Gson;

import br.com.fiap.sistema.drones.model.DroneInfo;

@Component
public class KafkaConsumerService {

	@Autowired
	private Gson gson;

	@KafkaListener(topics = "${drone.info.topic}", groupId = "${spring.kafka.consumer.group-id}")
	public void listener(@RequestBody String info) {
		System.out.println("Mensagem recebida: " + info);
		DroneInfo droneInfo = gson.fromJson(info, DroneInfo.class);
		System.out.println(droneInfo);

	}

}
