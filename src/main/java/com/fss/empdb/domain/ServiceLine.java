package com.fss.empdb.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "service_line")
public class ServiceLine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SERVICE_LINE_ID")
    Long serviceLineId;

    public ServiceLine() {

    }

    @Column(name = "SERVICE_LINE_NAME", nullable = false)
    String serviceLineName;

    @OneToMany(mappedBy = "serviceLine", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Employee> employees;
}

