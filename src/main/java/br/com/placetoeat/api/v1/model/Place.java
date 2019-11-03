package br.com.placetoeat.api.v1.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table
@JsonIgnoreProperties(ignoreUnknown = true)
public class Place {

    @JsonProperty
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonProperty
    @Column(nullable = false)
    private String nome;

    public Place(){

    }
    public Place(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
