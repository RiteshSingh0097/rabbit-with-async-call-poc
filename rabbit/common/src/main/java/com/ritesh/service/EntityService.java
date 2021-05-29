package com.ritesh.service;


import com.ritesh.common.entity.ServiceEntity;

import java.util.Optional;

public interface EntityService {
    void save(ServiceEntity serviceEntity);

    Optional<ServiceEntity> findById(Integer id);
}
