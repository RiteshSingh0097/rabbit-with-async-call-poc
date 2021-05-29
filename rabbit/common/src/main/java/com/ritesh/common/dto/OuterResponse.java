package com.ritesh.common.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OuterResponse {
    String status;
    String msg;
    Integer id;

    public OuterResponse(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }
}
