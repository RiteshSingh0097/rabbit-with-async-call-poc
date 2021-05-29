package com.ritesh.producer.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ritesh.co.NameProcessCO;
import com.ritesh.common.dto.OuterResponse;
import com.ritesh.common.service.QueueProcessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/")
public class ProcessController {

    @Autowired
    private QueueProcessService processService;

    @Value("${spring.process.exchange-key}")
    private String exchange;

    @Value("${spring.process.routing-key}")
    private String routing;

    @PostMapping("process")
    public OuterResponse process(@RequestBody NameProcessCO nameProcessCO) {
        var objectMapper = new ObjectMapper();
        try {
            return processService.process(objectMapper.writeValueAsString(nameProcessCO), exchange, routing);
        } catch (Exception e) {
            log.error("Error while processing ::", e);
        }
        return null;
    }
}
