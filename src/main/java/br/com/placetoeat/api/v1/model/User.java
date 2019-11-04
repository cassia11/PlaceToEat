package br.com.placetoeat.api.v1.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TypeUser type;

    @JsonProperty
    @Column(nullable = false, unique = true)
    private String username;

    @JsonProperty
    @ManyToOne
    private Team team;

    public User() {

    }

    public User(TypeUser type, String username, Team team) {
        this.type = type;
        this.username = username;
        this.team = team;
    }

    public Long getId() {
        return id;
    }

    public TypeUser getType() {
        return type;
    }

    public void setType(TypeUser type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", type=" + type +
                ", username='" + username + '\'' +
                ", team=" + team +
                '}';
    }
}
