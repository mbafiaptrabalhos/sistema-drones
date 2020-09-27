package br.com.fiap.kafkaproducer.controller;

import br.com.fiap.kafkaproducer.model.DroneInfo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producer")
public class ProduceController {

    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProducer(@RequestBody DroneInfo droneInfo) {
        DroneInfo droneInfo1 = droneInfo;

        System.out.println(droneInfo.toString());
    }
}
