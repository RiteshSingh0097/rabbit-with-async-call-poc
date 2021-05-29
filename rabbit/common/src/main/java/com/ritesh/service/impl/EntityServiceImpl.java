package com.ritesh.service.impl;

import com.ritesh.common.entity.ServiceEntity;
import com.ritesh.common.repository.ServiceRepository;
import com.ritesh.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EntityServiceImpl implements EntityService {

    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public void save(ServiceEntity serviceEntity) {
        serviceRepository.save(serviceEntity);
    }

    public Optional<ServiceEntity> findById(Integer id) {
        return serviceRepository.findById(id);
    }
}
