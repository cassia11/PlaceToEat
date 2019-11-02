package br.com.placetoeat.api.v1.model;

import javax.persistence.*;

@Entity
@Table
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


}
