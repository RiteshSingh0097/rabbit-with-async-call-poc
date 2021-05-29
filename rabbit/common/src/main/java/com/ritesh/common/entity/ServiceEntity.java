package com.ritesh.common.entity;

import com.ritesh.common.constant.Constants;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = Constants.SERVICE)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ServiceEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Constants.ID)
    int id;
    @Column(name = Constants.DATA)
    String data;
    @Column(name = Constants.STATUS)
    String status;
    @Column(name = Constants.CREATED)
    @CreationTimestamp
    LocalDateTime created;
    @Column(name = Constants.UPDATED)
    @UpdateTimestamp
    LocalDateTime updated;

    public ServiceEntity() {
    }

    public ServiceEntity(String data) {
        this.data = data;
    }
}
