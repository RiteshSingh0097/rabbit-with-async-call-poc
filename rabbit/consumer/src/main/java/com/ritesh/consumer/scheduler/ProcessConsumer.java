package com.ritesh.consumer.scheduler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ritesh.co.NameProcessCO;
import com.ritesh.common.entity.ServiceEntity;
import com.ritesh.service.EntityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class ProcessConsumer {

    @Autowired
    private EntityService entityService;

    @RabbitListener(queues = "${spring.process.queue}")
    public void receivedMessage(Integer serviceId) throws JsonProcessingException, InterruptedException {
        log.info("service id from rabbit :: " + serviceId);
        Thread.sleep(2000);
        var objectMapper = new ObjectMapper();
        Optional<ServiceEntity> serviceEntity = entityService.findById(serviceId);
        serviceEntity.ifPresent(entity -> log.info("data from queue ::" + entity.getData()));
        if (serviceEntity.isPresent()) {
            var serviceEntity1 = serviceEntity.get();
            var nameCo = objectMapper.readValue(serviceEntity1.getData(), NameProcessCO.class);
            nameCo.setName("Mr/Mrs. "+nameCo.getName());
            serviceEntity1.setData(objectMapper.writeValueAsString(nameCo));
            serviceEntity1.setStatus("SUCCESS");
            entityService.save(serviceEntity1);
        }
    }
}
