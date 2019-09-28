package com.numberconverter.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Builder
@Entity
@Table(name = "log")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private Timestamp timestamp;

    @Column
    private String description;

    @Column(length = 3000)
    private String request;

    @Column(length = 3000)
    private String response;

}
