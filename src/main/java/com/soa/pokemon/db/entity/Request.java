package com.soa.pokemon.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
@Getter
@Setter
@Entity
@Table
public class Request {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String ipOrigin;
    @Column
    private Timestamp time;
    @Column
    private String method;

    public Request() { }
    public Request(Long id, String ipOrigin, Timestamp time, String method) {
        this.id = id;
        this.ipOrigin = ipOrigin;
        this.time = time;
        this.method = method;
    }
}
