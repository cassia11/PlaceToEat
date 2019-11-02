package br.com.placetoeat.api.v1.model;

import javax.persistence.*;

@Entity
@Table
public class Voting {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
}
