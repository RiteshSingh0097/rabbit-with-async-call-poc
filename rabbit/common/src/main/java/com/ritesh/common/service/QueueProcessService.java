package com.ritesh.common.service;

import com.ritesh.common.dto.OuterResponse;

public interface QueueProcessService {
    OuterResponse process(String data, String exchange, String routing);
}
