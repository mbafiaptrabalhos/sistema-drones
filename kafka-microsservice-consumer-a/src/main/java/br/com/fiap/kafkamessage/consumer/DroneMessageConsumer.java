package br.com.fiap.kafkamessage.consumer;

import br.com.fiap.kafkamessage.dto.DroneInfoDTO;
import br.com.fiap.kafkamessage.model.DroneInfo;
import br.com.fiap.kafkamessage.service.DroneInfoDTOService;
import br.com.fiap.kafkamessage.service.EmailService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@Component
public class DroneMessageConsumer {

    private CountDownLatch droneLatch = new CountDownLatch(1);
    private EmailService emailService;
    private DroneInfoDTOService droneInfoDTOService;
    private ModelMapper modelMapper;

    Logger logger = LoggerFactory.getLogger(DroneMessageConsumer.class  );

    public DroneMessageConsumer(EmailService emailService, DroneInfoDTOService droneInfoDTOService, ModelMapper modelMapper) {
        this.emailService = emailService;
        this.droneInfoDTOService = droneInfoDTOService;
        this.modelMapper = modelMapper;
    }

    @KafkaListener(topics = "${kafka.topic}", containerFactory = "droneInfoKafkaListenerContainerFactory")
    public void droneInfoListener(DroneInfo droneInfo) throws InterruptedException {

        int temperatura = Integer.parseInt(droneInfo.getTemperatura());
        int umidade = Integer.parseInt(droneInfo.getUmidade());

        if ( (temperatura >= 35 || temperatura <= 0)  || umidade <= 15 ) {
            emailService.sendSimpleMessage(droneInfo.getEmail(), "MONITORAMENTO DRONE", droneInfo.toString());

            DroneInfoDTO droneInfoDTOSaved = modelMapper.map(droneInfo, DroneInfoDTO.class);
            droneInfoDTOService.save(droneInfoDTOSaved);
            logger.info("email enviado");
        } else {
            logger.info("não há email a ser enviado");
        }
        this.droneLatch.await(1, TimeUnit.MINUTES);
    }
}
