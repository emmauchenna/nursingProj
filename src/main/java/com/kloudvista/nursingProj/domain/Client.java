package com.kloudvista.nursingProj.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Transactional
@Table(name = "clients")
public class Client {
    private Long clientId;
    private String name;
    private String location;
}
