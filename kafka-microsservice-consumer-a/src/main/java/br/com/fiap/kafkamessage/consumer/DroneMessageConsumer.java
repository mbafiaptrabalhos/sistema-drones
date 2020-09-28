package br.com.fiap.kafkamessage.consumer;

import br.com.fiap.kafkamessage.model.DroneInfo;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@Component
public class DroneMessageConsumer {

    public CountDownLatch droneLatch = new CountDownLatch(1);

    @KafkaListener(topics = "${kafka.topic}", containerFactory = "droneInfoKafkaListenerContainerFactory")
    public void droneInfoListener(DroneInfo droneInfo) throws InterruptedException {
        System.out.println(droneInfo.toString());
        this.droneLatch.await(1, TimeUnit.MINUTES);
    }
}
