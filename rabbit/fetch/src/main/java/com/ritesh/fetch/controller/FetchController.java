package com.ritesh.fetch.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ritesh.co.NameProcessCO;
import com.ritesh.common.dto.OuterResponse;
import com.ritesh.common.entity.ServiceEntity;
import com.ritesh.service.EntityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/")
public class FetchController {

    @Autowired
    private EntityService entityService;

    @GetMapping("id/{id}")
    public OuterResponse fetch(@PathVariable("id") Integer id) {
        var outerResponse = new OuterResponse("FAIL", "FAIL");
        try {
            Optional<ServiceEntity> serviceEntity = entityService.findById(id);
            if (serviceEntity.isPresent()) {
                var co = new ObjectMapper().readValue(serviceEntity.get().getData(), NameProcessCO.class);
                outerResponse.setMsg(co.getName());
                outerResponse.setStatus(serviceEntity.get().getStatus());
                outerResponse.setId(serviceEntity.get().getId());
            }
        } catch (Exception e) {
            log.error("Error while processing ::", e);
        }
        return outerResponse;
    }
}
