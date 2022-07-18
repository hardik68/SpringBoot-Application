package com.esample.springrest.entities;

import javax.persistence.*;

@Entity
public class KycEntities {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column()
    private String panNumber;

    private String AadharNumber;

    private String IfscCode;

    private String GstNumber;



}
