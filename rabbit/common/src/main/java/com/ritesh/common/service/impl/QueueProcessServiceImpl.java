package com.ritesh.common.service.impl;

import com.ritesh.common.constant.Constants;
import com.ritesh.common.dto.OuterResponse;
import com.ritesh.common.entity.ServiceEntity;
import com.ritesh.common.service.QueueProcessService;
import com.ritesh.service.EntityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class QueueProcessServiceImpl implements QueueProcessService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private EntityService entityService;

    @Override
    public OuterResponse process(String data, String exchange, String routing) {
        var service = new ServiceEntity(data);
        service.setStatus("INPROGRESS");
        entityService.save(service);
        rabbitTemplate.convertAndSend(exchange, routing, service.getId());
        var outerResponse = new OuterResponse();
        outerResponse.setStatus(Constants.SUCCESS);
        outerResponse.setId(service.getId());
        outerResponse.setMsg(Constants.SUCCESS);
        return outerResponse;
    }
}
